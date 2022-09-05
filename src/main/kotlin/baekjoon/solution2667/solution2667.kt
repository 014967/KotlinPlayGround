package baekjoon.solution2667

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

private val kx = listOf(1, -1, 0, 0)
private val ky = listOf(0, 0, 1, -1)
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()

    val arr = Array<IntArray>(n) { IntArray(n) { 0 } }
    for (i in 1..n) {
        val line = readLine()
        for (j in line.indices) {
            val k = Character.getNumericValue(line[j])
            arr[i - 1][j] = k
        }
    }

    var count = arrayListOf<Int>()
    val check = Array(n) { BooleanArray(n) { false } }
    for (i in arr.indices) {
        for (j in arr[i].indices) {
            if (arr[i][j] == 1 && !check[i][j]) {
                count.add(dfs(arr, check, i, j))
            }
        }
    }
    count.sort()
    println(count.size)
    count.forEach {
        println(it)
    }
}
fun dfs(arr: Array<IntArray>, check: Array<BooleanArray>, i: Int, j: Int): Int {
    check[i][j] = true
    var count = 1
    for (n in 0 until 4) {
        val x = i + kx[n]
        val y = j + ky[n]

        if (x in arr.indices && y in arr.indices && !check[x][y] && arr[x][y] == 1) {
            count += dfs(arr, check, x, y)
        }
    }
    return count
}
