package leetcode.`Number-of-islands`

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
    val sol = Solution()
    val grid = arrayOf(
        charArrayOf('1', '1', '1', '1', '0'),
        charArrayOf('1', '1', '0', '1', '0'),
        charArrayOf('1', '1', '0', '0', '0'),
        charArrayOf('0', '0', '0', '0', '0')
    )
    println(sol.numIslands(grid))
}

/*
0은 물을 나타내고,1은 섬을 나타낸다.
섬은 물로 둘러싸여 있으며 인접한 육지를 수평 또는 수직으로 연결하여 형성됩니다. 그리드의 네 모서리가 모두 물로 둘러싸여 있다고 가정할 수 있습니다.
 */

val dx = listOf(0, 0, -1, 1)
val dy = listOf(1, -1, 0, 0)
class Solution {

    lateinit var table: Array<CharArray>
    fun numIslands(grid: Array<CharArray>): Int {
        table = grid
        var count = 0
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == '1') {
                    dfs(i, j)
                    count++
                }
            }
        }

        return count
    }

    fun dfs(x: Int, y: Int) {
        table[x][y] = '2'

        for (i in 0 until 4) {
            val nextX = x + dx[i]
            val nextY = y + dy[i]

            if (nextX in table.indices && nextY in table[nextX].indices &&
                table[nextX][nextY] == '1'
            ) {
                dfs(nextX, nextY)
            }
        }
    }
}
