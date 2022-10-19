package programmers.`블록 이동하기`

import java.lang.Math.abs

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
val leftDx = listOf<Int>()
val rightDx = listOf<Int>()
val leftDy = listOf<Int>()
val rightDy = listOf<Int>()

fun main() {
    val board = arrayOf(intArrayOf(0, 0, 0, 1, 1), intArrayOf(0, 0, 0, 1, 0), intArrayOf(0, 1, 0, 1, 1), intArrayOf(1, 1, 0, 0, 1), intArrayOf(0, 0, 0, 0, 0))
    val solution = Solution()
    println(solution.solution(board))
}

class Solution {
    fun solution(board: Array<IntArray>): Int {
        var answer = 0

        val dp = Array<IntArray>(board.size) { IntArray(board.size) { Integer.MAX_VALUE - 1 } }
        dp[0][0] = 0
        dp[0][1] = 0
        for (i in board.indices) {
            for (j in board[i].indices) {
            }
        }
        return answer
    }
}

fun rotate(robot: Pair<Pair<Int, Int>, Pair<Int, Int>>) {
}

fun bfs(
    robot: Pair<Pair<Int, Int>, Pair<Int, Int>>,
    board: Array<IntArray>,
    dp: Array<IntArray>
) {

    if (checkRobotIsHorizontal(robot)) {
        var leftVertex = Pair(0, 0)
        var rightVertex = Pair(0, 0)
        if (robot.first.second < robot.second.second) {
            // 수평이기 때문에 y 좌표만 비교하여 왼쪽에 있는 좌표를 찾는다.
            leftVertex = Pair(robot.first.first, robot.first.second)
            rightVertex = Pair(robot.second.first, robot.second.second)

            /*
            경우의 수 1 아래이동이 있음
             */

            /*
            경우의 수 2 오른쪽 이동
             */
            if (board[rightVertex.first][rightVertex.second + 1] != 1) {
                // 오른쪽에 벽이 있는 경우 이동 못해
                val newRobot = Pair(Pair(robot.first.first, robot.first.second + 1), Pair(robot.second.first, robot.second.second + 1))
                dp[rightVertex.first][rightVertex.second + 1] = minOf(dp[rightVertex.first][rightVertex.second] + 1, dp[rightVertex.first][rightVertex.second + 1])
                bfs(newRobot, board, dp)
            }

            /*
            경우의 수 3 왼쪽 기준 90도 이동
             */
            if (board[leftVertex.first + 1][leftVertex.second + 1] != 1) {
                val newRobot = Pair(Pair(leftVertex.first, leftVertex.second), Pair(rightVertex.first - 1, rightVertex.second - 1))
                dp[rightVertex.first - 1][rightVertex.second - 1] = minOf(dp[leftVertex.first][leftVertex.second] + 1, dp[rightVertex.first - 1][rightVertex.second - 1])
                bfs(newRobot, board, dp)
            }
            /*
            경우의 수 4 오른쪽 기준 90도 이동
             */
            if (board[leftVertex.first + 1][leftVertex.second] != 1) { // 왼쪽 좌표에서 하나 내린부분을 체크
                val newRobot = Pair(Pair(rightVertex.first, rightVertex.second), Pair(leftVertex.first + 1, leftVertex.second + 1))
//                dp[]
            }
        } else {
            leftVertex = Pair(robot.second.first, robot.second.second)
            rightVertex = Pair(robot.first.first, robot.first.second)
        }
    } else {
        // 수직인 경우
        var topVertex = Pair(0, 0)
        var bottomVertex = Pair(0, 0)
        // x만 비교한다.
        if (robot.first.first < robot.second.first) {
            topVertex = Pair(robot.first.first, robot.first.second)
            bottomVertex = Pair(robot.second.first, robot.second.second)
        } else {
            topVertex = Pair(robot.second.first, robot.second.second)
            bottomVertex = Pair(robot.first.first, robot.first.second)
        }
    }
}

fun checkRobotIsHorizontal(robot: Pair<Pair<Int, Int>, Pair<Int, Int>>): Boolean {
    var result = false
    val cal = kotlin.math.abs(
        (robot.first.first - robot.second.first) + (robot.first.second - robot.second.second)
    )
    if (cal == 1) {
        result = true
    }
    return result
}

/*
0 과 1로 이루어진 n * n 크기의 지도에서
2 * 1  z크기인 로봇을 움직여서 (n,n) 위치까지 이동할 수 있도록 프로그래밍
로봇이 이동하는 지도는 가장 왼쪽, 상단의 좌표를 (1,1)로 한다.
벽이 있는 칸 또는 지도 밖으로는 이동할 수 없다.
(1,1)에서 가로방향으로 놓여있는 상태로 시작, 압뒤 구분 없이 움직일 수 있음

로봇이 차지하는 공간 중 한칸이라도 n,n에 도착하면 됌
로봇은 90도 회전이 가능함.
축이 되는 칸으로부터 대각선 방향에는 벽이 없어야함.
한칸 이동하거나 회전하는데 걸리는 시간은 1초임


최소 시간을 return하라고 하니까 bfs를 써야할듯

 */
