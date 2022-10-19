package baekjoon.solution10942

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
    val n = readLine().toInt()
    val arr = Array(n + 1) { 0 }
    readLine().split(" ").forEachIndexed { index, s ->
        require(s.toInt() in 1..100000)
        arr[index + 1] = s.toInt()
    }
    val m = readLine().toInt()
    for (i in 1..m) {
        val line = readLine().split(" ").map { it.toInt() }
        val s = line[0]
        val e = line[1]
        /*
        s부터 e번째 수가 팰린드럼을 이루는지 ?
         */
    }
}
