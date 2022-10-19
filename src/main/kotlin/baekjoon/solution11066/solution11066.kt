package baekjoon.solution11066

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
    val t = readLine().toInt()
    for (i in 1..t) {
        val page = readLine().toInt()
        val priceArr = Array(page) { 0 }
        readLine().split(" ").mapIndexed { index, s ->
            priceArr[index] = s.toInt()
        }

    }
}
