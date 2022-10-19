package baekjoon.solution2225

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
    val str = readLine().split(" ").map { it.toInt() }
    val n = str[0]
    val k = str[1]
    val dp = Array(n + 1) { Array(k + 2) { 0 } }
    for (x in 0 until dp.size) {
        for (y in 1 until dp[x].size) {
            if (y == 1) {
                dp[x][y] = 1
            } else if (x == 0) {
                dp[x][y] = 1
            } else {
                dp[x][y] = (dp[x - 1][y] + dp[x][y - 1]) % 1000000000
            }
        }
    }
    println(dp[n][k])
}
/*
1 <= N <= 200 , 1 <= k <= 200
if n == 1 , k== 1
1   dp[1][1] = 1

if n == 1, k == 2  dp[1][2] = 2
0,1
1,0

if n == 1, k ==3 dp[1][3]
3개를 더해서 1이 되는 경우가 있나?
없음

if n ==2 , k ==1 dp[2][1] // k가 1인경우는 그 수밖에 없음
2


if n ==2 , k ==2 // 2개를 꺼내서 2가 되는 경우의 수
0,2
2,0
1,1
 */
