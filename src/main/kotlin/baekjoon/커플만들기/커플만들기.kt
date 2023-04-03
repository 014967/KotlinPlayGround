package baekjoon.커플만들기

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

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
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val manList = readLine().split(" ").map { it.toInt() }.sorted()
    val womanList = readLine().split(" ").map { it.toInt() }.sorted()

    val dp = Array(n + 1) { Array(m + 1) { 0 } }

    for (i in 1..n) {
        for (j in 1..m) {
            dp[i][j] = dp[i - 1][j - 1] + abs(manList[i - 1] - womanList[j - 1])
            if (i < j) {
                dp[i][j] = minOf(dp[i][j - 1], dp[i][j])
            } else if (i > j) {
                dp[i][j] = minOf(dp[i - 1][j], dp[i][j])
            }
        }
    }

    println(dp[n][m])
}
/*

여자친구가 없는 남자 n명과 여자 m을 불러모아서 이성 친구를 만들어주기로 했다.
비슷한 성격의 사람들을 지어주기로하자.

--

커플을 이루는 두사람의 성격의 차이의 합이 최소가 되도락한다. 남자  -  여자

n개를 먼저 남자의 성격
m개를 여자들의 성격

우선 순위가 최대한 많은 커플들을 만드는 것
그다음이 두사람의 성격 차의의 합이 최소가 되도록
 */
