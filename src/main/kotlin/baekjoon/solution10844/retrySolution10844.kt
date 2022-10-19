package baekjoon.solution10844

import java.io.BufferedReader
import java.io.InputStreamReader

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

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val length = readLine().toInt()
    val dp = Array(101) { Array(10) { 0 } } // 101 length -> 10 각 마지막 수
    dp[1][0] = 0 // 자리수가 1일때 마지막 자리가 0안 수는 없지 1 이상부터
    for (i in 1 until 10) {
        dp[1][i] = 1
    }
    for (i in 2..100) {
        for (j in 0 until 10) {
            if (j == 0) {
                dp[i][j] = dp[i - 1][1] % 1000000000
            } else if (j == 9) {
                dp[i][j] = dp[i - 1][8] % 1000000000
            } else {
                dp[i][j] = (dp[i - 1][j + 1] + dp[i - 1][j - 1]) % 1000000000
            }
        }
    }
    var count = 0
    for (i in dp[length]) {
        count += i
        count %= 1000000000
    }
    println(count)
}
