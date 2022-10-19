package baekjoon.solution1967

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
    val n = readLine().toInt()
    val tree = Array(n + 1) { Array(n + 1) { 0 } }
    for (i in 1 until n) {
        val s = readLine().split(" ").map {
            it.toInt()
        }
//        tree[s[0]].add(s[1])
        tree[s[0]][s[1]] = s[2]
    }
    var max = Integer.MIN_VALUE

    for (k in 1..n) {
        for (i in 1..n) {
            val check = Array(n + 1) { Array(n + 1) { false } }

            if (tree[k][i] != 0 && !check[k][i]) {
                // 연결
                bfs(k, i, tree, check)
            }
            if (count > max) {
                max = count
                count = 0
            }
        }
    }
    println(max)
}

fun bfs(i: Int, j: Int, arr: Array<Array<Int>>, check: Array<Array<Boolean>>) {

    count += arr[i][j]
    check[i][j] = true
    for (x in arr[j].indices) {
        if (arr[j][x] != 0 && !check[j][x]) {
            bfs(j, x, arr, check)
        }
    }
}
