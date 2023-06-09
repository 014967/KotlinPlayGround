package baekjoon.상자넣기

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

// LIS?
//

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val stream = readLine().split(" ").map { it.toInt() }

    val arr = Array<Int>(n) { Integer.MAX_VALUE }
    arr[0] = stream[0]

    /*
    nLogN   n * logN
     */
    for (index in 1 until n) {
        var leftIndex = 0
        var rightIndex = arr.size
        while (leftIndex < rightIndex) {
            val midIndex = (leftIndex + rightIndex) / 2
            if (arr[midIndex] < stream[index]) {
                leftIndex = midIndex + 1
            } else {
                rightIndex = midIndex
            }
        }
        arr[rightIndex] = stream[index]
    }

    println(arr.count { it != Integer.MAX_VALUE })
}
