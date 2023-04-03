package baekjoon.`카드 구매하기`

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
    val s = readLine().split(" ").map { it.toInt() }
    val dp = Array(n + 1) { 0 }
    s.forEachIndexed { index, i ->
        dp[index + 1] = i
    }
    for (i in 1..n) {
        if (i >= 2) {
            for (j in 1..i) {
                if (i % j == 0) {
                    // j로 나누어 떨어진다면
                    val less = i / j
                    dp[i] = dp[i].coerceAtLeast(dp[j] * less)
                }
                dp[i] = dp[i].coerceAtLeast(dp[j] + dp[i - j])
            }

            dp[i] = maxOf(dp[i], dp[1] * i, dp[i - 1] + dp[1])
        }
    }

    println(dp[n])
}
/*

카드는 카드팩의 형태로 구매 가능, N개가 포함된 카드팩과 같이 총 N개가 존재(1~N개)

카드의 갯수가 적은팩이더라두 가격이 비싸면 높은 등급의 카드가 많이 들어있을 것이라는 미신을 믿고 있다.
돈을 최대로 지불해서 카드N개를 구매하려고한다.
카드가 i개 포함된 카드팩의 가격은 pi원임.


 */
