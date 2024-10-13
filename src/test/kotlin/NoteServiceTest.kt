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
        val commentId = 1L
        val title = "Edited note"
        val text = "Text"
        service.add(Notes())
        service.edit(commentId, text, title)
        val result = service.notes[1]?.title
        assertEquals(title, result)
    }


    @Test
    fun editComment() {
        val commentId = 1L
        val text = "Edited text"
        service.add(Notes())
        service.createComment(1,comment)
        service.editComment(1, text)
        val result = service.notes[1]?.comments?.get(1)?.text
        assertEquals(text, result)
    }

    @Test
    fun get() {
        service.add(Notes())
        service.add(Notes())
        service.add(Notes())
        val noteIds = setOf(1L, 2L, 3L)
        val result = service.get(noteIds)
        assertEquals(noteIds, result)
    }
/*
    @Test
    fun getById() {
    }

    @Test
    fun getComments() {
    }

    @Test
    fun restoreComments() {
    }



     */
}