package programmers.`행렬 테두리 회전하기`

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
    val rows = 6
    val columns = 6
    val queries = arrayOf(intArrayOf(2, 2, 5, 4), intArrayOf(3, 3, 6, 6), intArrayOf(5, 1, 6, 3))
    val solution = Solution()
    println(solution.solution(rows, columns, queries))
}
data class Vertex(
    val x: Int,
    val y: Int
)
class Solution {
    fun solution(rows: Int, columns: Int, queries: Array<IntArray>): IntArray {
        val answer = IntArray(queries.size) { 0 }

        val arrTable = Array(rows) { it2 -> Array(columns) { it2 * (columns) + it + 1 } }
        for (i in queries.indices) {
            val startVertex = Vertex(queries[i][0] - 1, queries[i][1] - 1)
            val endVertex = Vertex(queries[i][2] - 1, queries[i][3] - 1)
            answer[i] = rotation(startVertex, endVertex, arrTable)

        }

        return answer
    }

    fun rotation(startVertex: Vertex, endVertex: Vertex, arrTable: Array<Array<Int>>): Int {
        val leftX = startVertex.x
        val leftY = startVertex.y

        val rightX = endVertex.x
        val rightY = endVertex.y

        var min = Integer.MAX_VALUE

        // leftY -> rightY까지 이동
        val topRightVertex = arrTable[leftX][rightY]
        for (i in rightY downTo leftY + 1) {
            arrTable[leftX][i] = arrTable[leftX][i - 1]
            min = min.coerceAtMost(arrTable[leftX][i])
        }

        // leftX -> rightX 까지 이동
        val bottomRightVertex = arrTable[rightX][rightY]
        for (i in rightX downTo leftX + 1) {
            if (i == leftX + 1) {
                arrTable[leftX + 1][rightY] = topRightVertex
            } else {
                arrTable[i][rightY] = arrTable[i - 1][rightY]
            }
            min = min.coerceAtMost(arrTable[i][rightY])
        }

        // rightY -> leftY까지 이동
        val bottomLeftVertex = arrTable[rightX][leftY]
        for (i in leftY..rightY - 1) {
            if (i == rightY - 1) {
                arrTable[rightX][rightY - 1] = bottomRightVertex
            } else {
                arrTable[rightX][i] = arrTable[rightX][i + 1]
            }
            min = min.coerceAtMost(arrTable[rightX][i])
        }

        // rightX -> leftX까지 이동
        for (i in leftX..rightX - 1) {
            if (i == rightX - 1) {
                arrTable[rightX - 1][leftY] = bottomLeftVertex
            } else {
                arrTable[i][leftY] = arrTable[i + 1][leftY]
            }
            min = min.coerceAtMost(arrTable[i][leftY])
        }

        return min
    }
}
