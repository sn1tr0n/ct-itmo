package airline.service

import airline.api.AirlineConfig
import airline.api.BookingEvent
import airline.api.Flight
import airline.api.FlightInfo
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant

class BookingServicesImpl(
    private val flightsFlow: StateFlow<List<Flight>>,
    private val bookingEventsFlow: MutableSharedFlow<in BookingEvent>,
    private val config: AirlineConfig,
) : BookingServices {
    override val flightSchedule: List<FlightInfo>
        get() =
            flightsFlow.value
                .asSequence()
                .filter {
                    it.plane.seats.size > it.tickets.size
                }.filter {
                    it.departureTime - config.ticketSaleEndTime > Clock.System.now()
                }.map {
                    FlightInfo(it)
                }.toList()

    override fun freeSeats(
        flightId: String,
        departureTime: Instant,
    ): Set<String> =
        flightsFlow.value
            .firstOrNull { it.flightId == flightId && it.actualDepartureTime == departureTime }
            ?.let {
                it.plane.seats - it.tickets.keys
            } ?: setOf()

    override suspend fun buyTicket(
        flightId: String,
        departureTime: Instant,
        seatNo: String,
        passengerId: String,
        passengerName: String,
        passengerEmail: String,
    ) = bookingEventsFlow.emit(
        BookingEvent.BuyTicket(
            flightId,
            departureTime,
            seatNo,
            passengerId,
            passengerName,
            passengerEmail,
        ),
    )
}
