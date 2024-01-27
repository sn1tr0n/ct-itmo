fun sendMessageToClient(
    client: Client?,
    message: String?,
    mailer: Mailer
) {
    val email: String? = client?.personalInfo?.email

    if (email != null) {
        mailer.sendMessage(email, message ?: "Hello!")
    }
}
