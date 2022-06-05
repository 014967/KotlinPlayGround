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

var checkedArr = arrayOf<BooleanArray>()
var arr = arrayListOf<List<Int>>()

val dx = intArrayOf(1, -1, 0, 0)
val dy = intArrayOf(0, 0, 1, -1)
var resultArr = arrayListOf <Int>()
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var n = readLine().toInt()
    checkedArr = Array(n) { BooleanArray(n) { false } }
    for (i in 1..n) {
        val list = mutableListOf<Int>()
        val row = readLine()
        for (i in row) {
            list.add(Character.getNumericValue(i))
        }
        arr.add(list)
    }
    for (i in arr.indices) {
        for (j in arr[i].indices) {
            if (arr[i][j] == 1 && !checkedArr[i][j]) {
                var result = dfs(arr, checkedArr, i, j, n)
                resultArr.add(result)
            }
        }
    }
    println(resultArr.size)
    resultArr.sort()
    resultArr.forEach {
        println(it)
    }
}
fun dfs(
    arr: ArrayList<List<Int>>,
    checkedArr: Array<BooleanArray>,
    x: Int,
    y: Int,
    n: Int
): Int {
    checkedArr[x][y] = true
    var count = 1
    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]
        if (nx in 0 until n && ny in 0 until n && !checkedArr[nx][ny] && arr[nx][ny] == 1) {
            count += dfs(arr, checkedArr, nx, ny, n)
        }
    }
    return count
}
/*
0,1
1,1
2,2
1,2
 */
