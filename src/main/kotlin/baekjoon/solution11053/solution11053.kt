package baekjoon.solution11053

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
    require(n in 1..1000)

    val a = IntArray(n + 1) { 0 }
    val d = IntArray(n + 1) { 0 }

    readLine().split(" ").mapIndexed { index, s ->
        a[index + 1] = s.toInt()
    }
//    algoDp(a, d)
    algoDown(a, d)
}
fun algoDp(a: IntArray, d: IntArray) {
    for (i in 1 until a.size) {
        for (j in 0 until i) {
            if (a[j] < a[i]) d[i] = maxOf(d[i], d[j] + 1)
        }
    }
    println(d.maxOrNull())
}

fun algoDown(a: IntArray, d: IntArray) {
    for (i in 1 until a.size) {
        for (j in 0 until i) {
            if (a[j] > a[i]) d[i] = maxOf(d[i], d[j] + 1)
        }
    }
    println(d.maxOrNull())
}
