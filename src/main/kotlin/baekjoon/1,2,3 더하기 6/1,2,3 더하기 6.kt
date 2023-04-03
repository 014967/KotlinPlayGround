package baekjoon.`1,2,3 더하기 6`

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
    val inputList = arrayListOf<Int>()

    var max = Integer.MIN_VALUE
    for (i in 1..n) {
        val input = readLine().toInt()
        inputList.add(input)
        max = max.coerceAtLeast(input)
        // 이제 테스트 시작
    }

    val dp = Array(100001) { 1L } // 경우의수
    dp[0] = 1L
    for (i in 1 until dp.size) {
        if (i > max) {
            break
        }
        var count = 0L
        if (i == 1) {
            dp[1] = 1
        } else if (i == 2) {
            dp[2] = 2
        } else if (i == 3) {
            dp[3] = 2
        } else {
            for (j in 1..3) {
                val less = i - (j * 2) // 2 4 6  ( 5 )
                if (less >= 0) {
                    count += dp[less] % 1000000009
                }
            }
            dp[i] = count % 1000000009
        }
    }
    for (i in inputList) {
        println(dp[i])
    }
}
