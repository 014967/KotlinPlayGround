package baekjoon.solution1439

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
    val S = readLine().toString()

    var count = 0
    var countArr = arrayListOf<Int>()
    countArr.add(1)

    for (i in 1 until S.length) { // index
        if (S[i] != S[i - 1]) { // 이전의 요소와 다른 Char일 경우
            count++
            countArr.add(count, 1)
        } else {
            countArr[count] += 1
        }
    }
    var result = 0
    if (countArr.size != 1) {
        result = countArr.size / 2
    }

    println(result)
}
