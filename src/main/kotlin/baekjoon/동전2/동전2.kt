package baekjoon.동전2

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
val dp = Array(10_001) { 0 } // 이것은 만드는 수/ 최대 10000임
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, k) = readLine().split(" ").map { it.toInt() }

    val coinArray = Array(n) { 0 }
    for (i in 0 until n) {
        val m = readLine().toInt() // 이게 동전의 가치임
        coinArray[i] = m
    }
    for (i in 1..k) {
        dp[i] = 10_001
    }

    for (i in 1 ..  n) {
        // 코인 가져오자
        val coin = coinArray[i - 1]
        // 이 코인으로 만들 수 있는 수 차기

        for (j in coin..k) {
            dp[j] = minOf(dp[j], dp[j - coin] + 1) // 0 + 1부터 시작인듯
        }
    }
    if (dp[k] == 10_001 || dp[k] == 0) {
        println(-1)
    } else {
        println(dp[k])
    }
}

/*
n가지의 동전을 합쳐서, 그 가치의 합이 k원이 되도록하고 싶은데
동전의 갯수가 최소가 되도록하자.
각각의 동전은 몇개라도 됨

 */
