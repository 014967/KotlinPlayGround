package baekjoon.`함꼐 블록쌓기`

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
    val (N, M, H) = readLine().split(" ").map { it.toInt() }
    // 높이 H , 학생 수 N, 최대 가질 수 있는 블록 갯수 M

    val arr = Array(N + 1) { arrayListOf<Int>() }
    val dp = Array(N + 1) { Array(H + 1) { 1 } }
    for (i in 1..N) {
        val blocks = readLine().split(" ").map { it.toInt() }
        arr[i].add(0)
        for (j in blocks) {
            arr[i].add(j)
        }
    }

    for (i in 1..N) {
        for (j in arr[i].indices) {
            for (k in 1..H) {
                dp[i][j] += dp[i-1][j]
            }
        }
    }
}

/*

 */
