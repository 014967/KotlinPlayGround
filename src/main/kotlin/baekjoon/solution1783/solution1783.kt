package baekjoon.solution1783

import java.io.BufferedReader
import java.io.InputStreamReader
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

val moving = listOf(
    Pair(1, 2), Pair(2, 1), Pair(2, -1), Pair(1, -2)
)
var movingCount = 0
var count = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val line = readLine().split(" ").map { it.toInt() }
    val n = line[0] // row
    val m = line[1] // column

    val check = Array<Boolean>(4) { false }
    var i = n - 1
    var j = 0
    val dp = Array(n) { Array(m) { false } }
}

fun dfs(dp: Array<Array<Boolean>>, check: Array<Boolean>, i: Int, j: Int): Int {
    if (movingCount == 4) {
        return count
    }

    for (k in 0..3) {
        val x = i + moving[k].first
        val y = j + moving[k].second

        if (x in dp.indices && y in dp[0].indices && !check[k]) {
            count++
            count = max(count, dfs(dp, check, x, y))
        }
    }
}
