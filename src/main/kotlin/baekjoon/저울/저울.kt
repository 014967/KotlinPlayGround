package baekjoon.저울

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
    val m = readLine().toInt()

    val graph = Array(n + 1) { index1 ->
        Array(n + 1) { index2 ->
            if (index1 == index2) {
                0
            } else {
                Integer.MAX_VALUE
            }
        }
    }

    for (i in 1..m) {
        val (thing1, thing2) = readLine().split(" ").map { it.toInt() }
        graph[thing1][thing2] = 1
    }

    for (k in 1..n) {
        for (i in 1..n) {
            for (j in 1..n) {
                if (graph[i][k] == 1 && graph[k][j] == 1) {
                    graph[i][j] = 1
                }
            }
        }
    }

    for (i in 1..n) {
        var count = 0
        for (j in 1..n) {
            if (i == j) {
                continue
            }
            if (graph[i][j] == Integer.MAX_VALUE && graph[j][i] == Integer.MAX_VALUE) {
                count++
            }
        }
        println(count)
    }
}