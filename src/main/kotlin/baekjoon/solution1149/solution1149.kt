package baekjoon.solution1149

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
    val dp = Array(n + 1) { Array(3) { 0 } }
    for (i in 1..n) {
        val s = readLine().split(" ").map { it.toInt() }.toMutableList()

        dp[i][0] = s[0]
        dp[i][1] = s[1]
        dp[i][2] = s[2]
    }
    for (i in 1..n) {
        dp[i][0] += minOf(dp[i - 1][1], dp[i - 1][2])
        dp[i][1] += minOf(dp[i - 1][0], dp[i - 1][2])
        dp[i][2] += minOf(dp[i - 1][0], dp[i - 1][1])
    }
    println(dp[n].minOf { it })
}

/*

//        if (lastIndex in 0..s.size) {
//            s[lastIndex] = 0
//            val min = s.filter {
//                it != 0
//            }.minOf { it }
//            lastIndex = s.indexOf(min)
//            dp[i] = dp[i - 1] + min
//        } else {
//            val min = s.minOf { it }
//            val index = s.indexOf(min)
//            lastIndex = index
//            dp[i] = dp[i - 1] + min
//        }
 */
