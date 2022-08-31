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

val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, 1, -1)
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()

    val arr = Array(n) { Array(n) { 'a' } }
    val checked = Array(n) { BooleanArray(n) { false } }
    val checked2 = Array(n) { BooleanArray(n) { false } }
    for (i in 0 until n) {
        val str = readLine()
        for (j in str.indices) {
            arr[i][j] = str[j]
        }
    }
    var count = 0
    var count2 = 0
    for (i in arr.indices) {
        for (j in arr[i].indices) {
            if (!checked[i][j]) {
                if (arr[i][j] == 'B') {
                    dfsB(arr, checked, i, j)
                    count++
                } else {
                    dfsRG(arr, checked, i, j)
                    count++
                }
            }
            if (!checked2[i][j]) {
                when (arr[i][j]) {
                    'B' -> {
                        dfsB(arr, checked2, i, j)
                        count2++
                    }
                    'R' -> {
                        dfsR(arr, checked2, i, j)
                        count2++
                    }
                    'G' -> {
                        dfsG(arr, checked2, i, j)
                        count2++
                    }
                }
            }
        }
    }
    println("$count2 $count")
}

fun dfsB(arr: Array<Array<Char>>, checked: Array<BooleanArray>, i: Int, j: Int) {
    checked[i][j] = true

    for (k in 0..3) {
        val x = i + dx[k]
        val y = j + dy[k]

        if (x in arr.indices && y in arr.indices) {
            val color = arr[x][y]
            if (!checked[x][y] && color == 'B') {
                dfsB(arr, checked, x, y)
            }
        }
    }
}
fun dfsRG(arr: Array<Array<Char>>, checked: Array<BooleanArray>, i: Int, j: Int) {
    checked[i][j] = true
    for (k in 0..3) {
        val x = i + dx[k]
        val y = j + dy[k]
        if (x in arr.indices && y in arr.indices) {
            val color = arr[x][y]
            if ((color == 'R' || color == 'G') && !checked[x][y]) {
                dfsRG(arr, checked, x, y)
            }
        }
    }
}
fun dfsR(arr: Array<Array<Char>>, checked: Array<BooleanArray>, i: Int, j: Int) {
    checked[i][j] = true
    for (k in 0..3) {
        val x = i + dx[k]
        val y = j + dy[k]
        if (x in arr.indices && y in arr.indices) {
            val color = arr[x][y]
            if (color == 'R' && !checked[x][y]) {
                dfsR(arr, checked, x, y)
            }
        }
    }
}
fun dfsG(arr: Array<Array<Char>>, checked: Array<BooleanArray>, i: Int, j: Int) {
    checked[i][j] = true
    for (k in 0..3) {
        val x = i + dx[k]
        val y = j + dy[k]
        if (x in arr.indices && y in arr.indices) {
            val color = arr[x][y]
            if (color == 'G' && !checked[x][y]) {
                dfsG(arr, checked, x, y)
            }
        }
    }
}
