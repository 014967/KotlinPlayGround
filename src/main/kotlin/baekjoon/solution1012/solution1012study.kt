package baekjoon.solution1012

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

private val dx = listOf(0, 0, -1, 1)
private val dy = listOf(1, -1, 0, 0)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val T = readLine().toInt()
    for (i in 1..T) {
        val testCase = readLine().split(" ").map { it.toInt() }
        val M = testCase[0]
        val N = testCase[1]
        val K = testCase[2]

        val arr = Array(M) { Array(N) { 0 } }
        for (j in 1..K) {
            val str = readLine().split(" ").map {
                it.toInt()
            }
            val x = str[0]
            val y = str[1]

            arr[x][y] = 1
        }

        val check = Array(M) { BooleanArray(N) { false } }
        var count = 0
        for (q in arr.indices) {
            for (w in arr[q].indices) {
                if (arr[q][w] == 1 && !check[q][w]) {
                    dfs(arr, check, q, w)
                    count++
                }
            }
        }
        println(count)
    }
}

private fun dfs(arr: Array<Array<Int>>, check: Array<BooleanArray>, i: Int, j: Int) {

    check[i][j] = true

    for (k in 0..3) {
        val x = i + dx[k]
        val y = j + dy[k]

        if (x in arr.indices && y in arr[0].indices && arr[x][y] == 1 && !check[x][y]) {
            dfs(arr, check, x, y)
        }
    }
}
