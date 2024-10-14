import org.junit.Assert.assertEquals
import org.junit.Test

class NoteServiceTest {
    private var uniqueNoteId: Long = 0L
    private var uniqueCommentId: Long = 0L
    private var notes: MutableMap<Long, Notes> = mutableMapOf()
    private var comments: MutableMap<Long, Comments> = mutableMapOf()
    private val note: Notes = Notes()
    private val comment: Comments = Comments()
    private val service: NoteService = NoteService()

    @Test
    fun add() {
        val result = service.add(note)
        assertEquals(result, 1)
    }

    @Test
    fun createComment() {
        service.add(Notes())
        val result = service.createComment(1, comment)
        assertEquals(result, 1)
    }

    @Test
    fun delete() {
        service.add(Notes())
        service.delete(1)
        val result = service.notes[1]?.isDelete
        assertEquals(true, result)
    }

    @Test
    fun deleteComment() {
        service.add(Notes())
        service.createComment(1, comment)
        service.deleteComment(1)
        val result = service.notes[1]?.comments?.get(1)?.isDelete
        assertEquals(true, result)
    }

    @Test
    fun edit() {
        val noteId = 1L
        val title = "Edited note"
        val text = "Text"
        service.add(Notes())
        service.edit(noteId, text, title)
        val result = service.notes[1]?.title
        assertEquals(title, result)
    }


    @Test
    fun editComment() {
        val commentId = 1L
        val text = "Edited text"
        service.add(Notes())
        service.createComment(1, comment)
        service.editComment(1, text)
        val result = service.notes[1]?.comments?.get(1)?.text
        assertEquals(text, result)
    }

    @Test
    fun get() {
        service.add(Notes())
        service.add(Notes())
        service.add(Notes())

        val noteIds = setOf(1L, 2L)
        val result = service.get(noteIds)
        assertEquals(setOf(service.notes[1L], service.notes[2L]), result)
    }

    @Test
    fun getById() {
        val noteId = 1L
        service.add(Notes())
        val result = service.getById(noteId)
        assertEquals(service.notes[noteId], result)
    }

    @Test
    fun getComments() {
        val noteId = 1L
        service.add(Notes())
        service.createComment(1L, Comments())
        val result = service.getComments(noteId)
        assertEquals(service.notes[noteId]?.comments, result)
    }

    fun getComments_exception() {
        val noteId = 2L
        service.add(Notes())
        service.createComment(1L, Comments())
        val result = service.getComments(noteId)
        assertEquals(NoteNotFoundException("Note with id: $noteId not found."), result)
    }

    @Test
    fun restoreComments() {
        val commentsId = 1L
        service.add(Notes())
        service.createComment(1L, Comments())
        service.deleteComment(1L)
        service.restoreComments(1L)
        val result = false
        assertEquals(service.notes[1L]?.comments?.get(1)?.isDelete, result)
    }


}