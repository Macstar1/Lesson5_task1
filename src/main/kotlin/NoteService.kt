class NoteService {
    private var uniqueNoteId: Long = 0L
    private var uniqueCommentId: Long = 0L
    private var notes: MutableMap<Long, Notes> = mutableMapOf()
    private var comments: MutableMap<Long, Comments> = mutableMapOf()

    fun add(note: Notes): Long {
        uniqueNoteId += 1
        notes[uniqueNoteId] = note
        return uniqueNoteId
    }

    fun createComment(noteId: Long, comment: Comments): Long {
        uniqueCommentId += 1
        comments[uniqueCommentId] = comment
        return uniqueCommentId
    }

    fun delete(noteId: Long) {
        notes[noteId]?.isDelete = true
    }

    fun deleteComment(commentId: Long) {
        comments.remove(commentId)
    }

    fun edit(noteId: Long, text: String, title: String) {
        val note = notes[noteId]
        notes[noteId] =
            note?.copy(text = text, title = title) ?: throw NoteNotFoundException("Note with id: $noteId not found.")
    }

    fun editComment(commentId: Long, text: String) {
        val comment = comments[commentId]
        comments[commentId] =
            comment?.copy(text = text) ?: throw CommentNotFoundException("Comment with id: $commentId not found.")
    }

    fun get(noteIds: Set<Long>): Set<Notes?> {
        val result = mutableSetOf<Notes?>()
        for (i in noteIds) {
            result.add(notes[i])
        }
        return result
    }

    fun getById(noteId: Long): Notes? {
        return notes[noteId]
    }

    fun getComments(noteId: Long): Comments? {
        return comments[noteId]
    }

    fun restoreComments() {

    }


}

class NoteNotFoundException(message: String) : RuntimeException(message)
class CommentNotFoundException(message: String) : RuntimeException(message)