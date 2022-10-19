package baekjoon.solution4963

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * @desc
 *
 * @input
 *
 * @outputㅏ
 *
 * @example
 *
 */
val di = listOf(0, 0, -1, 1, 1, 1, -1, -1)
val dj = listOf(1, -1, 0, 0, 1, -1, 1, -1)
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    while (true) {
        val line = readLine().split(" ").map { it.toInt() }
        val w = line[0]
        val h = line[1]
        if (w == 0 && h == 0) {
            break
        } else {
            val arr = Array(w) { Array(h) { 0 } }
            val check = Array(w) { Array(h) { false } }
            for (i in 0 until h) {
                val str = readLine().split(" ").map { it.toInt() }
                for (j in str.indices) {
                    arr[j][i] = str[j]
                }
            }
            var count = 0
            for (i in arr.indices) {
                for (j in arr[i].indices) {
                    if (!check[i][j] && arr[i][j] == 1) {
                        bfs(arr, check, i, j)
                        count++
                    }
                }
            }
            println(count)
        }

    }
}

fun bfs(arr: Array<Array<Int>>, check: Array<Array<Boolean>>, i: Int, j: Int) {
    check[i][j] = true
    for (k in di.indices) {
        val x = i + di[k]
        val y = j + dj[k]

        if (x in arr.indices && y in arr[x].indices && !check[x][y] && arr[x][y] == 1) {
            bfs(arr, check, x, y)
        }
    }
}
