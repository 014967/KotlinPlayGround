package baekjoon.solution16234

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

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
val dx = listOf(-1, 1, 0, 0)
val dy = listOf(0, 0, 1, -1)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val str = readLine().split(" ").map { it.toInt() }
    val n = str[0]
    val l = str[1]
    val r = str[2]

    val arr = Array(n) { Array(n) { 0 } }

    for (i in 0 until n) {
        val line = readLine().split(" ").map {
            it.toInt()
        }
        for (j in line.indices) {
            arr[i][j] = line[j]
        }
    }

    var count = 0

    while (true) { // 계속 돌림
        val check = Array(n) { Array(n) { false } }
        var flag2 = false
        for (i in arr.indices) {
            for (j in arr[i].indices) {
                if (!check[i][j]) {
                    val vertexList = arrayListOf<Pair<Int, Int>>()
                    dfs(i, j, arr, check, l, r, vertexList)
                    if (vertexList.size > 1) {
                        move(vertexList, arr)
                        flag2 = true // 이동할게 있다
                    }
                }
            }
        }
        if (!flag2) {
            println(count)
            break
        }
        count++
    }
}

private fun move(vertexList: ArrayList<Pair<Int, Int>>, arr: Array<Array<Int>>) {
    var total = 0
    vertexList.forEach {
        total += arr[it.first][it.second]
    }
    vertexList.forEach {
        arr[it.first][it.second] = (total / vertexList.size)
    }
}
private fun dfs(i: Int, j: Int, arr: Array<Array<Int>>, check: Array<Array<Boolean>>, l: Int, r: Int, vertexList: ArrayList<Pair<Int, Int>>) {

    check[i][j] = true
    vertexList.add(Pair(i, j)) // 무조건 1개가 들어가기 때문에
    for (k in 0 until 4) {
        val x = i + dx[k]
        val y = j + dy[k]
        if (x in arr.indices && y in arr.indices && !check[x][y]) {
            if (kotlin.math.abs(arr[i][j] - arr[x][y]) in l..r) {
                dfs(x, y, arr, check, l, r, vertexList)
            }
        }
    }
}
