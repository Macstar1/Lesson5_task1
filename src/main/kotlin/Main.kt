fun main() {


    var chatService: ChatService = ChatService()
    chatService.sendMessage(1, Message("Hi", true))
    chatService.sendMessage(2, Message("Hi"))
    chatService.sendMessage(1, Message("How are you?"))
    chatService.printChat()
    chatService.deleteMessage(1, 0)
    println(chatService.getChats())



/*
    val comment: Comments = Comments()
    val like: Likes = Likes()
    val post: Post = Post()
    val wall: Wallservice = Wallservice()
    val notes: NoteService = NoteService()

    wall.add(post)

    post.attachment = arrayOf(
        AttachmentFile(
            File(1, 1, "", 10, "url"),
            "file"
        ),
        AttachmentAudio(
            Audio(
                1L,
                1L,
                "Duke Dumont",
                "Ocean Drive",
                5
            ), "audio"
        )
    )

    println(wall.getPostSize())

    wall.add(post)
    wall.add(post)
    val postId = 1L
    val newComment = wall.createComment(postId, comment)
    println(newComment?.id ?: throw PostNotFoundException("Post with id: $postId not found."))

    println(wall.getPost(0))
    println(wall.getPost(1))
    println(wall.getPost(2))

    println(wall.getPostSize())


    notes.add(Notes())
    notes.add(Notes())
    notes.add(Notes())
    println(notes.getById(1))
    notes.createComment(1, comment)
    notes.createComment(1, comment)
    notes.deleteComment(1)
    notes.createComment(2, comment)
    notes.edit(2, "", "")
    println(notes.getById(2))
    println(notes.notes)
    println(notes.get(setOf(1L, 2L)))
    println(notes.notes.size)
    println(notes.getComments(1L))

 */


}