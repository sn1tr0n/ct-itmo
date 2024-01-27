package airline.api

import kotlinx.datetime.Instant

data class FlightInfo(
    val flightId: String,
    val departureTime: Instant,
    val isCancelled: Boolean = false,
    val actualDepartureTime: Instant = departureTime,
    val checkInNumber: String? = null,
    val gateNumber: String? = null,
    val plane: Plane,
) {
    constructor(flight: Flight) : this(
        flightId = flight.flightId,
        departureTime = flight.departureTime,
        isCancelled = flight.isCancelled,
        actualDepartureTime = flight.actualDepartureTime,
        checkInNumber = flight.checkInNumber,
        gateNumber = flight.gateNumber,
        plane = flight.plane,
    )
}
