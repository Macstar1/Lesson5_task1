data class Comments(
    var id: Long = 0,
    val fromId: Int = 0,
    val date: Int = 0,
    var text: String = "",
    val attachments: Attachment? = null,
    var isDelete: Boolean = false
)