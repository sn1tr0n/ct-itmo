package airline.service

interface EmailService {
    suspend fun send(
        to: String,
        text: String,
    )
}
