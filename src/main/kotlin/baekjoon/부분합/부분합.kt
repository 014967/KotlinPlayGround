package baekjoon.부분합

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
    val (N, S) = readLine().split(" ").map { it.toInt() }
    val n = readLine().split(" ").map { it.toInt() }
    val sumTable = IntArray(N) { 0 }
    sumTable[0] = n[0]
    for (i in 1 until sumTable.size) {
        sumTable[i] = sumTable[i - 1] + n[i]
    }

    var result = Integer.MAX_VALUE

    var leftIndex = 0
    var rightIndex = 0 // rightIndex LEFTiNDEX  -> leftIndex + 1
    while (leftIndex <= rightIndex) {
        if (rightIndex >= sumTable.size) {
            break
        }
        val sum = partialSum(sumTable, leftIndex, rightIndex)
        if (sum >= S) {
            // s이상이 됐다
            result = result.coerceAtMost(rightIndex - leftIndex + 1) // min
            leftIndex++
        } else {
            rightIndex++
        }
    }
    if (result == Integer.MAX_VALUE) {
        println(0)
    } else {
        println(result)
    }
}

fun partialSum(sumTable: IntArray, start: Int, end: Int): Int {
    return if (start == 0 && end == 0) {
        sumTable[start]
    } else if (start == 0 && end != 0) {
        sumTable[end]
    } else {
        sumTable[end] - sumTable[start - 1]
    }
}
/*
10000이하 자연수로 이루어진 길이 N짜리 수열이 주어진다.
연속된 수둘의 부분합 중에 그 합이 s이상이 된느 것중 가장 짧은 것의 길이를 구해라.

1차원 배열이 있고, 이 배열에서 각자 다른 원소를 가리키고 있는 2개의 포인터를 조작해가며 원하는 것을 얻는 형태

 */
