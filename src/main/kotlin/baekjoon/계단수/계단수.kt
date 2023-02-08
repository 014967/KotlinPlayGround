package baekjoon.계단수

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

val memo = Array(101) { Array(10) { Array((1 shl 10)) { 0 } } }
var n: Int = 0
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    println(1 shl(1)) // 2 (10)
    println(1 shl(8)) // 256 (100000000)

    n = readLine().toInt()
    var answer = 0
    for (k in 1 until 10) {
        answer += counter(1, k, 1 shl k) % 1000000000
    }
    println(answer)
}
fun counter(i: Int, m: Int, k: Int): Int {
    if (memo[i][m][k] == 1) return memo[i][m][k]
    if (i == n && k == 1023) return 1
    else if (i == n && k !=  1023) {
        return 0
    }
    if (m == 0) {
        memo[i][m][k] = counter(i + 1, 1, k = k or 1 shl(1))
    } else if (m == 9) memo[i][m][k] = counter(i + 1, 8, k = k or 1 shl(8))
    else {
        memo[i][m][k] = (counter(i + 1, m - 1, k or 1 shl(m - 1)) + counter(i + 1, m + 1, k or 1 shl(m + 1))) % 1000000000
    }

    return memo[i][m][k]
}
/*
비트 마스킹은 어떤 옵션들이 선택되었는지 한번에 확인하고자할때
어떤 정점들을 거쳤는지/방문했는지 한번에 확인하고자할떄
어떤 물건들을 챙겼는지 한번에 확인할ㄲ대

단한번의 연산으로 확인할 수 있게됌.

memo[i][m][k]
i = 몇번째 숫자인지 ( 최대 100 )
m = 현재 어떤 수인지 ( 0 ~ 9 )
k = 비트마스크
 */
