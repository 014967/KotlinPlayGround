package baekjoon.앱

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
    val (N, M) = readLine().split(" ").map { it.toInt() }
    // N = 활성화된 앱 개수
    // M = 확보해야하는 바이트
    val bytes = readLine().split(" ").map { it.toLong() }
    val costs = readLine().split(" ").map { it.toInt() }

    // 행 : i번째 앱까지 확인했ㅇ르때 , 열 : j 의 비용으로 얻을 수 있는 최대의 메모리

    val dp = Array(101) { Array(10001) { 0L } }

    for (i in 1 until N + 1) {
        for (j in dp[0].indices) {
            if (j >= costs[i - 1]) {
                dp[i][j] = maxOf(dp[i - 1][j], dp[i - 1][j - costs[i - 1]] + bytes[i - 1])
            } else {
                dp[i][j] = maxOf(dp[i - 1][j])
            }
        }
    }

    var answer = 0
    for (i in dp[N].indices) {
        if (dp[N][i] >= M) {
            answer = i
            break
        }
    }

    println(answer)
}

/*
재귀 함수로 dp를 작성하는 것을 Top-Down
메모이제이션


반복문으로 DP를 작성하는 것을 Bottom-Up
작은 문제부터 차근차근 답을 도출한다는 것.
DP 테이블이 사용
 */
