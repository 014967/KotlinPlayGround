package leetcode.MaxAreaofIsland

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
        intArrayOf(1, 2, 2, 3, 5),
        intArrayOf(3, 2, 3, 4, 4),
        intArrayOf(2, 4, 5, 3, 1),
        intArrayOf(6, 7, 1, 4, 5),
        intArrayOf(5, 1, 1, 2, 4)
    )
    val sol = Solution()
    println(sol.pacificAtlantic(grid))
}

val dx = listOf(0, 0, -1, 1)
val dy = listOf(-1, 1, 0, 0)
class Solution {

    lateinit var checker: Array<Array<Boolean>>
    lateinit var checkerOcean: Array<Array<Pair<Boolean, Boolean>>>
    lateinit var table: Array<Array<Int>>
    var result: ArrayList<List<Int>> = arrayListOf()
    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        val size = heights.size

        // -1 : Pacific  ,, Atlantic : -2
        table = Array(size + 2) { Array(size + 2) { 0 } }
        checker = Array(table.size) { Array(size + 2) { false } }
        checkerOcean = Array(table.size) { Array(size + 2) { Pair(false, false) } }
        for (i in table.indices) {
            table[i][0] = -1
        }
        for (i in table[0].indices) {
            table[0][i] = -1
        }

        for (i in table[0].indices) {
            table[size + 1][i] = -2
        }

        for (i in table.indices) {
            table[i][size + 1] = -2
        }

        table[0][size + 1] = -3
        table[size + 1][0] = -3
        for (i in heights.indices) {
            for (j in heights[i].indices) {
                table[i + 1][j + 1] = heights[i][j]
            }
        }

        for (i in 1 until table.size) {
            for (j in 1 until table[i].size) {
                dfs(i, j, i, j)
            }
        }

        return result
    }

    fun dfs(originX: Int, originY: Int, x: Int, y: Int) {
        println("$x $y")
        if (checker[x][y]) {
            return
        }
        checker[x][y] = true

        if (table[x][y] < 0) {
            println("$originX $originY")
            if (table[x][y] == -1) {
                checkerOcean[x][y] = checkerOcean[x][y].copy(first = true)
            }
            if (table[x][y] == -2) {
                checkerOcean[x][y] = checkerOcean[x][y].copy(second = true)
            }

            if (checkerOcean[x][y].first && checkerOcean[x][y].second) {
                result.add(listOf(originX, originY))
            }
            return
        }
        for (i in 0 until 4) {
            val nextX = x + dx[i]
            val nextY = y + dy[i]

            if (nextX in 1 until table.size - 1 && nextY in 1 until table[nextX].size - 1 &&
                (table[x][y] >= table[nextX][nextY] && !checker[x][y])
            ) {
                dfs(originX, originY, nextX, nextY)
            }
        }
    }
}
