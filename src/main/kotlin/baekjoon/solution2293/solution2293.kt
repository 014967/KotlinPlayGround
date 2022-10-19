package baekjoon.solution2293

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
    val line = readLine().split(" ").map { it.toInt() }
    val n = line[0]
    val k = line[1]

    val dp = Array(k + 1) { 0 }
    dp[0] = 1 // 0 원을 만드는 경우의 수는 아무런 동전을 쓰지 않는 경우 1가지

    val coinList = Array<Int>(n + 1) { 0 }
    for (i in 1..n) {
        val value = readLine().toInt()
        coinList[i] = value
    }
    for (i in 1..n) {
        for (j in coinList[i]..k) { // x원짜리(coinList[i])를 이용해서 어떤 금액을 만들려면,
            // 최소한 그 금앤은  x원보다 크거나 같아야한다?
            // 3원 짜리 동전을 가지고 1원을 만들 수 없다.
            // 각 동전이 돌면서 k원까지 만들 수 있는 경우의 수를 계속해서 더해주는 것이다.
            dp[j] = dp[j] + dp[j - coinList[i]]
        }
    }
    println(dp[k])
}
