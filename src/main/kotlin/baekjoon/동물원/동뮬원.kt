package baekjoon.동물원

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
    val N = readLine().toInt()

    val mod = 9901
    val dp = Array(N + 1) { Array(3) { 0 } }

    dp[1][0] = 1
    dp[1][1] = 1
    dp[1][2] = 1

    for (i in 2..N) {
        /*
        현재의 칸의 22 3 2 4 2
        이전의 칸의 사자의 위치에 따라 정해진다.
        세로를 column을 0,1,2
        0 :이전에 사자가 없다 -> 여기서 배치 안해, 아니야 나는 왼쪽 배치, 아니 나는 오른쪽
        1 : 사자를 왼쪽에 배치 -> 여기서 배치 안해, 나느 오른쪽 배치
        2 : 사자를 오른쪽 -> 배치 x 왼쪽
         */
        dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % mod
        dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % mod
        dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % mod
    }

    //맨마지막 행의 0 ,1 ,2 를 더해주면 경우의 수가 나온다~

    println((dp[N][0] + dp[N][1] + dp[N][2]) % mod)
}
/*
가로로 두칸, 세로로 N칸이래
 */
