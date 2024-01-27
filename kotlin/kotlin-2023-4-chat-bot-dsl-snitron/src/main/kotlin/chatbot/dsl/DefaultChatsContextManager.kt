package chatbot.dsl

import chatbot.api.ChatContext
import chatbot.api.ChatContextsManager
import chatbot.api.ChatId

class DefaultChatsContextManager(
    private val chatContexts: MutableMap<ChatId, ChatContext> = mutableMapOf(),
) : ChatContextsManager {
    override fun getContext(chatId: ChatId): ChatContext? = chatContexts[chatId]

    override fun setContext(
        chatId: ChatId,
        newState: ChatContext?,
    ) {
        if (newState == null) {
            chatContexts.remove(chatId)
            return
        }

        chatContexts[chatId] = newState
    }
}
