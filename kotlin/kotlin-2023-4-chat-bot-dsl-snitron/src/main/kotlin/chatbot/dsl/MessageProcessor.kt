package chatbot.dsl

import chatbot.api.ChatContext
import chatbot.api.ChatId
import chatbot.api.Client
import chatbot.api.Message

@ChatBotMarker
class MessageProcessorContext<C : ChatContext?>(
    val message: Message,
    val client: Client,
    val context: C,
    val setContext: (c: ChatContext?) -> Unit,
    val logger: Logger,
) {
    fun sendMessage(
        chatId: ChatId,
        sender: SendMessageDsl.() -> Unit,
    ) {

        MapSqlBui
        SendMessageDsl(client = client, chatId = chatId, logger = logger).apply(sender).send()
    }
}

typealias MessageProcessor<C> = MessageProcessorContext<C>.() -> Unit
typealias MessageProcessorPredicate = (Message) -> Boolean

operator fun MessageProcessorPredicate.times(other: MessageProcessorPredicate): MessageProcessorPredicate =
    {
        this(it) && other(it)
    }
