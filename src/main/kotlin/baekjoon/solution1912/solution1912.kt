package baekjoon.solution1912

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
    val n = readLine().toInt()
    val arr = Array(n) { 0 }
    val dp = Array(n) { 0 }
    readLine().split(" ").mapIndexed { index, it ->
        arr[index] = it.toInt()
    }
    dp[0] = arr[0]
    if (n == 2) {
        dp[1] = arr[1].coerceAtLeast(dp[0] + arr[1])
    } else if (n > 2) {
        dp[0] = arr[0]
        dp[1] = arr[1].coerceAtLeast(dp[0] + arr[1])
        for (i in 2 until arr.size) {
            dp[i] = arr[i].coerceAtLeast(dp[i - 1] + arr[i])
        }
    }
    println(dp.maxOf { it })
}
