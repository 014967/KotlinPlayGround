package baekjoon.전깃줄

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

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

fun main(): Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()

    val arr = Array(n) { Array(2) { 0 } }

    for (i in 0 until n) {
        val (left, right) = readLine().split(" ").map { it.toInt() }
        arr[i][0] = left
        arr[i][1] = right
    }
    val dp = Array(n){1}

    arr.sortWith(comparator = Comparator { o1, o2 -> o1[0] - o2[0] })
    for (i in arr.indices) {
        for (j in 0 until i) {
            val current = arr[i][1]
            val before = arr[j][1]
            if(current> before){
                dp[i] = max(dp[i], dp[j]+1)
            }
        }
    }
    println(n - dp.maxOfOrNull { it }!!)
    // 전체 전깃줄에서 설치할 수 있는 전깃줄의 최대를 빼면 제거해야하는 전깃줄
}
/*
서로 전깃줄이 교차하지 않게 하기 위해서는, 연속적으로 증가하는 숫자가 필요
가장 긴 증가하는 부분 수열의 길이가 최대로 겨겹치지 않고 연결할 수 있는 전 깃줄


 */
