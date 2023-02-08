package programmers.`경주로 건설`

import baekjoon.solution1325.dp
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
        arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 0, 0), intArrayOf(0, 0, 0)),
        arrayOf(
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 1),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 1, 0, 0),
            intArrayOf(0, 0, 0, 0, 1, 0, 0, 0),
            intArrayOf(0, 0, 0, 1, 0, 0, 0, 1),
            intArrayOf(0, 0, 1, 0, 0, 0, 1, 0),
            intArrayOf(0, 1, 0, 0, 0, 1, 0, 0),
            intArrayOf(1, 0, 0, 0, 0, 0, 0, 0)
        ),
        arrayOf(
            intArrayOf(0, 0, 1, 0),
            intArrayOf(0, 0, 0, 0),
            intArrayOf(0, 1, 0, 1),
            intArrayOf(1, 0, 0, 0)
        ),
        arrayOf(
            intArrayOf(0, 0, 0, 0, 0, 0),
            intArrayOf(0, 1, 1, 1, 1, 0),
            intArrayOf(0, 0, 1, 0, 0, 0),
            intArrayOf(1, 0, 0, 1, 0, 1),
            intArrayOf(0, 1, 0, 0, 0, 1),
            intArrayOf(0, 0, 0, 0, 0, 0)
        ),
        arrayOf(
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(1, 0, 1, 1, 1, 1, 1, 0),
            intArrayOf(1, 0, 0, 1, 0, 0, 0, 0),
            intArrayOf(1, 1, 0, 0, 0, 1, 1, 1),
            intArrayOf(1, 1, 1, 1, 0, 0, 0, 0),
            intArrayOf(1, 1, 1, 1, 1, 1, 1, 0),
            intArrayOf(1, 1, 1, 1, 1, 1, 1, 0),
            intArrayOf(1, 1, 1, 1, 1, 1, 1, 0)
        )
    )
    val solution = Solution()
    for (i in board) {
        println(solution.solution(i))
    }
}

data class PathNode(
    val x: Int,
    val y: Int,
    val money: Int,
    val direction: Int
)

val dx = listOf(0, 0, -1, 1)
val dy = listOf(1, -1, 0, 0)

class Solution {
    fun solution(board: Array<IntArray>): Int {
        var answer = Integer.MAX_VALUE

        val queue = LinkedList<PathNode>()

        queue.offer(PathNode(0, 0, 0, -1))
        val dp = Array(4) { Array(26) { Array(26) { Integer.MAX_VALUE } } }
        dp[0][0][0] = 0
        dp[3][0][0] = 0

        queue.offer(PathNode(0, 0, 0, 1))
        queue.offer(PathNode(0, 0, 0, 3))
        while (queue.isNotEmpty()) {
            val (x, y, money, direction) = queue.poll()

            if (x == board.size - 1 && y == board.size - 1) {
                answer = answer.coerceAtMost(money)
                continue
            }
            // 좌우 -1 , 위아래 1 direction 이전 노드까지의 방향성
            for (i in 0..3) {
                val nX = x + dx[i]
                val nY = y + dy[i]
                if (nX in board.indices && nY in board.indices && board[nX][nY] != 1) {
                    val cost = if (direction == -1 || direction == i) money + 100
                    else money + 600
                    // direction == i 이전 방향과 같게 왔는가?

                    if (dp[i][nX][nY] >= cost) {
                        dp[i][nX][nY] = cost
                        queue.add(PathNode(nX, nY, cost, i))
                    }
                }
            }
        }
        return answer
    }
}

/*
https://minjheyy.tistory.com/145
 */
