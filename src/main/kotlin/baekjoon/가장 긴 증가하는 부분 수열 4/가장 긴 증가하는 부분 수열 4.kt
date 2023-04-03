package baekjoon.`가장 긴 증가하는 부분 수열 4`

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

data class Value(
    val n: Int,
    val seq: ArrayList<Int>
)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val list = readLine().split(" ").map { it.toInt() }
    val dp = Array(n) { Value(0, arrayListOf()) }

    for (i in 0 until n) {
        dp[i] = dp[i].copy(n = 1, seq = arrayListOf(list[i]))

        for (j in 0 until i) { // LIS 알고리즘 사용할때
            if (list[j] < list[i]) {
                // 기존 값보다 새로 들어오는 값이 클 때
                val newN = maxOf(dp[i].n, dp[j].n + 1)
                val newList = dp[j].seq.toMutableList().apply {
                    add(list[i])
                }
                if (dp[i].seq.size < newList.size) {
                    dp[i] = dp[i].copy(newN, newList as ArrayList<Int>)
                }
            }
        }
    }
    val max = dp.maxOf { it.n }
    println(max)
    for (i in dp) {
        if (i.n == max) {
            println(i.seq.joinToString(" ") { it.toString() })
            break
        }
    }
}
/*
3
2 4 1
 */