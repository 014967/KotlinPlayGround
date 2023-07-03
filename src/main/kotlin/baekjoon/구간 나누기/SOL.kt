package baekjoon.`구간 나누기`

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
    val (n, m) = readLine().split(" ").map { it.toInt() }

    val dp = Array(n) { Array(m) { 0 } }
    // n개의 수를 m개의 구간으로 나누었을때 최대 합

    /*
    dp[i][j] = 구간을 i개로 나누고, j번째 숫자까지 고려했을때 얻을 수 있는 구간의 최대합

    j번째 숫자는 i번째 구간에 포함되거나, i번째 구간에 포함되지 않거나

     */

    val arr = Array(n) { -32769 }
    for (i in 0 until n) {
        arr[i] = readLine().toInt()
    }
}
