package chatbot.dsl

import chatbot.api.*

class SendMessageDsl(
    private val client: Client,
    private val chatId: ChatId,
    private val logger: Logger,
) {
    var text: String = ""
    var replyTo: MessageId? = null
    private var keyboard: Keyboard? = null

    fun removeKeyboard() {
        keyboard = Keyboard.Remove
    }

    fun withKeyboard(builder: WithKeyboardDsl.() -> Unit) {
        keyboard = WithKeyboardDsl().apply(builder).build()
    }

    fun send() {
        if (text.isBlank() && keyboard !is Keyboard.Remove) {
            if (keyboard == null) {
                logger.error("attempt to send message with `null` keyboard")
                return
            }

            val keyboardButtons = (keyboard as? Keyboard.Markup)?.keyboard
            if (keyboardButtons.isNullOrEmpty() || keyboardButtons.all { it.isEmpty() }) {
                logger.error("attempt to send message with empty keyboard")
                return
            }
        }

        logger.info(
            "successfully passed assertions for message with " +
                "chatId=$chatId text=$text keyboard=$keyboard replyTo=$replyTo",
        )
        client.sendMessage(chatId, text, keyboard, replyTo)
    }
}

@ChatBotMarker
class WithKeyboardDsl {
    var oneTime: Boolean = false
    var keyboard = mutableListOf<MutableList<Keyboard.Button>>()

    fun row(builder: RowDsl.() -> Unit) {
        keyboard.add(RowDsl().apply(builder).build())
    }

    fun build() = Keyboard.Markup(oneTime = oneTime, keyboard = keyboard)
}

@ChatBotMarker
class RowDsl {
    private val buttons = mutableListOf<Keyboard.Button>()

    fun button(text: String) = buttons.add(Keyboard.Button(text))

    fun build(): MutableList<Keyboard.Button> = buttons

    operator fun String.unaryMinus() = buttons.add(Keyboard.Button(this))
}
