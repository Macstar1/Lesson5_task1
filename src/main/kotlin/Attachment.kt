interface Attachment {
    val type: String
}

class Audio(
    val id: Long,
    val ownerId: Long,
    val artist: String,
    val title: String,
    val duration: Int,
)

class AttachmentAudio(
    val audio: Audio,
    override val type: String,
) : Attachment

class Video(
    val id: Long,
    val ownerId: String,
    val title: String,
    val description: String,
    val duration: Int,
)

class AttachmentVideo(
    val video: Video,
    override val type: String
) : Attachment

class File(
    val id: Long,
    val ownerId: Long,
    val title: String,
    val size: Int,
    val url: String,
)

class AttachmentFile(
    val file: File,
    override val type: String
) : Attachment

class Link(
    val url: String,
    val title: String,
    val caption: String,
    val description: String,
)

class AttachmentLink(
    val link: Link,
    override val type: String
) : Attachment

class Sticker(
    val stickerId: Int,
    val productId: Int,
    val url: String,
)

class AttachmentSticker(
    val sticker: Sticker,
    override val type: String
) : Attachment