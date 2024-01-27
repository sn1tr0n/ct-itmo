package airline.service

import airline.api.EmailNotification
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach

class BufferedEmailService(
    private val mainEmailService: EmailService,
    bufferSize: Int = DEFAULT_BUFFER_SIZE,
) : EmailService {
    private companion object {
        const val DEFAULT_BUFFER_SIZE = 100
    }

    private val buffer =
        Channel<EmailNotification>(
            capacity = bufferSize,
        )

    suspend fun run() {
        buffer.consumeEach {
            mainEmailService.send(it.to, it.message)
        }
    }

    override suspend fun send(
        to: String,
        text: String,
    ) {
        buffer.send(EmailNotification(to, text))
    }

    suspend fun sendEmailNotification(emailNotification: EmailNotification) {
        buffer.send(emailNotification)
    }

}
