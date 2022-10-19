package baekjoon.solution13023

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
var flag = false
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val line = readLine().split(" ").map { it.toInt() }
    val n = line[0]
    val m = line[1]
    val arr = Array(n) { arrayListOf<Int>() }

    for (i in 1..m) {
        val str = readLine().split(" ").map { it.toInt() }
        val a = str[0]
        val b = str[1]
        arr[a].add(b)
        arr[b].add(a)
    }

    for (i in arr.indices) {
        flag = false
        val check = Array(n) { false }
        if (!check[i]) {
            var count = 1
            check[i] = true
            dfs(arr, check, i, count)
        }
        if (flag) {
            println(1)
            break
        }
    }
    if (!flag) {
        println(0)
    }
}

fun dfs(arr: Array<ArrayList<Int>>, check: Array<Boolean>, i: Int, count: Int) {

    if (count >= 5) {
        flag = true
        return
    } else {
        for (k in arr[i]) {
            if (!check[k]) {
                check[i] = true
                dfs(arr, check, k, count + 1)
                check[i] = false
            }
        }
    }
}
