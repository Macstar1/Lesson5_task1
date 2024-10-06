fun main() {

    val comment: Comments = Comments()
    val like: Likes = Likes()
    val post: Post = Post()
    val posts: WallService



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




    println(post)

}