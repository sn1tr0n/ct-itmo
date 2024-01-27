package airline.service

import airline.api.ManagementEvent
import airline.api.Plane
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.datetime.Instant

class AirlineManagementServiceImpl(
    private val managementFlow: MutableSharedFlow<in ManagementEvent>,
) : AirlineManagementService {
    override suspend fun scheduleFlight(
        flightId: String,
        departureTime: Instant,
        plane: Plane,
    ) = managementFlow.emit(ManagementEvent.ScheduleFlight(flightId, departureTime, plane))

    override suspend fun delayFlight(
        flightId: String,
        departureTime: Instant,
        actualDepartureTime: Instant,
    ) = managementFlow.emit(
        ManagementEvent.UpdateFlightEvent.DelayFlight(flightId, departureTime, actualDepartureTime),
    )

    override suspend fun cancelFlight(
        flightId: String,
        departureTime: Instant,
    ) = managementFlow.emit(
        ManagementEvent.UpdateFlightEvent.CancelFlight(flightId, departureTime),
    )

    override suspend fun setCheckInNumber(
        flightId: String,
        departureTime: Instant,
        checkInNumber: String,
    ) = managementFlow.emit(
        ManagementEvent.UpdateFlightEvent.SetCheckInNumber(flightId, departureTime, checkInNumber),
    )

    override suspend fun setGateNumber(
        flightId: String,
        departureTime: Instant,
        gateNumber: String,
    ) = managementFlow.emit(
        ManagementEvent.UpdateFlightEvent.SetGateNumber(flightId, departureTime, gateNumber),
    )
}
