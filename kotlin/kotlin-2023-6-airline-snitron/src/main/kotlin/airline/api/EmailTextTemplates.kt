package airline.api

object EmailTextTemplates {
    private fun mapToDirectEmail(
        event: BookingEvent.BuyTicket,
        filler: () -> String,
    ): EmailNotification =
        event.run {
            EmailNotification(to = passengerEmail, message = filler())
        }

    val successBookingTemplate: BookingEvent.BuyTicket.() -> EmailNotification = {
        mapToDirectEmail(this) {
            """
            Dear $passengerName! You have successfully bought ticket for flight $flightId.
            Departure time: $departureTime
            Seat: $seatNo
            
            We wish you a great flight!
            """
        }
    }

    val wrongFlightTemplate: BookingEvent.BuyTicket.() -> EmailNotification = {
        mapToDirectEmail(this) {
            """
            Hello $passengerName! You have been tried to book ticket for flight $flightId.
            Unfortunately, there is no flight with this id at the moment.
            Failed to buy. Please, try again later.
            """
        }
    }

    val seatIsTakenTemplate: BookingEvent.BuyTicket.() -> EmailNotification = {
        mapToDirectEmail(this) {
            """
                Hello $passengerName! You have been tried to book ticket for flight $flightId.
                Unfortunately, seat $seatNo is already taken.
                Failed to buy. Please, try choose another one.
            """
        }
    }

    val seatDoesNotExist: BookingEvent.BuyTicket.() -> EmailNotification = {
        mapToDirectEmail(this) {
            """
                Hello $passengerName! You have been tried to book ticket for flight $flightId.
                Unfortunately, seat $seatNo does not exist.
                Failed to buy. Please, try choose another one.
            """
        }
    }

    val flightIsCanceled: BookingEvent.BuyTicket.() -> EmailNotification = {
        mapToDirectEmail(this) {
            """
                Hello $passengerName! You have been tried to book ticket for flight $flightId, that is cancelled.
                Failed to buy. Please, try choose another one.
            """
        }
    }

    val ticketBuyClosed: BookingEvent.BuyTicket.() -> EmailNotification = {
        mapToDirectEmail(this) {
            """
                Hello $passengerName! You have been tried to book ticket for flight $flightId, but tickets sell is closed already.
                Failed to buy. Please, try choose another one.
            """
        }
    }
}
