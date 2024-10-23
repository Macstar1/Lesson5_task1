data class Message(val text: String, var isRead: Boolean = false)
data class Chat(val messages: MutableList<Message> = mutableListOf())

object NoSuchChatException: RuntimeException()

class ChatService {
    private var chats = mutableMapOf<Int, Chat>()

    fun sendMessage(userId: Int, message: Message) {
        chats.getOrPut(userId) { Chat() }.messages += message
    }

    fun getUnreadChatsCount() = chats.values.count { chat -> chat.messages.any { !it.isRead } }

    fun getLastMessage() = chats.values.map { chat -> chat.messages.lastOrNull()?.text ?: "No messages" }

    fun getMessages(userId: Int, count: Int): List<Message> {
        val chat = chats[userId] ?: throw NoSuchChatException
        return chat.messages.takeLast(count).onEach { it.isRead = true }
    }

    fun printChat() = println(chats)
}
