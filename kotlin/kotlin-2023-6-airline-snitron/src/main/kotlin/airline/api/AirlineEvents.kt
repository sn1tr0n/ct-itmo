package airline.api

import kotlinx.datetime.Instant

sealed interface AirlineEvent

sealed interface ManagementEvent : AirlineEvent {
    data class ScheduleFlight(val flightId: String, val departureTime: Instant, val plane: Plane) : ManagementEvent

    sealed class UpdateFlightEvent(val flightId: String, val departureTime: Instant) : ManagementEvent {
        class DelayFlight(flightId: String, departureTime: Instant, val actualDepartureTime: Instant) :
            UpdateFlightEvent(flightId, departureTime)

        class CancelFlight(flightId: String, departureTime: Instant) :
            UpdateFlightEvent(flightId, departureTime)

        class SetCheckInNumber(flightId: String, departureTime: Instant, val checkInNumber: String) :
            UpdateFlightEvent(flightId, departureTime)

        class SetGateNumber(flightId: String, departureTime: Instant, val gateNumber: String) :
            UpdateFlightEvent(flightId, departureTime)
    }

}

sealed interface BookingEvent : AirlineEvent {
    data class BuyTicket(
        val flightId: String,
        val departureTime: Instant,
        val seatNo: String,
        val passengerId: String,
        val passengerName: String,
        val passengerEmail: String,
    ) : BookingEvent
}
