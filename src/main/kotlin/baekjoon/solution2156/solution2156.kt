package baekjoon.solution2156

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

/*
포도주 잔을 선택하면 그안에 들어있는 포도주는 모두 마셔야하고, 마신후에 원래 위치로
연속으로 놓여있는 3잔을 모두 마실 수 없다.

될 수 있는 대로 많은 양의 포도주를 맛보자.
 */
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    var arr = arrayListOf<Int>()
    arr.add(0)
    val dp = Array<Int>(n + 1) { 0 }
    for (i in 1..n) {
        arr.add(readLine().toInt())
    }
    dp[0] = 0
    dp[1] = arr[1]
    if (n > 1) {
        dp[2] = dp[1] + arr[2]
    }

    for (i in 3 until arr.size) {
        dp[i] = maxOf(dp[i - 3] + arr[i - 1] + arr[i], dp[i - 1], dp[i - 2] + arr[i])
    }
    println(dp[n])
}

/*
마지막 n 잔을 마셨을때, 이전의 경우
n-1 잔을 마시지 않을 경우 -> n-2를 마실 수 있다.
n-1 잔을 마신 경우 n-2를 고르면 연속 3잔이라 고를 수 없다.

dp[n] = dp[n-2] + arr[n]  n-2 n-1 n 중 n-1을 마시지 않음
dp[n] = dp[n-3] + arr[n-1] + arr[n] // arr[n-2]까지 마시면 조건 위배
dp[n] = dp[n-1] 3잔중에 가운데 잔만 마시는 경우


 */
