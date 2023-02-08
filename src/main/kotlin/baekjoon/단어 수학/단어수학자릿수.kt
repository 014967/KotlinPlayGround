package baekjoon.`단어 수학`

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.pow

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
    val n = readLine().toInt()

    val alphaBetArray = Array(26) { 0 }
    for (i in 1..n) {
        val word = readLine().toList()
        var pos = (10f.pow(word.size - 1)).toInt()
        for (j in word.indices) {
            alphaBetArray[word[j] - 'A'] += pos
            pos /= 10
        }
    }
    alphaBetArray.sortByDescending { it }
    var result = 0
    var max = 9
    for (i in alphaBetArray.indices) {
        if (max == 0) {
            break
        }
        if (alphaBetArray[i] != 0) {
            result += alphaBetArray[i] * max--
        }
    }
    println(result)
}
