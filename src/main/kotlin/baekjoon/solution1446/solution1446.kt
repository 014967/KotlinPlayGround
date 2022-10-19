package baekjoon.solution1446

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Collections.min
import kotlin.math.min

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
    val first = readLine().split(" ").map {
        it.toInt()
    }
    val n = first[0]
    val d = first[1]
    val arr = Array(10000) { arrayListOf<Pair<Int, Int>>() }
    val dp = Array(d + 1) { Integer.MAX_VALUE }
    dp[0] = 0
    for (i in 0 until n) {
        val line = readLine().split(" ").map { it.toInt() }
        val start = line[0]
        val end = line[1]
        val length = line[2]
        arr[end].add(Pair(start, length))
    }
    for (i in 1..d) {
        if (arr[i].size == 0) dp[i] = dp[i - 1] + 1
        else {
            for (j in arr[i]) {
                dp[i] = min(dp[i], min(dp[i - 1] + 1, dp[j.first] + j.second))
            }
        }
    }
    println(dp[d])
}
