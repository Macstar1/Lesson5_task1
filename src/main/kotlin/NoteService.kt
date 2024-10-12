class NoteService {
    private var uniqueNoteId: Long = 0L
    private var uniqueCommentId: Long = 0L
    var notes: MutableMap<Long, Notes> = mutableMapOf()
    //var comments: MutableMap<Long, Comments> = mutableMapOf()

    fun add(note: Notes): Long {
        uniqueNoteId += 1
        notes[uniqueNoteId] = note
        return uniqueNoteId
    }

    fun createComment(noteId: Long, comment: Comments): Long {
        uniqueCommentId += 1
        notes[noteId]?.comments?.put(uniqueCommentId, comment)
        return uniqueCommentId
    }

    fun delete(noteId: Long) {
        notes[noteId]?.isDelete = true
    }

    fun deleteComment(commentId: Long) {
        for ((key, value) in notes) {
            if (notes[key]?.comments?.containsKey(commentId) == true) {
                notes[key]?.comments?.get(commentId)?.isDelete = true
            }
        }
    }

    fun edit(noteId: Long, text: String, title: String) {
        val note = notes[noteId]
        notes[noteId] =
            note?.copy(text = text, title = title) ?: throw NoteNotFoundException("Note with id: $noteId not found.")
    }

    fun editComment(commentId: Long, text: String) {
        for ((key, value) in notes) {
            if (notes[key]?.comments?.containsKey(commentId) == true) {
                notes[key]?.comments?.get(commentId)?.text = text
            }
        }
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

    fun getComments(noteId: Long): MutableMap<Long, Comments> {
        return notes[noteId]?.comments ?: throw NoteNotFoundException("Note with id: $noteId not found.")
    }

    fun restoreComments(commentId: Long) {
        for ((key, value) in notes) {
            if (notes[key]?.comments?.containsKey(commentId) == true) {
                notes[key]?.comments?.get(commentId)?.isDelete = false
            }
        }
    }


}

class NoteNotFoundException(message: String) : RuntimeException(message)
class CommentNotFoundException(message: String) : RuntimeException(message)