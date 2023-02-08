package programmers.N으로표현

import baekjoon.solution13023.flag

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
    val arg = listOf(listOf(5, 12), listOf(2, 11))
    val solution = Solution()
    arg.forEach {
        println(solution.solution(it[0], it[1]))
    }
}

/*
연산을 최소한으로 하기 위해서는 나누기를 한번만 쓰는게 제일 베스트라고 봐도 될까?


 */
class Solution {
    fun solution(N: Int, number: Int): Int {
        var answer = 0

        val dp = Array(32000 * N + 1) { 6401 }
        dp[1] = if (number == 1) 1 else 2
        dp[2] = if (number == 2) 1 else 3

        for (i in 3 until dp.size) {
            var flag = false
            if (i % N == 0) {
                val v = i / N
                for (j in v.toString()) {
                    if (Character.getNumericValue(j) != 1) {
                        flag = true
                        break
                    }
                }
                if (flag) {
                    if (v > 0) {
                        dp[i] = v
                    }
                } else {
                    dp[i] = i.toString().length
                }
            }
        }
        for (i in 3 until dp.size) {
            val k = StringBuilder()
            repeat(i.toString().length) {
                k.append("$N")
            }
            if (k.toString().toInt() < dp.size) {
                if (k.toString().toInt() < i) {
                    dp[i] = minOf(dp[i], dp[k.toString().toInt()] + dp[i - k.toString().toInt()])
                } else {
                    dp[i] = minOf(dp[i], dp[k.toString().toInt()] + dp[k.toString().toInt() - i])
                }
            }
        }
        for (i in 3 until dp.size) {
            var n = (i / N)
            if (n == 0) { //N이하일때
                n++
                dp[i] = minOf(
                    dp[i],
                    minOf(
                        dp[i * N] + 1,
                        minOf(
                            dp[n * N] + dp[N - i],
                            dp[i - 1] + dp[1]
                        )
                    )
                )
            } else {
                n++
                if (i % N != 0) {
                    if (i * N < dp.size) {
                        dp[i] = minOf(
                            dp[i],
                            minOf(
                                dp[i * N] + 1,
                                minOf(
                                    dp[n * N] + dp[n * N - i],
                                    dp[(n - 1) * N] + dp[i - (n - 1) * N]
                                )
                            )
                        )
                    }
                }
            }
        }
        answer = dp[number]

        if (answer > 8) {
            answer = -1
        }
        return answer
    }
}

/*
5와 사직연산만으로 12를 표현할 수 있다
12= 5 + 5 + (5/5) + (5/5)
12 = 55/ 5 + 5/ 5
12 = (55+5) /5
5를 사용한 횟수는 각각 6,5,4
N과 사칙 연ㅅ나 만으로 표현할 수 있는 방법중 N 사용횟수의 최솟값을 구해라

괄호와 사칙연산만 가능하고, 나누기에서 나머지는 무시
최솟값이 8보다 크면 -1 return
 */
