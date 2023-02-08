package baekjoon.LCS2

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
    val line1 = readLine().toString()
    val line2 = readLine().toString()

    val dpTable = Array(line1.length + 1) { Array(line2.length + 1) { 0 } }

    for (i in 1 until dpTable.size) {
        for (j in 1 until dpTable[i].size) {
            if (line1[i - 1] == line2[j - 1]) {
                // 같다면 왼쪽 대각 + 1
                dpTable[i][j] = dpTable[i - 1][j - 1] + 1
            } else {
//                안같다면 왼쪽위와 왼쪽중에 더 큰거
                dpTable[i][j] = if (dpTable[i - 1][j] > dpTable[i][j - 1]) {
                    dpTable[i - 1][j]
                } else {
                    dpTable[i][j - 1]
                }
            }
        }
    }

    var result = dpTable[line1.length][line2.length]
    println(result)

    dpTable.forEach { arr ->
        println(arr.joinToString { it.toString() })
    }
    var str = StringBuilder()
    var x = dpTable.size - 1
    var y = dpTable[0].size - 1
    while (x != 0 && y != 0) {
        if (line1[x - 1] == line2[y - 1]) {
            // 글자가 같다면
            str.append(line1[x - 1])
            x -= 1
            y -= 1
        } else {
            // 글자가 다르다면
            // dpTable왼쪽
            if (dpTable[x][y - 1] == dpTable[x][y]) {
                y -= 1
            }
            if (dpTable[x - 1][y] == dpTable[x][y]) {
                x -= 1
            }
        }
    }
    println(str.toString().reversed())
}
