package airline.service

import airline.api.EmailNotification
import airline.api.Flight
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach

class PassengerNotificationServiceImpl(private val emailService: EmailService) : PassengerNotificationService {
    private val channel =
        Channel<EmailNotification>(
            capacity = Channel.UNLIMITED,
        )

    suspend fun run() {
        channel.consumeEach {
            emailService.send(it.to, it.message)
        }
    }

    override suspend fun sendNotification(
        flight: Flight,
        messagesProducer: Flight.() -> List<EmailNotification>,
    ) = messagesProducer(flight)
        .forEach { channel.send(it) }

}
