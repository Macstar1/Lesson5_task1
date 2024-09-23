data class Post(
    var id: Long = 1L,
    val ownerId: Int = 1,
    val fromId: Int = 1,
    val date: Int = 1,
    val text: String = "",
    val isFriendsOnly: Boolean = true,
    val comments: Comments,
    val likes: Likes,
    val views: Views = Views(0),
    val postType: String = "",
    val isCanPin: Boolean = true,
    val isCanDelete: Boolean = true,
    val isCanEdit: Boolean = true
)