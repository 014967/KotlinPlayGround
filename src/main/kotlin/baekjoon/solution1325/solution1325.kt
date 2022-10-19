package baekjoon.solution1325 // ktlint-disable filename

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

const val MAX_N = 10000
const val MAX_M = 100000
var max = Integer.MIN_VALUE
lateinit var dp: IntArray
fun main(): Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    val str = readLine().split(" ").map { it.toInt() }
    val n = str[0]
    val m = str[1]
    require(n in 1..MAX_N)
    require(m in 1..MAX_M)
    dp = IntArray(n + 1) { 0 }
    val graph = Array<ArrayList<Int>>(n + 1) { arrayListOf() }
    for (i in 0 until m) {
        val input = readLine().split(" ").map { it.toInt() }
        val a = input[0]
        val b = input[1]
        graph[a].add(b)
    }
    for (i in 1..n) {
        val check = Array(n + 1) { false }
        dfs(graph, check, start = i)
    }
    for (i in dp) {
        max = max.coerceAtLeast(i)
    }
    val result = StringBuilder()
    dp.forEachIndexed { index, i ->
        if (i == max) {
            result.append("$index ")
        }
    }
    println(result.dropLast(1))
}

fun dfs(arr: Array<ArrayList<Int>>, check: Array<Boolean>, start: Int) {
    check[start] = true

    for (i in arr[start]) {
        if (!check[i]) {
            dp[i]++
            dfs(arr, check, i)
        }
    }
}
/*
회사는 N개의 컴퓨터로 이루어져 있다.
한 번의 해킹으로 여러개의 컴퓨터를 해킹할 수있는 컴퓨터를 해킹하려고한다.

이 회사의 컴퓨터는 신뢰하는 관계와, 신뢰하지않은 관계로 이루어져있는데, A가 B를 신뢰하는 겨웅에는 B를 해킹하면,
A를 해킹할 수 있다.
한번에 가장 많은 컴퓨터를 해킹할 수 있는 컴퓨터의 번호를 출력해라.
 */
