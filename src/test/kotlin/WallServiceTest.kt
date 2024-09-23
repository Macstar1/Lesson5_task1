import WallService.add
import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun add_increase_id() {
        val post = Post(
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
        assertEquals(1, result)
    }

    @Test
    fun update() {
    }

}