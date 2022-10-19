package baekjoon.solution10026

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

val dx = listOf(0, 0, -1, 1)
val dy = listOf(1, -1, 0, 0)
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val arr = Array(n) { Array(n) { 'a' } }
    val check = Array(n) { BooleanArray(n) { false } }
    val checkRG = Array(n) { BooleanArray(n) { false } }
    for (i in 0 until n) {
        var str = readLine().toString()
        for (j in str.indices) {
            arr[i][j] = str[j]
        }
    }

    var countNone = 0
    var count = 0
    for (i in arr.indices) {
        for (j in arr[i].indices) {
            if (!check[i][j]) {
                when (arr[i][j]) {
                    'B' -> {
                        dfsB(arr, check, i, j)
                        countNone++
                    }
                    'R' -> {
                        dfsR(arr, check, i, j)
                        countNone++
                    }
                    'G' -> {
                        dfsG(arr, check, i, j)
                        countNone++
                    }
                }
            }
            if (!checkRG[i][j])
                if (arr[i][j] == 'B') {
                    dfsB(arr, checkRG, i, j)
                    count++
                } else {
                    dfsRG(arr, checkRG, i, j)
                    count++
                }
        }
    }
    print(countNone)
    print(" ")
    print(count)


}

private fun dfsB(arr: Array<Array<Char>>, checked: Array<BooleanArray>, i: Int, j: Int) {
    checked[i][j] = true

    for (k in 0..3) {
        val x = i + dt[k]
        val y = j + dr[k]

        if (x in arr.indices && y in arr.indices) {
            val color = arr[x][y]
            if (!checked[x][y] && color == 'B') {
                dfsB(arr, checked, x, y)
            }
        }
    }
}
private fun dfsRG(arr: Array<Array<Char>>, checked: Array<BooleanArray>, i: Int, j: Int) {
    checked[i][j] = true
    for (k in 0..3) {
        val x = i + dt[k]
        val y = j + dr[k]
        if (x in arr.indices && y in arr.indices) {
            val color = arr[x][y]
            if ((color == 'R' || color == 'G') && !checked[x][y]) {
                dfsRG(arr, checked, x, y)
            }
        }
    }
}
private fun dfsR(arr: Array<Array<Char>>, checked: Array<BooleanArray>, i: Int, j: Int) {
    checked[i][j] = true
    for (k in 0..3) {
        val x = i + dt[k]
        val y = j + dr[k]
        if (x in arr.indices && y in arr.indices) {
            val color = arr[x][y]
            if (color == 'R' && !checked[x][y]) {
                dfsR(arr, checked, x, y)
            }
        }
    }
}
private fun dfsG(arr: Array<Array<Char>>, checked: Array<BooleanArray>, i: Int, j: Int) {
    checked[i][j] = true
    for (k in 0..3) {
        val x = i + dt[k]
        val y = j + dr[k]
        if (x in arr.indices && y in arr.indices) {
            val color = arr[x][y]
            if (color == 'G' && !checked[x][y]) {
                dfsG(arr, checked, x, y)
            }
        }
    }
}

