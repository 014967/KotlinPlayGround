package baekjoon.`가장 큰 정사각형`

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
    val table = Array(n + 1) { Array(m + 1) { 0 } }

    for (i in 1..n) {
        val line = readLine().toList()
        for (j in 1..line.size) {
            table[i][j] = Character.getNumericValue(line[j - 1])
        }
    }

    val dp = table.map { it.clone() }

    /*
    정사각형이 되기 위한 점화식

    dp[i][j] = 왼쪽 대각선 위 , 왼쪽, 위 에서 가장 작은값 + 1
     */

    var max = 0
    for (i in 1..n) {
        for (j in 1..m) {
            if (table[i][j] == 1) {
                dp[i][j] = minOf(dp[i - 1][j - 1], dp[i][j - 1], dp[i - 1][j]) + 1
                max = max.coerceAtLeast(dp[i][j])
            }
        }
    }
    println(max * max)
}
