package airline.service

import airline.api.EmailNotification
import airline.api.Flight

interface PassengerNotificationService {
    /**
     * Sends notifications to passengers
     */
    suspend fun sendNotification(
        flight: Flight,
        messagesProducer: Flight.() -> List<EmailNotification>,
    )

}
