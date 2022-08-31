package baekjoon.solution1520

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
val dx = intArrayOf(0, 0, -1, 1)
val dy = intArrayOf(1, -1, 0, 0)
var count = 0
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val str = readLine().split(" ")
    val m = str[0].toInt()
    val n = str[1].toInt()
    val arr = Array(m) { Array(n) { 0 } }
    val dp = Array(m) { Array(n) { -1 } }
    for (i in 0 until m) {
        val values = readLine().split(" ")
        for (j in values.indices) {
            arr[i][j] = values[j].toInt()
        }
    }

    count = dfs(dp, arr, 0, 0)
    println(count)
}

fun dfs(dp: Array<Array<Int>>, arr: Array<Array<Int>>, i: Int, j: Int): Int {

    if (i == arr.size - 1 && j == arr[i].size - 1) {
        return 1
    }
    if (dp[i][j] != -1) { // 이미계산된 부분이 있다면 반환한다.
        return dp[i][j]
    }
    dp[i][j] = 0
    for (k in 0..3) {
        val x = i + dx[k]
        val y = j + dy[k]

        if (x in arr.indices && y in arr[0].indices && arr[x][y] < arr[i][j]) {
            dp[i][j] += dfs(dp, arr, x, y)
        }
    }
    return dp[i][j]
}
