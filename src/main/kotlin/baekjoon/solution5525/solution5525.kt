package baekjoon.solution5525

import baekjoon.solution1325.dp
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
    val m = readLine().toInt()
    val s = readLine()

    val str = StringBuilder()
    str.append("IOI")
    val p = if (n == 1) {
        str.toString()
    } else {
        for (i in 1 until n) {
            str.append("OI")
        }
        str.toString()
    }

    var count = 0
    for (i in 0 until m - str.length) {
        val k = s.substring(i, i + str.length)
        if (k.equals("IOI")) {
            dp[i + str.length]
        }
        if (k == p) {
            count++
        }
    }
    println(count)
}
