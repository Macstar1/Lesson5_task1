import WallService.add
import WallService.update
import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {
    private var posts = emptyArray<Post>()
    @Test
    fun add_increase_id() {
        val post = Post(
            original = null,
            id = 0L,
            ownerId = 1,
            fromId = 1,
            date = 1,
            text = "",
            isFriendsOnly = true,
            comments = Comments(0, true, true, true),
            likes = Likes(0, true, true, true),
            views = Views(0),
            postType = "",
            isCanPin = true,
            isCanDelete = true,
            isCanEdit = true
        )

        val result = add(post).id
        assertEquals(3, result)
    }

    @Test
    fun update_false() {

        val post = Post(
            original = null,
            id = 100L,
            ownerId = 1,
            fromId = 1,
            date = 1,
            text = "",
            isFriendsOnly = true,
            comments = Comments(0, true, true, true),
            likes = Likes(0, true, true, true),
            views = Views(0),
            postType = "",
            isCanPin = true,
            isCanDelete = true,
            isCanEdit = true
        )

        val result = update(post)
        assertEquals(false, result)

    }

    @Test
    fun update_true() {

        val post = Post(
            original = null,
            id = 1L,
            ownerId = 1,
            fromId = 1,
            date = 1,
            text = "",
            isFriendsOnly = true,
            comments = Comments(0, true, true, true),
            likes = Likes(0, true, true, true),
            views = Views(0),
            postType = "",
            isCanPin = true,
            isCanDelete = true,
            isCanEdit = true
        )
        WallService.add(post = post)
        WallService.add(post = post)
        val result = update(post)
        assertEquals(true, result)

    }

}