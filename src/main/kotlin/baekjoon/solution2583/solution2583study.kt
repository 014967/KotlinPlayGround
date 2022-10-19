package baekjoon.solution2583

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

private val kx = listOf(-1, 1, 0, 0)
private val ky = listOf(0, 0, -1, 1)
var size = 0
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val input = readLine().split(" ").map { it.toInt() }
    val M = input[0] // 5
    val N = input[1] // 7
    val K = input[2]

    val arr = Array(M) { Array(N) { 0 } }
    var check = Array(M) { BooleanArray(N) { false } }
    var count = 1

    for (i in 1..K) {
        val line = readLine().split(" ").map { it.toInt() }

        val topX = line[1]
        val topY = line[0]

        val bottomX = line[3] - 1
        val bottomY = line[2] - 1

        for (q in topX..bottomX) {
            for (w in topY..bottomY) {
                arr[q][w] = 1
            }
        }
    }

    var list = mutableListOf<Int>()
    for (i in arr.indices) {
        for (j in arr[i].indices) {
            if (!check[i][j] && arr[i][j] == 0) {
                dfs(arr, check, i, j)
                list.add(size)
                size = 0
            }
        }
    }

    list.sort()
    println(list.size)
    list.forEachIndexed { index, i ->
        if (index != list.size - 1) print("${list[index]} ") else {
            println("${list[index]}")
        }
    }
}

private fun dfs(
    arr: Array<Array<Int>>,
    check: Array<BooleanArray>,
    i: Int,
    j: Int
) {
    check[i][j] = true
    size++

    for (k in 0..3) {
        val x = i + kx[k]
        val y = j + ky[k]
        if (x in arr.indices && y in arr[0].indices && !check[x][y] && arr[x][y] == 0) {
            dfs(arr, check, x, y)
        }
    }
}
