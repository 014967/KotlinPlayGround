package baekjoon.내려가기

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
    val N = readLine().toInt()

    val table = Array(N) { Array(3) { 0 } }
    val dp = Array(N) { Array(3) { arrayOf(Integer.MAX_VALUE, Integer.MIN_VALUE) } }

    for (i in 0 until N) {
        val line = readLine().split(" ").map { it.toInt() }
        for (j in line.indices) {
            table[i][j] = line[j]
        }
    }

    for (i in table[0].indices) {
        dp[0][i][0] = table[0][i] // Min
        dp[0][i][1] = table[0][i] // Max
    }

    for (i in 1 until table.size) {
        for (j in 0 until 3) {
            if (j == 0) {
                dp[i][j][0] = minOf(
                    dp[i][j][0],
                    minOf(dp[i - 1][j][0], dp[i - 1][j + 1][0]) + table[i][j]
                ) // Min
                dp[i][j][1] = maxOf(
                    dp[i][j][1],
                    maxOf(dp[i - 1][j][1], dp[i - 1][j + 1][1]) + table[i][j]
                ) // Max
            } else if (j == 1) {
                dp[i][j][0] = minOf(
                    dp[i][j][0],
                    minOf(dp[i - 1][j - 1][0], dp[i - 1][j][0], dp[i - 1][j + 1][0]) + table[i][j]
                )
                dp[i][j][1] = maxOf(
                    dp[i][j][1],
                    maxOf(dp[i - 1][j - 1][1], dp[i - 1][j][1], dp[i - 1][j + 1][1]) + table[i][j]
                )
            } else {
                dp[i][j][0] = minOf(
                    dp[i][j][0],
                    minOf(dp[i - 1][j - 1][0], dp[i - 1][j][0]) + table[i][j]
                )
                dp[i][j][1] = maxOf(
                    dp[i][j][1],
                    maxOf(dp[i - 1][j - 1][1], dp[i - 1][j][1]) + table[i][j]
                )
            }
        }
    }
    var min = Integer.MAX_VALUE
    var max = Integer.MIN_VALUE
    for (i in dp[N - 1].indices) {
        val dpmin = dp[N - 1][i][0]
        min = minOf(min, dpmin)
        val dpmax = dp[N - 1][i][1]
        max = maxOf(max, dpmax)
    }
    println("$max $min")
}
