data class Post(
    val original: Post? = null,
    var id: Long = 1L,
    val ownerId: Int = 1,
    val fromId: Int = 1,
    val date: Int = 1,
    val text: String = "",
    val isFriendsOnly: Boolean = true,
    val comments: Comments = Comments(
        0,
        true,
        true,
        true,
        ""
    ),
    val likes: Likes = Likes(
        0,
        true,
        true,
        true
    ),
    val views: Views = Views(0),
    val postType: String = "",
    val isCanPin: Boolean = true,
    val isCanDelete: Boolean = true,
    val isCanEdit: Boolean = true,
    var attachment: Array<Attachment>? = null
)