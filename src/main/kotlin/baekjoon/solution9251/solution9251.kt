package baekjoon.solution9251

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
    val str1 = readLine().toString()
    val str2 = readLine().toString()


    val totalArr = Array(str1.length + 1) { Array(str2.length + 1) { 0 } }

    for (i in str1.indices) {
        for (j in str2.indices) {
            if (str1[i] == str2[j]) {
                totalArr[i + 1][j + 1] = totalArr[i][j] + 1
            } else {
                totalArr[i + 1][j + 1] = maxOf(totalArr[i][j + 1], totalArr[i + 1][j])
            }
        }
    }
    println(totalArr[str1.length][str2.length])
}
