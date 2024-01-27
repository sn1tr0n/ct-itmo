package airline

import airline.api.*
import airline.service.*
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant

class AirlineApplication(private val config: AirlineConfig, emailService: EmailService) {
    companion object {
        val Duration.positive
            get() = if (this.isNegative()) 0.seconds else this
    }

    private val flightsFlow = MutableStateFlow<List<Flight>>(listOf())
    private val eventsFlow = MutableSharedFlow<AirlineEvent>()

    private val bufferedEmailService = BufferedEmailService(emailService)
    private val passengerNotificationService = PassengerNotificationServiceImpl(bufferedEmailService)

    val bookingService: BookingServices =
        BookingServicesImpl(
            flightsFlow,
            eventsFlow,
            config,
        )
    val managementService: AirlineManagementService = AirlineManagementServiceImpl(eventsFlow)

    @OptIn(FlowPreview::class)
    fun airportInformationDisplay(coroutineScope: CoroutineScope): StateFlow<InformationDisplay> =
        flightsFlow
            .debounce(config.displayUpdateInterval)
            .map { flights -> InformationDisplay(flights.map { FlightInfo(it) }) }
            .stateIn(
                coroutineScope,
                SharingStarted.Eagerly,
                InformationDisplay(flightsFlow.value.map { FlightInfo(it) }),
            )

    val airportAudioAlerts: Flow<AudioAlerts>
        get() =
            flow {
                while (true) {
                    val now = Clock.System.now()

                    flightsFlow.value.forEach {
                        if (it.checkInNumber != null) {
                            sendAudioAlertChecking(now, it, config.registrationOpeningTime) {
                                AudioAlerts.RegistrationOpen(
                                    it.flightId,
                                    it.checkInNumber,
                                )
                            }

                            sendAudioAlertChecking(now, it, config.registrationClosingTime, negate = true) {
                                AudioAlerts.RegistrationClosing(
                                    it.flightId,
                                    it.checkInNumber,
                                )
                            }
                        }

                        if (it.gateNumber != null) {
                            sendAudioAlertChecking(now, it, config.boardingOpeningTime) {
                                AudioAlerts.BoardingOpened(
                                    it.flightId,
                                    it.gateNumber,
                                )
                            }

                            sendAudioAlertChecking(now, it, config.boardingClosingTime, negate = true) {
                                AudioAlerts.BoardingClosing(
                                    it.flightId,
                                    it.gateNumber,
                                )
                            }
                        }
                    }

                    delay(config.audioAlertsInterval)
                }
            }

    suspend fun run() {
        coroutineScope {
            launch { bufferedEmailService.run() }
            launch { passengerNotificationService.run() }
            launch { processEvents() }
        }
    }

    context(FlowCollector<AudioAlerts>)
    private suspend fun sendAudioAlertChecking(
        now: Instant,
        flight: Flight,
        delta: Duration,
        negate: Boolean = false,
        eventProducer: () -> AudioAlerts,
    ) {
        var calculated = now - (flight.actualDepartureTime - delta)

        if (negate) {
            calculated = -calculated
        }

        if (!calculated.isNegative() && calculated.positive < config.audioAlertPeriod) {
            emit(eventProducer())
        }
    }

    private suspend fun processEvents() {
        eventsFlow.collect { event ->
            when (event) {
                is ManagementEvent -> {
                    when (event) {
                        is ManagementEvent.ScheduleFlight -> {
                            flightsFlow.update { flights ->
                                flights +
                                    Flight(
                                        flightId = event.flightId,
                                        departureTime = event.departureTime,
                                        plane = event.plane,
                                    )
                            }
                        }

                        is ManagementEvent.UpdateFlightEvent -> updateFlightEventProcessor(event)
                    }
                }

                is BookingEvent.BuyTicket -> buyTicket(event)
            }
        }
    }

    private suspend fun buyTicket(event: BookingEvent.BuyTicket) {
        flightsFlow.update { flights ->
            val flightIndex =
                flights.indexOfFirst {
                    event.flightId == it.flightId &&
                        event.departureTime == it.departureTime
                }

            if (flightIndex == -1) {
                bufferedEmailService.sendEmailNotification(EmailTextTemplates.wrongFlightTemplate(event))

                return
            }

            val flight = flights[flightIndex]

            if (flight.isCancelled) {
                bufferedEmailService.sendEmailNotification(EmailTextTemplates.flightIsCanceled(event))

                return
            }

            if (flight.departureTime - config.ticketSaleEndTime <= Clock.System.now()) {
                bufferedEmailService.sendEmailNotification(EmailTextTemplates.ticketBuyClosed(event))

                return
            }

            val tickets = flight.tickets.toMutableMap()

            if (event.seatNo !in flight.plane.seats) {
                bufferedEmailService.sendEmailNotification(EmailTextTemplates.seatDoesNotExist(event))

                return
            }

            if (tickets.putIfAbsent(
                    event.seatNo,
                    Ticket(
                        flightId = flight.flightId,
                        departureTime = flight.departureTime,
                        seatNo = event.seatNo,
                        passengerEmail = event.passengerEmail,
                        passengerId = event.passengerId,
                        passengerName = event.passengerName,
                    ),
                ) == null
            ) {
                bufferedEmailService.sendEmailNotification(EmailTextTemplates.successBookingTemplate(event))
            } else {
                bufferedEmailService.sendEmailNotification(EmailTextTemplates.seatIsTakenTemplate(event))
                return
            }

            flights.toMutableList().apply {
                this[flightIndex] = flight.copy(tickets = tickets)
            }
        }
    }

    private suspend fun sendNotificationAndReturn(
        flight: Flight,
        template: Flight.() -> List<EmailNotification>,
    ): Flight {
        passengerNotificationService.sendNotification(
            flight,
            template,
        )

        return flight
    }

    private suspend fun updateFlightEventMatcher(
        flight: Flight,
        event: ManagementEvent.UpdateFlightEvent,
    ): Flight {
        return when (event) {
            is ManagementEvent.UpdateFlightEvent.DelayFlight -> {
                sendNotificationAndReturn(
                    flight.copy(actualDepartureTime = event.actualDepartureTime),
                    NotificationTextTemplates.delayedFlightTemplate,
                )
            }

            is ManagementEvent.UpdateFlightEvent.CancelFlight -> {
                sendNotificationAndReturn(
                    flight.copy(isCancelled = true),
                    NotificationTextTemplates.canceledFlightTemplate,
                )
            }

            is ManagementEvent.UpdateFlightEvent.SetCheckInNumber -> {
                sendNotificationAndReturn(
                    flight.copy(checkInNumber = event.checkInNumber),
                    NotificationTextTemplates.setCheckInFlightTemplate,
                )
            }

            is ManagementEvent.UpdateFlightEvent.SetGateNumber -> {
                sendNotificationAndReturn(
                    flight.copy(gateNumber = event.gateNumber),
                    NotificationTextTemplates.setGateNumberFlightTemplate,
                )
            }
        }
    }

    private suspend fun updateFlightEventProcessor(event: ManagementEvent.UpdateFlightEvent) {
        flightsFlow.update { flights ->
            flights.map {
                if (event.flightId == it.flightId && event.departureTime == it.departureTime) {
                    return@map updateFlightEventMatcher(it, event)
                }

                it.copy()
            }
        }
    }
}
