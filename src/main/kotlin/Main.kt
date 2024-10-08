fun main() {

    val comment: Comments = Comments()
    val like: Likes = Likes()
    val post: Post = Post()
    val wall: WallService = WallService

    wall.add(post)



    post.attachment = arrayOf(
        AttachmentFile(
            File(1,1,"", 10, "url"),
            "file"
        ),
        AttachmentAudio(Audio(
            1L,
            1L,
            "Duke Dumont",
            "Ocean Drive",
            5
        ), "audio")
    )


    println(wall.getPostSize())

    wall.add(post)
    val postId = 2L
    val newComment = wall.createComment(postId, comment)
    println(newComment)


    println(wall.getPost(0))
    println(wall.getPost(1))
    println(wall.getPostSize())

}