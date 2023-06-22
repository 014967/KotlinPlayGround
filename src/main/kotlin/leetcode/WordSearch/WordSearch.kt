package leetcode.WordSearch

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

fun main() {
    val board = arrayOf(
        charArrayOf('a', 'a')
//        charArrayOf('S', 'F', 'E', 'S'),
//        charArrayOf('A', 'D', 'E', 'E')
    )
    val word = "aaa"
    val sol = Solution()
    println(sol.exist(board, word))
}

val dx = listOf(0, 0, 1, -1)
val dy = listOf(1, -1, 0, 0)
data class Vertex(
    val x: Int,
    val y: Int,
    val index: Int
)
class Solution {
    var flag = false
    lateinit var checker: Array<BooleanArray>
    fun exist(board: Array<CharArray>, word: String): Boolean {
        checker = Array(board.size) { BooleanArray(board[0].size) { false } }
        for (i in board.indices) {
            for (j in board[i].indices) {
                if (board[i][j] == word[0]) {
                    checker[i][j] = true
                    dfs(board, word, i, j, 0)
                    checker[i][j] = false
                }
            }
        }

        return flag
    }

    fun dfs(board: Array<CharArray>, word: String, currentX: Int, currentY: Int, index: Int) {
        if (index == word.length - 1) {
            flag = true
        }
        for (i in 0..3) {
            val nextX = currentX + dx[i]
            val nextY = currentY + dy[i]
            val nextIndex = index + 1

            if (nextX in board.indices && nextY in board[nextX].indices &&
                nextIndex < word.length && board[nextX][nextY] == word[nextIndex] &&
                !checker[nextX][nextY]
            ) {
                checker[nextX][nextY] = true
                dfs(board, word, nextX, nextY, nextIndex)
                checker[nextX][nextY] = false
            }
        }
    }
}
