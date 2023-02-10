package baekjoon.암호코드

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
    val str = readLine()
    val dp = Array(str.length + 1) { 0 } // 자리수에 해당
    dp[0] = 1
    dp[1] = 1

    val mod = 1000000
    if (Character.getNumericValue(str[0]) == 0) {
        println(0)
    } else {
        for (i in 1 until str.length) {
            if (Character.getNumericValue(str[i]) != 0) {
                dp[i + 1] = dp[i] % mod
            }
            val builder = StringBuilder()
            builder.append(str[i - 1])
            builder.append(str[i])
            val target = builder.toString().toInt()
            if (target in 10..26) {
                dp[i + 1] = (dp[i + 1] + dp[i - 1]) % mod
            }
        }
    }
    println(dp[str.length])
}
/*
25114

2 5 1 1 4
2 5 11 4
2 5 1 14
25 1 1 4
25 11 4
25 1 14

 */
