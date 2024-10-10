class NoteService {
    private var uniqueNoteId: Long = 0L
    private var uniqueCommentId: Long = 0L
    private var notes = emptyArray<Notes>()
    private var comments = emptyArray<Comments>()

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
            if (noteId == notes[index].id){
                notes[index].isDelete = true
            }
        }
    }

    fun deleteComment() {

    }

    fun edit() {

    }

    fun editComment() {

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