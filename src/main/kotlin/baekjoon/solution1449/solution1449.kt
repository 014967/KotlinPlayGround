package baekjoon.solution1449

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

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
    val n = str[0] // 좌표 갯수
    val l = str[1] // 테이프 길이
    val pipe = readLine().split(" ").map { it.toInt() }.sorted()

    var current = 0
    var count = 1
    for (i in 0 until n) {
        if (pipe[i] - pipe[current] >= l) {
            count++
            current = i
        }
    }
    println(count)
}
/*
못품;
 */
