class NoteService {
    private var uniqueNoteId: Long = 0L
    private var uniqueCommentId: Long = 0L
    private var notes = mutableListOf(Notes())
    private var comments = mutableListOf(Comments())

    fun add(note: Notes): Notes {
        uniqueNoteId += 1
        notes += note.copy(id = uniqueNoteId)
        return notes.last()
    }

    fun createComment(noteId: Long, comment: Comments): Comments? {
        for ((index, note) in notes.withIndex()) {
            if (noteId == notes[index].id) {
                uniqueCommentId += 1
                notes[index].comments += comment.copy(id = uniqueCommentId)
                return comment
            }
        }
        return null
    }

    fun delete(noteId: Long) {
        for ((index, note) in notes.withIndex()) {
            if (noteId == notes[index].id) {
                notes[index].isDelete = true
            }
        }
    }

    fun deleteComment(commentId: Long) {
        for ((index, comment) in comments.withIndex()) {
            if (commentId == comments[index].id) {
                comments[index].isDelete = true
            }
        }
    }

    fun edit(noteId: Long, text: String) {
        for ((index, note) in notes.withIndex()) {
            if (noteId == notes[index].id) {
                notes[index].text = text
            }
        }
    }

    fun editComment(commentId: Long, text: String) {
        for ((index, comment) in comments.withIndex()) {
            if (commentId == comments[index].id) {
                comments[index].text = text
            }
        }
    }

    fun get() {


    }

    fun getById() {

    }

    fun getComments() {

    }

    fun restoreComments() {

    }


}