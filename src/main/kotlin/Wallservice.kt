object WallService {
    private var uniquePostId = 0L
    private var uniqueCommentId = 0L
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comments>()

    fun createComment(postId: Long, comment: Comments): Comments? {
        for ((index, post) in posts.withIndex()) {
            if (postId == posts[index].id) {
                uniqueCommentId += 1
                posts[index].comments += comment.copy(id = uniqueCommentId)
                return comment
            }
        }
        return null
    }

    fun add(post: Post): Post {
        uniquePostId += 1
        posts += post.copy(id = uniquePostId)
        return posts.last()
    }

    fun update(post: Post): Boolean {
        var find = false
        for ((index, post) in posts.withIndex()) {
            if (post.id == posts[index].id) {
                posts[index] = post
                find = true
            }
        }
        return find
    }

    fun getPost(index: Int): Post {
        return posts[index]
    }

    fun getPostSize(): Int {
        return posts.size
    }
}

class PostNotFoundException(message: String) : RuntimeException(message)