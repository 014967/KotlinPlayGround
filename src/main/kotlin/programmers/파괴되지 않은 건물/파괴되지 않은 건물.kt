package programmers.`파괴되지 않은 건물`

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
    val board = arrayOf(intArrayOf(5, 5, 5, 5, 5), intArrayOf(5, 5, 5, 5, 5), intArrayOf(5, 5, 5, 5, 5), intArrayOf(5, 5, 5, 5, 5))
    val skill = arrayOf(intArrayOf(1, 0, 0, 3, 4, 4), intArrayOf(1, 2, 0, 2, 3, 2), intArrayOf(2, 1, 0, 3, 1, 2), intArrayOf(1, 0, 1, 3, 3, 1))
    val solution = Solution()
    println(solution.solution(board, skill))
}

class Solution {
    fun solution(board: Array<IntArray>, skill: Array<IntArray>): Int {
        var answer: Int = 0
        val sumArray = Array(board.size + 1) { IntArray(board[0].size + 1) { 0 } }
        for (i in skill) {
            val type = i[0]
            val r1 = i[1]
            val c1 = i[2]
            val r2 = i[3]
            val c2 = i[4]
            val degree = i[5]
            if (type == 1) {
                // 공격
                sumArray[r1][c1] += degree * -1
                sumArray[r1][c2 + 1] += degree
                sumArray[r2 + 1][c2 + 1] += degree * -1
                sumArray[r2 + 1][c1] += degree
            } else {
                sumArray[r1][c1] += degree
                sumArray[r1][c2 + 1] += degree * -1
                sumArray[r2 + 1][c2 + 1] += degree
                sumArray[r2 + 1][c1] += degree * -1
            }
            println(sumArray)
        }
        for (t in 1..2) {
            for (x in 0 until sumArray.size - 1) {
                for (y in 0 until sumArray[x].size - 1) {
                    if (t == 1) {
                        // 세로 누적
                        sumArray[x][y + 1] += sumArray[x][y]
                    } else {
                        // 가로 누적
                        sumArray[x + 1][y] += sumArray[x][y]
                    }
                }
            }
        }
        for (i in board.indices) {
            for (j in board[i].indices) {
                board[i][j] += sumArray[i][j]
                if (board[i][j] > 0) {
                    answer++
                }
            }
        }

        return answer
    }
}

/*
skill [type, r1 ,c1, r2,c2, degree]
type 1   공격
type 2 = 회복
r1,c1 ~ r2,c2 까지 degree만큼 적용
 */
