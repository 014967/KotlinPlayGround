package baekjoon.연속합2

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
    val list = readLine().split(" ").map { it.toInt() }
    val dp = Array(2) { Array(list.size + 1) { 0 } }

    val arr = Array(list.size + 1) { 0 }
    list.forEachIndexed { index, i -> arr[index + 1] = i }
    dp[0][1] = arr[1]
    dp[1][1] = arr[1]

    var answer = Integer.MIN_VALUE

    for (i in 2 until arr.size) {
        dp[0][i] = maxOf(dp[0][i - 1] + arr[i], arr[i]) // 현재값을 포함하던가 말던가
        dp[1][i] = maxOf(dp[0][i - 1], dp[1][i - 1] + arr[i]) // 현재값을 제거하던가, 이미 한개를 제거된 값에서 현재값을 더하던가
        answer = answer.coerceAtLeast(maxOf(dp[0][i], dp[1][i]))
    }
    println(answer)
}
/*
n개의 정수로 이루어진 임의의 수열이 주어진다.
연속된 몇개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합을 구하려고한다,
수는 한개 이상 선택해야한다.
수열에서 수를 하나 제거하거나 아할 수도 있다.

 */
