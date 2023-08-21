package leetcode.`rotting-roagnes`

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
    val grid = arrayOf(
        intArrayOf(2, 1, 1),
        intArrayOf(0, 1, 1),
        intArrayOf(1, 0, 1)
    )
    val sol = Solution()
    println(sol.orangesRotting(grid))
}
val dx = listOf(0, 0, -1, 1)
val dy = listOf(1, -1, 0, 0)
data class Vertex(
    val x: Int,
    val y: Int
)
class Solution {
    fun orangesRotting(grid: Array<IntArray>): Int {
        val queue = LinkedList<Vertex>()

        var freshCount = 0
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == 1) {
                    freshCount++
                }
                if (grid[i][j] == 2) {
                    queue.offer(
                        Vertex(
                            x = i,
                            y = j
                        )
                    )
                }
            }
        }

        var time = 0
        while (freshCount != 0) {
            if (queue.isEmpty()) {
                time = -1
                break
            }
            val tempQueue = arrayListOf<Vertex>()
            while (queue.isNotEmpty()) {
                val rot = queue.poll()
                for (i in 0 until 4) {
                    // 1분
                    val nextX = rot.x + dx[i]
                    val nextY = rot.y + dy[i]
                    if (nextX in grid.indices &&
                        nextY in grid[nextX].indices &&
                        grid[nextX][nextY] == 1
                    ) {
                        grid[nextX][nextY] = 2
                        freshCount--
                        tempQueue.add(
                            Vertex(
                                nextX,
                                nextY
                            )
                        )
                    }
                }
            }
            tempQueue.forEach {
                queue.offer(it)
            }
            time++
        }

        return time
    }
}
