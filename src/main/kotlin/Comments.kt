data class Comments(
    val id: Int = 0,
    val fromId: Int = 0,
    val date: Int = 0,
    val text: String = "",
    val attachments: Attachment? = null,
) {
}