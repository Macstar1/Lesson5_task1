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

    println(wall.createComment(5, comment))

    println(wall.getPost(0))

}