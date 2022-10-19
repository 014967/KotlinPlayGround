package baekjoon.solution2468

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
    val arr = Array(n) { Array(n) { 0 } }
    var max = Integer.MIN_VALUE
    for (i in 0 until n) {
        val line = readLine().split(" ").map { it.toInt() }
        for (j in line.indices) {
            arr[i][j] = line[j]
            if (max < line[j]) {
                max = line[j]
            }
        }
    }

    var result = 0
    for (d in 1..max) {
        val check = Array(n) { Array(n) { false } }
        var count = 0
        for (i in arr.indices) {
            for (j in arr[i].indices) {
                if (!check[i][j] && arr[i][j] > d) {
                    dfs(i, j, check, arr, d)
                    count++
                }
            }
        }
        if (result < count) {
            result = count
        }
    }
    println(result)
}

fun dfs(i: Int, j: Int, check: Array<Array<Boolean>>, arr: Array<Array<Int>>, d: Int) {
    check[i][j] = true

    for (k in 0 until 4) {
        val x = i + dx[k]
        val y = j + dy[k]
        if (x in arr.indices && y in arr.indices && !check[x][y] && arr[x][y] > d) {
            dfs(x, y, check, arr, d)
        }
    }
}
