package baekjoon.선물전달

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
    val dp = Array(1000001) { 0L }

    dp[0] = 0
    dp[1] = 0
    dp[2] = 1
    dp[3] = 2
    val n = readLine().toInt()
    for (i in 4..n) {
        dp[i] = ((i - 1) * (dp[i - 1] + dp[i - 2]) % 1000000000)
    }

    println(dp[n])
}
