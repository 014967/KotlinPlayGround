package programmers.`코딩테스트 공부`

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
    val alp = 10
    val cop = 10
    val problems = arrayOf(intArrayOf(10, 15, 2, 1, 2), intArrayOf(20, 20, 3, 3, 4))
    val solution = Solution()
    println(solution.solution(alp, cop, problems))
}

class Solution {
    var maxAlp = 0
    var maxCop = 0
    fun solution(alp: Int, cop: Int, problems: Array<IntArray>): Int {
        var answer: Int = 0

        // 문제의 길이는 100
        for (i in problems.indices) {
            maxAlp = maxAlp.coerceAtLeast(problems[i][0])
            maxCop = maxCop.coerceAtLeast(problems[i][1])
            // alp_req 필요한 알고력, cop_req 필요한 코딩력 ,alp_rwd 풀었을때 올라가는 알고력
        }

        if (alp > maxAlp) {
            maxAlp = alp
        }
        if (cop > maxCop) {
            maxCop = cop
        }

        answer = getAnswer(alp, cop, problems)
        return answer
    }

    fun getAnswer(alp: Int, cop: Int, problems: Array<IntArray>): Int {
        val dp = Array(152) { Array(152) { Integer.MAX_VALUE } }
        dp[alp][cop] = 0
        // dp[alp][cop] 주어진 알고력과 고딩력을 시작으로 모든 문제를 풀수 있는 알고력과 코딩력을 얻는 최단시간
        // alp cop이 최대 150 이나까 위와 같은 배열 만듬

        for (i in alp..maxAlp) {
            for (j in cop..maxCop) {
                // 알고력 트레이닝
                dp[i + 1][j] = dp[i + 1][j].coerceAtMost(dp[i][j] + 1)

                // 코딩력 트레이닝
                dp[i][j + 1] = dp[i][j + 1].coerceAtMost(dp[i][j] + 1)

                for (k in problems.indices) {
                    val (alp_req, cop_req, alp_rwd, cop_rwd, cost) = problems[k]
                    if (i >= alp_req && j >= cop_req) {
                        // 문제를 풀수 있는 경우

                        val nextI = if (i + alp_rwd > maxAlp) maxAlp else i + alp_rwd
                        val nextJ = if (j + cop_rwd > maxCop) maxCop else j + cop_rwd
                        dp[nextI][nextJ] = dp[nextI][nextJ].coerceAtMost(
                            dp[i][j] + cost
                        )
                    }
                }
            }
        }

        return dp[maxAlp][maxCop]
    }
}

/*
문제를 풀기 위해서 알고력과 코딩력이 필요하다.
A라는 문제가 알고력 10 , 코딩력 10을 요구한다면 A문제를 풀 수 있다.
B라는 문제가 알고력 10, 코딩력 20 을 요구한다면 코딩력이 부족해서 문제를 풀수 없다

풀수 없는 문제를 위해서, 알고력과 코딩력을 높임
알고력 1을 높히기 위해 1의 시간이 필요
코딩력 1을 높히기 위해 1의 시간이 필요

현재 풀수 있는 문제중 하나를 풀어서 알고력과 코딩력을 높힌다.
문제마다 올릴 수 있는 알고력과 코딩력이 정해져있다

문제를 하나 푸는데 문제가 요구하는 시간이 필요하고 같은 문제를 여러번 풀 수 있다.
모든 문제를 풀 수 있는 알고력과 코딩력이 필요하다.
 */
