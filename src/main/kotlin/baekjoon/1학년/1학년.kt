package baekjoon.`1학년`

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

var result = 0
lateinit var nList: List<Int>
lateinit var dp: Array<Array<Long>>
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()
    nList = readLine().split(" ").map { it.toInt() }
    dp = Array(100) { Array(21) { 0L } } // Int로 담을 수가 없다.
    dp[0][nList[0]] = 1
    // 첫번째로 8은 만들 수 있는 경우의 수가 1임/ 음수모르니까

    for (i in 1 until N) {
        for (j in 0..20) {
            if (dp[i - 1][j] != 0L) {
                // 이게 무슨말이나면 탐색했던 값에서만 값이 뻗어나갈 수 있도록함.

                if (j + nList[i] in 0..20) {
                    dp[i][j + nList[i]] += dp[i - 1][j]
                }

                if (j - nList[i] in 0..20) {
                    dp[i][j - nList[i]] += dp[i - 1][j]
                }
            }
        }
    }
    println(dp[N - 2][nList.last()])
}

/*
마지막 두 숫자 사이에 =를 넣고,
나머지 숫자 사이에 + , - 를 넣어 등식을 만들며 놀고 있다.

아직 학교에서 음수를 배우지 않았고, 20을 넘는 수는 모른다.
따라서 왼쪽부터 계산ㄴ할때 중간에 나오는 수가 모두 0이상 20이하이어야한다.
 */
