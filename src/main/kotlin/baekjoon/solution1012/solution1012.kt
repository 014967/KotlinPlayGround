package baekjoon.solution1012

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

private val dx = intArrayOf(0, 0, 1, -1)
private val dy = intArrayOf(1, -1, 0, 0)
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val t = readLine().toInt()

    val answerArr = mutableListOf<Int>()
    for (j in 1..t) {
        val str = readLine().split(" ")
        val m = str[0].toInt()
        val n = str[1].toInt()
        val k = str[2].toInt()
        var arr = Array(51) { Array <Int>(51) { 0 } }

        for (i in 1..k) {
            val xy = readLine().split(" ")
            val x = xy[0].toInt()
            val y = xy[1].toInt()
            arr[x][y] = 1
        }

        val checked = Array(51) { BooleanArray(51) { false } }
        val resultArr = mutableListOf<Int>()
        for (i in arr.indices) {
            for (j in arr[i].indices) {
                if (arr[i][j] == 1 && !checked[i][j]) {
                    val result = dfs(arr, checked, i, j)
                    resultArr.add(result)
                }
            }
        }
        answerArr.add(resultArr.size)
    }
    answerArr.forEach {
        println(it)
    }
}

private fun dfs(arr: Array<Array<Int>>, checked: Array<BooleanArray>, i: Int, j: Int): Int {

    var count = 1
    checked[i][j] = true
    for (k in 0..3) {
        val x = i + dx[k]
        val y = j + dy[k]

        if (x in arr.indices && y in arr.indices && arr[x][y] == 1 && !checked[x][y]) {
            count += dfs(arr, checked, x, y)
        }
    }
    return count
}
