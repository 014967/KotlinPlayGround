package leetcode.`pacific-atlantic-water-flow`

import java.util.*

fun main() {
    val sol = Solution()

    println(
        sol.pacificAtlantic(
            arrayOf(
                intArrayOf(1, 2, 2, 3, 5),
                intArrayOf(3, 2, 3, 4, 4),
                intArrayOf(2, 4, 5, 3, 1),
                intArrayOf(6, 7, 1, 4, 5),
                intArrayOf(5, 1, 1, 2, 4)
            )
        )
    )
}
data class Vertex(
    val x: Int,
    val y: Int
)
class Solution {

    lateinit var table: Array<IntArray>
    lateinit var pacificCheck: Array<BooleanArray>
    lateinit var atlanticCheck: Array<BooleanArray>
    lateinit var pathTable: Array<IntArray>
    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        table = Array(heights.size + 2) { IntArray(heights[0].size + 2) { 0 } }
        pathTable = Array(heights.size + 2) { IntArray(heights[0].size + 2) { 0 } }
        initTable()
        for (i in heights.indices) {
            for (j in heights[i].indices) {
                table[i + 1][j + 1] = heights[i][j]
            }
        }

        val result = arrayListOf<List<Int>>()
        for (i in 1 until table.size - 1) {
            for (j in 1 until table[i].size - 1) {
                pacificCheck = Array(heights.size + 2) { BooleanArray(heights[0].size + 2) { false } }
                atlanticCheck = Array(heights.size + 2) { BooleanArray(heights[0].size + 2) { false } }
                val isPacific = search(-1, vertex = Vertex(i, j))

                val isAtlantic = search(-2, vertex = Vertex(i, j))

                if (isAtlantic && isPacific) {
                    pathTable[i][j] = -3
                    result.add(listOf(i - 1, j - 1))
                }
            }
        }
        return result
    }
    private fun initTable() {
        for (i in table[0].indices) {
            table[0][i] = -1
        }

        for (i in table[table.size - 1].indices) {
            table[table.size - 1][i] = -2
        }

        for (i in 1 until table.size) {
            table[i][0] = -1
            if (i == table.size - 1) {
                table[i][0] = -2
            }
            table[i][table[i].size - 1] = -2
        }
    }

    val dx = listOf(0, 0, -1, 1)
    val dy = listOf(1, -1, 0, 0)
    fun search(
        ocean: Int,
        vertex: Vertex
    ): Boolean {
        val queue = LinkedList<Vertex>()
        queue.offer(vertex)
        while (queue.isNotEmpty()) {
            val (x, y) = queue.poll()
            val height = table[x][y]
            if (ocean == -1) {
                // 위 왼쪽만
                if (table[x - 1][y] == -1 || table[x][y - 1] == -1) {
                    return true
                }
            }
            if (ocean == -2) {
                // 오른쪽 아래만
                if (table[x + 1][y] == -2 || table[x][y + 1] == -2) {
                    return true
                }
            }

            if (pathTable[x][y] == -3) {
                return true
            }


            if (ocean == -1) {
                pacificCheck[x][y] = true
            }
            if (ocean == -2) {
                atlanticCheck[x][y] = true
            }

            for (i in 0 until 4) {
                val nextX = x + dx[i]
                val nextY = y + dy[i]
                if (ocean == -1) {
                    if (nextX in 1 until table.size - 1 && nextY in 1 until table[nextX].size - 1 &&
                        height >= table[nextX][nextY] && !pacificCheck[nextX][nextY]
                    ) {
                        queue.offer(Vertex(nextX, nextY))
                    }
                }
                if (ocean == -2) {
                    if (nextX in 1 until table.size - 1 && nextY in 1 until table[nextX].size - 1 &&
                        height >= table[nextX][nextY] && !atlanticCheck[nextX][nextY]
                    ) {
                        queue.offer(Vertex(nextX, nextY))
                    }
                }
            }
        }

        return false
    }
}
