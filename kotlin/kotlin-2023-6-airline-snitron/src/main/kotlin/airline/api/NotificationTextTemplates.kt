package airline.api

object NotificationTextTemplates {
    private fun mapToNotificationForAll(
        flight: Flight,
        filler: (Ticket) -> String,
    ): List<EmailNotification> =
        flight.tickets.values.map {
            EmailNotification(to = it.passengerEmail, message = filler(it))
        }

    val delayedFlightTemplate: Flight.() -> List<EmailNotification> = {
        mapToNotificationForAll(this) {
            """
                Dear ${it.passengerName}! Unfortunately, your flight $flightId was delayed.
                Actual time: $actualDepartureTime
                Sorry for inconvenience
            """
        }
    }

    val canceledFlightTemplate: Flight.() -> List<EmailNotification> = {
        mapToNotificationForAll(this) {
            """
                Dear ${it.passengerName}! Unfortunately, your flight $flightId was cancelled.
                Sorry for inconvenience
            """
        }
    }

    val setCheckInFlightTemplate: Flight.() -> List<EmailNotification> = {
        mapToNotificationForAll(this) {
            """
                Dear ${it.passengerName}! For your flight $flightId was set check-in point $checkInNumber.
            """
        }
    }

    val setGateNumberFlightTemplate: Flight.() -> List<EmailNotification> = {
        mapToNotificationForAll(this) {
            """
                Dear ${it.passengerName}! For your flight $flightId was set gate $gateNumber.
            """
        }
    }
}
