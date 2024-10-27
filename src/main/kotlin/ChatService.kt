data class Message(val text: String, var isRead: Boolean = false)
data class Chat(var messages: MutableList<Message> = mutableListOf())

object NoSuchChatException : RuntimeException()

class ChatService {
    private var chats = mutableMapOf<Int, Chat>()

    //1
    fun getUnreadChatsCount() = chats.values.count { chat -> chat.messages.any { !it.isRead } }

    //2
    fun getChats() = chats.entries

    //3
    fun getLastMessages() = chats.values.map { chat -> chat.messages.lastOrNull()?.text ?: "No messages" }

    //4
    fun getMessages(userId: Int, count: Int): List<Message> {
        val chat = chats[userId] ?: throw NoSuchChatException
        return chat.messages.takeLast(count).onEach { it.isRead = true }
    }

    //5_7
    fun sendMessage(userId: Int, message: Message) {
        chats.getOrPut(userId) { Chat() }.messages += message
    }

    //6
    fun deleteMessage(userId: Int, messageId: Int) {
        chats[userId]?.messages?.removeAt(messageId) ?: "No messages"
    }

    //8
    fun deleteChat(chatId: Int) {
        chats.remove(chatId)
    }

    fun printChat() = println(chats)
}
