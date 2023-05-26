package baekjoon.오르막수

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

var N: Int = 0
var result = 0
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    // 자리가 오름차순을 이루는 수 , 인접한 수가 같아도 오름차순으로 침.
    // 수의 길이 N이 우저였을때, 오르 수의 갯수를 구하는 프로그램을 작성해라.
    N = br.readLine().toInt() // 자리수
    val table = Array(N + 1) { Array(10) { 1 } }
    for (i in 2 until table.size) {
        for (j in 1 until table[i].size) {
            table[i][j] = (table[i - 1][j]  + table[i][j - 1]) % 10007
        }
    }
    println(table[N].sum() % 10007)
}
            // 마지막 자리수
/*             0 1 2 3 4 5 6 7 8 9
자리수가 1 이면 :  1 1 1 1 1 1 1 1 1
자리수가 2 이면 :  1 2 3 4 5 6 7 8 9  -> 55
자리수가 3 이면 :  3 5 8 12 5555 2 -> 220
 */