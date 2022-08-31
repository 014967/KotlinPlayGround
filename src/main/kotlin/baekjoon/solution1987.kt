package baekjoon

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

val dx = intArrayOf(0, 0, 1, -1)
val dy = intArrayOf(1, -1, 0, 0)
var result = Integer.MIN_VALUE
var count = 0
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val str = readLine().split(" ")
    val r = str[0].toInt()
    val c = str[1].toInt()

    val arr = Array(r) { Array(c) { ' ' } }
    for (i in 0 until r) {
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

fun dfs(arr: Array<Array<Char>>, checkedAlpha: BooleanArray, i: Int, j: Int) {

    val checkedIndex = getIndex(arr[0][0])
    checkedAlpha[checkedIndex] = true
    count++
    for (k in 0..3) {
        val x = i + dx[k]
        val y = j + dy[k]
        if (x in arr.indices && y in arr[0].indices) {
            val index = getIndex(arr[x][y])
            if (!checkedAlpha[index]) {
                checkedAlpha[getIndex(arr[x][y])] = true
                dfs(arr, checkedAlpha, x, y)
                checkedAlpha[getIndex(arr[x][y])] = false
                count--
            }
        }
        if (k == 3)
            result = result.coerceAtLeast(count)
    }
}
