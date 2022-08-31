package baekjoon.solution9237

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
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

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val arr = Array(n) { 0 }
    readLine().split(" ").mapIndexed { index, tree ->
        arr[index] = tree.toInt()
    }

    var maxDay = 0 // 첫날
    Arrays.sort(arr, reverseOrder<Int>())
    for (i in arr.indices) {
        maxDay = max(maxDay, i + arr[i] + 1) // 하루에 하나씩 심은, i 날짜, 다자라는 시간 , 심은 다음날부터 자람
    }

    println(maxDay + 1)
}

