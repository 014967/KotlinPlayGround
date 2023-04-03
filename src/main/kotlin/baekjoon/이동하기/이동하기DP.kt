package baekjoon.이동하기

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
lateinit var table2: Array<Array<Int>>
lateinit var memo: Array<Array<Int>>
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (r, c) = readLine().split(" ").map { it.toInt() }
    table2 = Array(r + 1) { Array(c + 1) { 0 } }
    memo = Array(r + 1) { Array(c + 1) { 0 } }
    for (i in 1..r) {
        val line = readLine().split(" ").map { it.toInt() }
        for (j in line.indices) {
            table2[i][j + 1] = line[j]
        }
    }
    memo[1][1] = table2[1][1]
    for (i in 1..r) {
        for (j in 1..c) {
            memo[i][j] = maxOf(memo[i - 1][j - 1], maxOf(memo[i - 1][j], memo[i][j - 1]) + table2[i][j])
        }
    }
    println(memo[r][c])
}
