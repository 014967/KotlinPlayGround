package baekjoon.solution2606

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

var count = -1
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    require(n <= 100)

    val arr = Array(n + 1) { Array(n + 1) { 0 } }
    val comCount = readLine().toInt()
    for (i in 1..comCount) {
        val str = readLine().split(" ")
        val start = str[0].toInt()
        val end = str[1].toInt()
        arr[start][end] = 1
        arr[end][start] = 1
    }
    val checked = BooleanArray(n + 1) { false }
    dfs(arr, checked, 1)
    println(count)
}

fun dfs(arr: Array<Array<Int>>, checked: BooleanArray, start: Int) {
    checked[start] = true
    count++
    for (i in 1 until arr.size) {
        if (checked[i] || arr[start][i] != 1)
            continue
        dfs(arr, checked, i)
    }
}
