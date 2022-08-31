package baekjoon.solution4963

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
val dx = intArrayOf(0, 0, -1, 1, 1, -1, 1, -1)
val dy = intArrayOf(1, -1, 0, 0, 1, -1, -1, 1)
var count = 0
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val list = mutableListOf<Int>()
    while (true) {
        val wh = readLine().split(" ")
        val w = wh[0].toInt() // 너비
        val h = wh[1].toInt() // 높이

        if (w == 0 && h == 0)
            break
        val arr = Array(h) { Array(w) { 0 } }
        val checked = Array(h) { BooleanArray(w) { false } }
        for (i in 0 until h) {
            val lands = readLine().split(" ").map {
                it.toInt()
            }
            for (j in lands.indices) {
                arr[i][j] = lands[j]
            }
        }
        for (i in arr.indices) {
            for (j in arr[i].indices) {
                if (arr[i][j] == 1 && !checked[i][j]) {
                    dfs(arr, checked, i, j)
                    count++
                }
            }
        }
        list.add(count)
        count = 0
    }
    list.forEach {
        println(it)
    }
}
fun dfs(arr: Array<Array<Int>>, checked: Array<BooleanArray>, i: Int, j: Int) {
    checked[i][j] = true
    for (k in 0..7) {
        val x = i + dx[k]
        val y = j + dy[k]

        if (x in 0 until arr.size && y in 0 until arr[0].size && !checked[x][y] && arr[x][y] == 1) {
            dfs(arr, checked, x, y)
        }
    }
}
