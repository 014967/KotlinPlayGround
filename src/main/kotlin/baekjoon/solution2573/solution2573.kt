package baekjoon.solution2573

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

val dx = intArrayOf(1, -1, 0, 0)
val dy = intArrayOf(0, 0, 1, -1)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val str = readLine().split(" ")
    val n = str[0].toInt()
    val m = str[1].toInt()
    require(n in 3..300 && m in 3..300)
    val arr = Array(n) { Array(m) { 0 } }

    for (i in 0 until n) {
        val input = readLine().split(" ")
        for (j in input.indices) {
            arr[i][j] = input[j].toInt()
        }
    }

    println(getYear(arr))
}

fun getYear(arr: Array<Array<Int>>): Int {
    var year = 0
    while (true) {
        var count = 0
        val checked = Array(arr.size) { Array(arr[0].size) { false } }
        val sea = Array(arr.size) { Array(arr[0].size) { 0 } }
        var flag = false
        for (i in 1 until arr.size - 1) {
            for (j in 1 until arr[i].size - 1) {
                if (arr[i][j] > 0) {
                    flag = true
                }
                if (!checked[i][j] && arr[i][j] != 0) {
                    dfs(arr, checked, i, j, sea)
                    count++
                }
            }
        }
        if (!flag)
            return 0

        if (count >= 2) {
            return year
        }
        for (i in 1 until arr.size - 1) {
            for (j in 1 until arr[i].size - 1) {

                if (arr[i][j] - sea[i][j] >= 0) {
                    arr[i][j] -= sea[i][j]
                } else {
                    arr[i][j] = 0
                }
            }
        }
        year++
    }

    return 0
}

fun dfs(arr: Array<Array<Int>>, checked: Array<Array<Boolean>>, i: Int, j: Int, sea: Array<Array<Int>>) {
    checked[i][j] = true

    for (k in 0..3) {
        val x = i + dx[k]
        val y = j + dy[k]

        if (x in arr.indices && y in arr[x].indices) {

            if (arr[x][y] == 0) {
                sea[i][j]++
            }
            if (!checked[x][y] && arr[x][y] != 0) {
                dfs(arr, checked, x, y, sea)
            }
        }
    }
}
