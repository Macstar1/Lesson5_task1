data class Notes(
    var id: Long = 1L,
    val title: String = "",
    var text: String = "",
    val date: Int = 1,
    var comments: MutableMap<Long, Comments> = mutableMapOf(),
    val viewUrl: String = "",
    var isDelete: Boolean = false
)