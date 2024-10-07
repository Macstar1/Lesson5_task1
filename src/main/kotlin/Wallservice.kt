object WallService {
    private var uniqueId = 0L
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comments>()

    fun getPosts(): Array<Post> {
        return posts
    }
    
    fun createComment(postId: Int, comment: Comments): Comments {
        TODO() // add function
    }

    fun add(post: Post): Post {
        uniqueId += 1
        posts += post
        posts.last().id = uniqueId
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
    /*

    fun likeById(id: Long) {
        for ((index, post) in posts.withIndex()) {
            if (post.id == id) {
                posts[index] = post.copy(likes = post.likes.copy(count = post.likes.count + 1))
            }
        }
    }


     */

}