package baekjoon.합분해

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
    val (N, K) = readLine().split(" ").map { it.toInt() }
    val dp = Array(K + 1) { Array(N + 1) { 0 } }
    // dp[k][n] = k개를 더해서 합이 N일 경우

    require(N in 1..200) // 합이 무조건 1이상임
    require(K in 1..200)
    for (i in 0..N) {
        dp[1][i] = 1
        // 1개만을 더해서 N이 되는 경우 각 경우의 수는 1임.
    }
    // 정수 k개는 1이상
    for (i in 1..K) {
        for (j in 0..N) {
            for (l in 0..j) {
                dp[i][j] += dp[i - 1][j - l]
            }
        }
    }
    println(dp)
}
/*
점화식
DP[K][N] = K 개를 더해서 합이 N일 경우

ㅁ + ㅁ + ㅁ + ㅁ + L = N
L까지의 갯수가 K라면
L 이전까지의 합은 N - L 이다.
K 개에서 L인 수를 제외하기 때문에 갯수는 K - 1

그니까
DP[K][N] = DP[K-1][N-L] + DP[K][N] 으로 됨



 */

/*
0부터 N까지의 정수 K개를 더해서 그 합이 N이 되는 경우의 수를 구하는 프로그램을 작성하시오.

덧셈의 순서가 바뀐 경우는 다른 경우로 센다(1+2와 2+1은 서로 다른 경우). 또한 한 개의 수를 여러 번 쓸 수도 있다.


1개만을 이용해서 N을 만드는 경우
dp[1][N] = 1개의 경우의 수를 가진다.
 */
