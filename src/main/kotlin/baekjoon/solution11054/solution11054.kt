package baekjoon.solution11054

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

    val dpUp = IntArray(n + 1) { 0 }
    val dpDown = IntArray(n + 1) { 0 }
    val a = IntArray(n + 1) { 0 }
    readLine().split(" ").mapIndexed { index, s ->
        a[index + 1] = s.toInt()
    }

    upDp(a, dpUp)
    a.reverse()
    downDp(a, dpDown)
    dpDown.reverse()

    var max = 0
    for (i in a.indices) {
        if (max <dpUp[i] + dpDown[i])
            max = dpUp[i] + dpDown[i]
    }
    println(max)
//    println("$dpUp $dpDown")
}
fun upDp(a: IntArray, dpUp: IntArray) {
    for (i in 1 until a.size) {
        for (j in 0 until i) {
            if (a[j] < a[i]) dpUp[i] = maxOf(dpUp[i], dpUp[j] + 1)
        }
    }
}
fun downDp(a: IntArray, dpDown: IntArray) {
    for (i in 1 until a.size) {
        for (j in 0 until i) {
            if (a[j] < a[i]) dpDown[i] = maxOf(dpDown[i], dpDown[j] + 1)
        }
    }
}
