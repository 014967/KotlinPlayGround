package leetcode.`Surrounded-Regions`

import java.util.*

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
        charArrayOf('O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O'),
        charArrayOf('O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'X'),
        charArrayOf('O', 'X', 'O', 'X', 'O', 'O', 'O', 'O', 'X'),
        charArrayOf('O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O'),
        charArrayOf('X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X'),
        charArrayOf('X', 'X', 'O', 'O', 'X', 'O', 'X', 'O', 'X'),
        charArrayOf('O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O'),
        charArrayOf('O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O'),
        charArrayOf('O', 'O', 'O', 'O', 'O', 'X', 'X', 'O', 'O')
    )
    val sol = Solution()

    sol.solve(board)
    println(board)
}

val dx = listOf(0, 0, -1, 1)
val dy = listOf(1, -1, 0, 0)

data class Path(
    val x: Int,
    val y: Int
)

class Solution {
    lateinit var checker: Array<BooleanArray>
    lateinit var table: Array<CharArray>
    val path = arrayListOf<Path>()
    fun solve(board: Array<CharArray>) {
        checker = Array(board.size) { BooleanArray(board[0].size) { false } }

        for (i in board.indices) {
            for (j in board[i].indices) {
                if (!checker[i][j] && board[i][j] == 'O') {
                    path.clear()
                    if (bfs(i, j, board)) {
                        path.forEach {
                            board[it.x][it.y] = 'X'
                        }
                    }
                }
            }
        }
    }
    fun bfs(x: Int, y: Int, board: Array<CharArray>): Boolean {
        val queue = LinkedList<Path>()
        queue.offer(Path(x, y))

        var flag = true
        while (queue.isNotEmpty()) {
            val current = queue.poll()
            path.add(current)
            checker[current.x][current.y] = true

            for (i in 0 until 4) {
                val nextX = current.x + dx[i]
                val nextY = current.y + dy[i]

                if (nextX !in checker.indices) {
                    flag = false
                    break
                }
                if (nextY !in checker[nextX].indices) {
                    flag = false
                    break
                }
                if (!checker[nextX][nextY] && board[nextX][nextY] == 'O') {
                    queue.offer(
                        Path(nextX, nextY)
                    )
                }
            }
        }

        return flag
    }
}
