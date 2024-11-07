import org.junit.Test

import org.junit.Assert.*

class ChatServiceTest {
    private var chatService: ChatService = ChatService()
    private var chats = mutableMapOf<Int, Chat>()


    @Test
    fun getUnreadChatsCount() {
        chatService.sendMessage(1, Message("Hi", true))
        chatService.sendMessage(2, Message("Hi"))
        chatService.sendMessage(1, Message("How are you?"))
        val result = chatService.getUnreadChatsCount()
        assertEquals(result, 2)
    }

    @Test
    fun getChats() {
        val expectation = mutableMapOf(Pair(1, Chat(mutableListOf(Message("Hi", true))))).entries
        chatService.sendMessage(1, Message("Hi", true))
        val result = chatService.getChats()
        assertEquals(result, expectation)
    }


    @Test
    fun getLastMessages() {
        val expectation = listOf("How are you?", "Hi")
        chatService.sendMessage(1, Message("Hi", true))
        chatService.sendMessage(2, Message("Hi"))
        chatService.sendMessage(1, Message("How are you?"))

        val result = chatService.getLastMessages()
        assertEquals(result, expectation)

    }

    @Test
    fun getMessagesException() {

        val expectation = NoSuchChatException::class.java
        chatService.sendMessage(1, Message("Hi", true))
        chatService.sendMessage(2, Message("Hi"))
        chatService.sendMessage(1, Message("How are you?"))
        val result = chatService.getMessages(3, 2)
        assertEquals(result, expectation)
    }

    @Test
    fun getMessages() {
        val expectation = listOf(Message("Hi", true), Message("How are you?", true))
        chatService.sendMessage(1, Message("Hi", true))
        chatService.sendMessage(2, Message("Hi"))
        chatService.sendMessage(1, Message("How are you?"))
        val result = chatService.getMessages(1, 2)
        assertEquals(result, expectation)
    }

    @Test
    fun sendMessage() {
        chatService.sendMessage(2, Message("Hi"))
        val expectation = listOf("Hi")
        val result = chatService.getLastMessages()
        assertEquals(result, expectation)
    }

    @Test
    fun deleteMessage() {
        chatService.sendMessage(1, Message("Hi", true))
        chatService.sendMessage(2, Message("Hi"))
        chatService.sendMessage(1, Message("How are you?"))
        chatService.deleteMessage(1, 1)
        val expectation = listOf(Message("Hi", true))
        val result = chatService.getMessages(1, 2)
        assertEquals(result, expectation)
    }


    @Test
    fun deleteChat() {
        chatService.sendMessage(1, Message("Hi", true))
        chatService.sendMessage(2, Message("Hi"))
        chatService.sendMessage(1, Message("How are you?"))
        chatService.deleteChat(1)
        val result = chatService.getUnreadChatsCount()
        assertEquals(result, 1)
    }
}