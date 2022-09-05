package baekjoon.solution1946

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
    val testCount = readLine().toInt()
    for (i in 1..testCount) {
        val personCount = readLine().toInt()
        for (i in 1..personCount) {
            val score = readLine().split(" ").map { it.toInt() }
            val paperScore = score[0]
            val personScore = score[1]
        }
    }
}
