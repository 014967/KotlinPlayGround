package baekjoon.파도반수열

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
    val t = readLine().toInt()
    val pN = Array(101) { 0L }
    pN.apply {
        this[1] = 1
        this[2] = 1
        this[3] = 1
        this[4] = 2
        this[5] = 2
        this[6] = 3
        this[7] = 4
        this[8] = 5
        this[9] = 7
        this[10] = 9
    }
    val arr = arrayListOf<Int>()
    for (i in 1..t) {
        val n = readLine().toInt()
        arr.add(n)
    }
    for (i in arr) {
        if (i >= 10) {
            for (j in 10..i) {
                pN[j] = pN[j - 1] + pN[j - 5]
            }
            println(pN[i])
        } else {
            println(pN[i])
        }
    }
}

/*


 */
