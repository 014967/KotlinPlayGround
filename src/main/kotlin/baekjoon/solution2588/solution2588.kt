package baekjoon.solution2588

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
    val first = readLine().toInt()
    val second = readLine()
    println(first * Character.getNumericValue(second[2]))
    println(first * Character.getNumericValue(second[1]))
    println(first * Character.getNumericValue(second[0]))
    println(first * second.toInt())
}
