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

var count = 0
val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, 1, -1)
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()

    val arr = Array(n) { Array(n) { 0 } }
    var max = Integer.MIN_VALUE
    for (i in 0 until n) {
        val str = readLine().split(" ").map {
            val value = it.toInt()
            if (max < value) {
                max = value
            }
            value
        }
        for (j in str.indices) {
            arr[i][j] = str[j]
        }
    }
    var result = Integer.MIN_VALUE

    for (m in 0..max) {
        val checked = Array(n) { BooleanArray(n) { false } }
        for (i in arr.indices) {
            for (j in arr[i].indices) {
                if (arr[i][j] > m && !checked[i][j]) {
                    dfs(arr, checked, i, j, m)
                    count++
                }
            }
        }
        if (result < count) {
            result = count
        }
        count = 0
    }
    println(result)
}

fun dfs(arr: Array<Array<Int>>, checked: Array<BooleanArray>, i: Int, j: Int, m: Int) {
    checked[i][j] = true
    for (k in 0..3) {
        val x = i + dx[k]
        val y = j + dy[k]
        if (x in arr.indices && y in arr.indices && !checked[x][y] && arr[x][y] > m) {
            dfs(arr, checked, x, y, m)
        }
    }
}
