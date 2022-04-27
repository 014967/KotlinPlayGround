package programmers.solution

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
    val board = arrayOf(intArrayOf(0, 0, 0, 0, 0), intArrayOf(0, 0, 1, 0, 3), intArrayOf(0, 2, 5, 0, 1), intArrayOf(4, 2, 4, 4, 2), intArrayOf(3, 5, 1, 3, 1))
    val moves = intArrayOf(1, 5, 3, 5, 1, 2, 1, 4)
    val solution = Solution6()
    println(solution.solution(board, moves))
}

class Solution6 {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        var answer = 0

        var resultStack = Stack<Int>()
        var table = HashMap<Int, LinkedList<Int>>()

        for (i in board.indices) {

            for (j in board[i].indices) {
                if (table.containsKey(j)) {
                    if (board[i][j] != 0)
                        table[j]!!.offer(board[i][j])
                } else {
                    table[j] = LinkedList<Int>()
                    if (board[i][j] != 0)
                        table[j]!!.offer(board[i][j])
                }
            }
        }
        for (i in moves) {
            val line = i - 1
            if (table[line]?.size != 0) {
                val pick = table[line]?.poll()
                if (resultStack.size != 0) {
                    if (resultStack.peek() == pick) {
                        resultStack.pop()
                        answer += 2
                    } else {
                        resultStack.add(pick)
                    }
                } else {
                    resultStack.add(pick)
                }
            }
        }

        return answer
    }
}
/*


 0 0 0 0 0
 0 0 1 0 3
 0 2 5 0 1
 4 2 4 4 2
 3 5 1 3 1



 0 0 0 0 0
 0 0 0 0 0
 0 0 5 0 0
 0 2 4 4 2
 3 5 1 3 1
-----------
 1 2 3 4 5

1 5 3 5 1 2 1 4
->
4 3 1 1 3 2 4

 */
