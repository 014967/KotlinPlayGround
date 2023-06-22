package baekjoon.빵집

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

val dx = listOf(-1, 0, 1)
val dy = listOf(1, 1, 1)
var count = 0

lateinit var check: Array<Array<Boolean>>
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (r, c) = readLine().split(" ").map { it.toInt() }

    val table = Array(r) { Array(c) { ' ' } }
    for (i in 0 until r) {
        val line = readLine()
        for (j in line.indices) {
            table[i][j] = line[j]
        }
    }
    check = Array(r) { Array(c) { false } }

    for (i in 0 until r) {
        if (dfs(table, i, 0)) {
            count++
        }
    }
    println(count)
}

fun dfs(table: Array<Array<Char>>, x: Int, y: Int): Boolean {
    if (check[x][y]) {
        return false
    }
    check[x][y] = true

    if (y == table[0].size - 1) {
        return true
    }

    for (i in 0 until 3) {
        val nextX = x + dx[i]
        val nextY = y + dy[i]
        if (nextX in table.indices && nextY in table[nextX].indices && table[nextX][nextY] != 'x') {
            if (dfs(table, nextX, nextY)) {
                return true
            }
        }
    }

    return false
}
