package baekjoon.solution11724

import baekjoon.solution2667.arr
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

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val str = readLine().split(" ")
    val n = str[0].toInt()
    val m = str[1].toInt()

    val arr = Array(n + 1) { Array(n + 1) { 0 } }
    val checked = BooleanArray(n + 1) { false }
    for (i in 1..m) {
        val vertex = readLine().split(" ")
        val start = vertex[0].toInt()
        val end = vertex[1].toInt()
        arr[start][end] = 1
        arr[end][start] = 1
    }
    var result = 0
    for (i in 1 until arr.size) {
        if (count == n)
            break
        if (!checked[i]) {
            dfs(arr, checked, i)
            result++
        }
    }
    println(result)
}

fun dfs(arr: Array<Array<Int>>, checked: BooleanArray, start: Int) {

    checked[start] = true
    count++
    for (x in 1 until arr.size) {
        if (arr[start][x] == 1 && !checked[x]) {
            dfs(arr, checked, x)
        }
    }
}
