package chatbot.dsl

import chatbot.api.ChatBot
import chatbot.api.ChatContext
import chatbot.api.Message

@Target(AnnotationTarget.CLASS, AnnotationTarget.TYPE, AnnotationTarget.VALUE_PARAMETER)
@DslMarker
annotation class ChatBotMarker

typealias MessageProcessorRuntime<C> = MessageProcessorContext<C>.() -> Boolean

@ChatBotMarker
open class BehaviourDSLBuilder<T : ChatContext?>(
    val chatBot: ChatBot,
) {
    val processors = mutableListOf<MessageProcessorRuntime<T>>()

    private fun addPredicateWrapper(
        predicate: ChatBot.(Message) -> Boolean,
        processor: MessageProcessor<T>,
    ) {
        processors.add {
            if (
                predicate.invoke(this@BehaviourDSLBuilder.chatBot, message)
            ) {
                processor()
                return@add true
            }

            false
        }
    }

    fun onCommand(
        command: String,
        processor: MessageProcessor<T>,
    ) = addPredicateWrapper(
        { "/$command" == it.text.split(" ")[0] },
        processor,
    )

    fun onMessage(
        predicate: ChatBot.(Message) -> Boolean,
        processor: MessageProcessor<T>,
    ) = addPredicateWrapper(predicate, processor)

    fun onMessage(processor: MessageProcessor<T>) = addPredicateWrapper({ true }, processor)

    fun onMessage(
        messageTextExactly: String,
        processor: MessageProcessor<T>,
    ) = addPredicateWrapper(
        { messageTextExactly == it.text },
        processor,
    )

    fun onMessagePrefix(
        prefix: String,
        processor: MessageProcessor<T>,
    ) = addPredicateWrapper(
        { it.text.startsWith(prefix) },
        processor,
    )

    fun onMessageContains(
        text: String,
        processor: MessageProcessor<T>,
    ) = addPredicateWrapper(
        { text in it.text },
        processor,
    )

    fun MessageProcessorPredicate.into(scope: BehaviourDSLBuilder<T>.() -> Unit) {
        BehaviourDSLBuilder<T>(chatBot).apply(scope)
            .build().let { childProcessors ->
                processors.add {
                    if (this@into(message)) {
                        return@add childProcessors.firstOrNull { it() } != null
                    }

                    false
                }
            }
    }

    fun build(): List<MessageProcessorRuntime<T>> = processors
}

@ChatBotMarker
class IntoBehaviourDSLBuilder(
    chatBot: ChatBot,
) : BehaviourDSLBuilder<ChatContext?>(chatBot) {
    inline fun <reified C : ChatContext?> into(scope: BehaviourDSLBuilder<C>.() -> Unit) {
        BehaviourDSLBuilder<C>(chatBot).apply(scope).build()
            .let { childProcessors ->
                processors.add {
                    if (context is C) {
                        return@add childProcessors.firstOrNull {
                            return@firstOrNull it(
                                MessageProcessorContext(
                                    message,
                                    client,
                                    context,
                                    setContext,
                                    logger,
                                ),
                            )
                        } != null
                    }

                    false
                }
            }
    }

    inline infix fun <reified C : ChatContext?> C.into(scope: BehaviourDSLBuilder<C>.() -> Unit) {
        BehaviourDSLBuilder<C>(chatBot).apply(scope).build()
            .let { childProcessors ->
                processors.add {
                    if (context == this@into && context is C) {
                        return@add childProcessors.firstOrNull {
                            return@firstOrNull it(
                                MessageProcessorContext(
                                    message,
                                    client,
                                    context,
                                    setContext,
                                    logger,
                                ),
                            )
                        } != null
                    }

                    false
                }
            }
    }
}
