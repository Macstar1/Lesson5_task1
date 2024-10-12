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

    }
/*
    @Test
    fun edit() {
    }

    @Test
    fun editComment() {
    }

    @Test
    fun get() {
    }

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