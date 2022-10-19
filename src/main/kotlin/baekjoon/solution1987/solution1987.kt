package baekjoon.solution1987

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

var count = 0
val dx = intArrayOf(0, 0, 1, -1)
val dy = intArrayOf(1, -1, 0, 0)
var result = Integer.MIN_VALUE
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val line = readLine().split(" ").map {
        it.toInt()
    }
    val row = line[0]
    val column = line[1]
    val arr = Array(row) { Array(column) { ' ' } }

    for (i in 0 until row) {
        val input = readLine()
        for (j in input.indices) {
            arr[i][j] = input[j]
        }
    }
    val checkedAlpha = BooleanArray(27) { false }
    dfs(arr, checkedAlpha, 0, 0)
    println(result)
}

fun getIndex(alpha: Char): Int {
    when (alpha) {
        'A' -> return 0
        'B' -> return 1
        'C' -> return 2
        'D' -> return 3
        'E' -> return 4
        'F' -> return 5
        'G' -> return 6
        'H' -> return 7
        'I' -> return 8
        'J' -> return 9
        'K' -> return 10
        'L' -> return 11
        'M' -> return 12
        'N' -> return 13
        'O' -> return 14
        'P' -> return 15
        'Q' -> return 16
        'R' -> return 17
        'S' -> return 18
        'T' -> return 19
        'U' -> return 20
        'V' -> return 21
        'W' -> return 22
        'X' -> return 23
        'Y' -> return 24
        'Z' -> return 25
        else -> return 26
    }
}

private fun dfs(arr: Array<Array<Char>>, checkAlphabet: BooleanArray, i: Int, j: Int) {
    val checkedIndex = getIndex(arr[0][0])
    checkAlphabet[checkedIndex] = true
    count++
    for (k in 0..3) {
        val x = i + dx[k]
        val y = j + dy[k]
        if (x in arr.indices && y in arr[0].indices) {
            val index = getIndex(arr[x][y])
            if (!checkAlphabet[index]) {
                checkAlphabet[getIndex(arr[x][y])] = true
                dfs(arr, checkAlphabet, x, y)
                checkAlphabet[getIndex(arr[x][y])] = false
                count--
            }
        }
        result = result.coerceAtLeast(count)
    }
}
