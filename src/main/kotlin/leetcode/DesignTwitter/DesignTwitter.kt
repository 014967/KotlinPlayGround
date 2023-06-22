package leetcode.DesignTwitter

/**
 * @desc
 *
 * @input
 *
 * @output
 *
 * @example
 *
 */

data class Twit(
    val twitId: Int,
    val time: Int
) : Comparable<Twit> {
    override fun compareTo(other: Twit): Int {
        return other.time - this.time
    }
}

fun main() {
    val twitter = Twitter()

    twitter.postTweet(1, 5)
    twitter.postTweet(2, 5)
}
class Twitter() {

    data class User(
        var userId: Int
    ) {
        val follower: ArrayList<User> = arrayListOf()
        val post: ArrayList<Twit> = arrayListOf()
    }

    var time = 0
    val userTable: HashMap<Int, User> = HashMap()

    fun postTweet(userId: Int, tweetId: Int) {
        if (userTable.containsKey(userId)) {
            val user = userTable[userId]!!
            user.post.add(Twit(tweetId, time = time))
        } else {
            val user = User(userId)
            user.post.add(Twit(tweetId, time = time))
            userTable[userId] = user
        }
        time++
    }

    fun getNewsFeed(userId: Int): List<Int> {
        return emptyList()
    }

    fun follow(followerId: Int, followeeId: Int) {
    }

    fun unfollow(followerId: Int, followeeId: Int) {
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * var obj = Twitter()
 * obj.postTweet(userId,tweetId)
 * var param_2 = obj.getNewsFeed(userId)
 * obj.follow(followerId,followeeId)
 * obj.unfollow(followerId,followeeId)
 */
