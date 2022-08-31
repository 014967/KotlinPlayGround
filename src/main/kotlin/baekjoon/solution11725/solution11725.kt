package baekjoon.solution11725

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

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val arr = Array(n + 1) { mutableListOf<Int>() }
    val parentArray = Array(n + 1) { 0 }
    for (i in 1 until n) {
        val input = readLine().split(" ")
        val root = input[0].toInt()
        val child = input[1].toInt()
        arr[root].add(child)
        arr[child].add(root)
    }

    dfs(arr, parentArray, 1)

    parentArray.forEachIndexed { index, i ->
        if (index >= 2) {
            println(i)
        }
    }
}
fun dfs(arr: Array<MutableList<Int>>, parentArray: Array<Int>, node: Int) {
    for (i in arr[node]) { //  자식들
        if (i == 1)
            continue
        else if (parentArray[i] == 0) {
            parentArray[i] = node
            dfs(arr, parentArray, i)
        }
    }
}
