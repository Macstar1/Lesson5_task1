class NoteService {
    private var uniqueNoteId: Long = 0L
    private var notes = emptyArray<Note>()

    fun add(note: Note): Note {
        uniqueNoteId += 1
        notes += note.copy(id = uniqueNoteId)
        return notes.last()
    }

    fun createComment() {

    }

    fun delete(){

    }


}