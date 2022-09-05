package baekjoon.solution16953

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

var count = 1
var result = 0
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val str = readLine().split(" ").map {
        it.toLong()
    }
    val A = str[0]
    val B = str[1]
    find(A, B, count)
    if (result == 0) {
        println(-1)
    } else {
        println(result)
    }
}

fun find(a: Long, b: Long, count: Int) {

    if (a == b) {
        result = count
        return
    }
    if (a > b) {
        return
    }
    val left = a * 2
    val right = (a.toString() + "1").toLong()

    if (left == b || right == b) {
        result = count + 1
        return
    } else {
        find(left, b, count + 1)
        find(right, b, count + 1)
    }
}
