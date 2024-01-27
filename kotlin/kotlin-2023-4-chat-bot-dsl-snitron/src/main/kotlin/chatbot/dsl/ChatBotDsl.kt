package chatbot.dsl

import chatbot.api.*

@ChatBotMarker
class ChatBotDsl(private val client: Client) {
    private var logLevel = LogLevel.ERROR
    private val logger = Logger(logLevel)

    var contextManager: ChatContextsManager = DefaultChatsContextManager()
    var messageProcessors: List<MessageProcessorRuntime<ChatContext?>> = listOf()

    val chatBot =
        object : ChatBot {
            override val logLevel: LogLevel
                get() = this@ChatBotDsl.logLevel

            override fun processMessages(message: Message) {
                logger.info("got message $message")
                val messageProcessorContext =
                    MessageProcessorContext(
                        message = message,
                        client = client,
                        context = contextManager.getContext(message.chatId),
                        setContext = { contextManager.setContext(message.chatId, it) },
                        logger = logger,
                    )

                val bestMatch: Any? = messageProcessors.firstOrNull { it(messageProcessorContext) }

                if (bestMatch == null) {
                    logger.error("no processor found for message: $message")
                } else {
                    logger.info("found processor: $bestMatch")
                }
            }
        }

    fun use(logLevel: LogLevel) {
        this.logLevel = logLevel
    }

    fun use(chatContextsManager: ChatContextsManager) {
        this.contextManager = chatContextsManager
    }

    fun behaviour(builder: IntoBehaviourDSLBuilder.() -> Unit) {
        messageProcessors = IntoBehaviourDSLBuilder(chatBot).apply(builder).build()
    }

    operator fun LogLevel.unaryPlus() {
        logLevel = this
    }
}

fun chatBot(
    client: Client,
    chatBotBuilder: ChatBotDsl.() -> Unit,
): ChatBot = ChatBotDsl(client).apply(chatBotBuilder).chatBot
