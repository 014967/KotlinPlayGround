package baekjoon.solution14502

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
    val n = str[0] // 세로
    val m = str[1] // 가로

    var arr = Array(n) { Array<Int>(m) { 0 } }
    for (i in arr.indices) {
        readLine().split(" ").mapIndexed { index, s ->
            arr[i][index] = s.toInt()
        }
    }

}
