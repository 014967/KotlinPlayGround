package programmers.`크레인 인형뽑기`

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
    val solution = Solution()
    println(
        solution.solution(
            arrayOf(
                intArrayOf(0, 0, 0, 0, 0),
                intArrayOf(0, 0, 1, 0, 3),
                intArrayOf(0, 2, 5, 0, 1),
                intArrayOf(4, 2, 4, 4, 2),
                intArrayOf(3, 5, 1, 3, 1)
            ),
            intArrayOf(1, 5, 3, 5, 1, 2, 1, 4)
        )
    )
}

class Solution {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        var answer = 0
        val arr = Array(board.size + 1) { Stack<Int>() }
        for (i in board.indices) {
            for (j in board[i].indices) {
                if (board[i][j] != 0) {
                    arr[j + 1].add(board[i][j])
                }
            }
        }
        for (i in arr) {
            i.reverse()
        }

        val begStack = Stack<Int>()
// 핑크, 노랑, 핑크
        for (i in moves) {
            if (arr[i].isNotEmpty()) {
                val pick = arr[i].pop()
                if (begStack.isNotEmpty()) {
                    if (begStack.peek() == pick) {
                        begStack.pop()
                        answer+=2
                    } else {
                        begStack.add(pick)
                    }
                } else {
                    begStack.add(pick)
                }
            }
        }
        return answer
    }
}
