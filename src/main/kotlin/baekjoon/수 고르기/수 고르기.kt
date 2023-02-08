package baekjoon.`수 고르기`

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
    val (N, M) = readLine().split(" ").map { it.toInt() }

    val A = Array(N) { 0 }
    for (i in 0 until N) {
        val input = readLine().toInt()
        A[i] = input
    }

    A.sort()

    var result = Integer.MAX_VALUE

    var start = 0
    var end = 0
    while (start in A.indices && end in A.indices && start <= end) {
        val first = A[start]
        val second = A[end]

        val gap = second - first
        if (gap < M) {
            end++
        } else {
            result = result.coerceAtMost(gap)
            start++
        }
    }
    println(result)
}

/*
두 수를 고른다( 같은 수 일 수 있다. )
그 차이가 M이상이면서 제일 작은 경우를 구하는 프로그램을 찾아라.
 */
