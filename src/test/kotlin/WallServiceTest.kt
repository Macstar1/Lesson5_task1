import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {
    private var posts = emptyArray<Post>()

    @Test
    fun add_increase_id() {
        val service = Wallservice()
        val post = Post(
            original = null,
            id = 0L,
            ownerId = 1,
            fromId = 1,
            date = 1,
            text = "",
            isFriendsOnly = true,
            comments = emptyArray(),
            likes = Likes(0, true, true, true),
            views = Views(0),
            postType = "",
            isCanPin = true,
            isCanDelete = true,
            isCanEdit = true
        )
        val result = service.add(post).id
        assertEquals(1, result)
    }

    @Test
    fun update_false() {
        val service = Wallservice()
        val post = Post(
            original = null,
            id = 100L,
            ownerId = 1,
            fromId = 1,
            date = 1,
            text = "",
            isFriendsOnly = true,
            comments = emptyArray(),
            likes = Likes(0, true, true, true),
            views = Views(0),
            postType = "",
            isCanPin = true,
            isCanDelete = true,
            isCanEdit = true
        )

        val result = service.update(post)
        assertEquals(false, result)

    }

    @Test
    fun update_true() {
        val service = Wallservice()

        val post = Post(
            original = null,
            id = 1L,
            ownerId = 1,
            fromId = 1,
            date = 1,
            text = "",
            isFriendsOnly = true,
            comments = emptyArray(),
            likes = Likes(0, true, true, true),
            views = Views(0),
            postType = "",
            isCanPin = true,
            isCanDelete = true,
            isCanEdit = true
        )
        service.add(post = post)
        service.add(post = post)
        val result = service.update(post)
        assertEquals(true, result)
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {
        val service = Wallservice()
        val postId = 10L
        val newcomment =
            service.createComment(postId, Comments())?.id ?: throw PostNotFoundException("Post with id: $postId not found.")
    }

    @Test
    fun commentAdd(){
        val service = Wallservice()
        val postId = 1L
        val post = Post()
        service.add(post)

        val result = service.createComment(postId, Comments())
        assertEquals(Comments(), result)
    }
}