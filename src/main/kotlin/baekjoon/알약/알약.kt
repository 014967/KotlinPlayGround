package baekjoon.알약

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
    val dp = Array(31) { Array(31) { 0L } }
    for (w in 0..30) {
        for (h in 0..30) {
            if (w < h) {
                continue
            }
            if (h == 0) {
                dp[w][h] = 1 // w로만 이루어짐
            } else {
                dp[w][h] = dp[w][h - 1] + dp[w - 1][h]
            }
        }
    }

    while (true) {
        val n = readLine().toInt()

        if (n == 0) {
            break
        }
        println(dp[n][n])
    }
}

/*
70세 박종수 할아버지는 매일 약반알을 먹는다.
손녀 선영이는 종수 할아버지에게 약이 N개 담긴 병을 선물로 주었다.

첫째날에 종수는 병에서 약하나를 꺼낸다.
그약을 반으로 쪼개서 한조각을 먹고 다른 조각은 다시 병에 넣는다

다음날부터 종수는 약을 하나꺼낸다( 약은 조각 전체일 수도 있고, 쪼갠 반조각일 수 있다)
반조각이라면 그약을 먹고 아니라면 반을 쪼개서 하나 먹고 다시 넣는다


종수는 손녀에게 한 조각을 꺼낸 날에는 W를, 반 조각을 꺼낸 날에는 H보낸다.
손녀는 할아버지에게 받은 문자를 종이에 기록해놓는다.

총 2N일이 지나면 길이가 2N인 문자열이 만들어지게 된다. 이때, 가능한 서로 다른 문자열의 갯수는 총 몇개?

입력은 최대 1000개의 테스트 케이스,
 */
