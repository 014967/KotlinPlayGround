package baekjoon.줄세우기

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
    val dp = Array(n) { 0 }

    val wordList = readLine().split(" ").map { it.toInt() }
    var min = Integer.MAX_VALUE
    var max = Integer.MIN_VALUE
    for (i in wordList.indices) {
        if (i == 1) {
            dp[0] = 0
        }
        if (i == 2) {
            if (wordList[0] >= wordList[1]) {
                dp[1] = 1
            }
        }

        if (wordList[i] >= max) {
            max = wordList[i]
        }
        if (wordList[i] <= min) {
            min = wordList[i]
        }

        if (i >= 2) {
            if (wordList[i] in min + 1 until max) {
                dp[i] = dp[i - 1] + 1
            } else {
                dp[i] = dp[i - 1]
            }
        }
    }

    println(dp[n - 1])
}
/*
1. 어린 이중 한명을 제일 앞이나 뒤로
2. 빈자리가 생기는 경우 빈자리의 뒤에 있는 어린이들이 한 걸음씩 앞으로 걸어와서 메꾼다.


 */
