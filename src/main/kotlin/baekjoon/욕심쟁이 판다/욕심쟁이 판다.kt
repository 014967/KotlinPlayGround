package baekjoon.`욕심쟁이 판다`

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

data class Vertex(
    val x: Int,
    val y: Int
)
lateinit var forest: Array<Array<Int>>
lateinit var dp: Array<Array<Int>>
var answer = 0
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    forest = Array(n) { Array(n) { 0 } }
    dp = Array(n) { Array(n) { 0 } }
    for (i in 0 until n) {
        val line = readLine().split(" ").map { it.toInt() }
        for (j in line.indices) {
            forest[i][j] = line[j]
        }
    }
    for (i in forest.indices) {
        for (j in forest[i].indices) {
            answer = answer.coerceAtLeast(dfs(Vertex(i, j)))
        }
    }
    println(answer)
}

val dx = listOf(0, 0, -1, 1)
val dy = listOf(1, -1, 0, 0)
fun dfs(vertex: Vertex): Int {
    val x = vertex.x
    val y = vertex.y
    val currentBamBoo = forest[x][y]

    // 이게 중요함
    if (dp[x][y] != 0) {
        return dp[x][y]
    }
    dp[x][y] = 1

    for (i in 0..3) {
        val nextX = x + dx[i]
        val nextY = y + dy[i]
        if (nextX !in forest.indices) continue
        if (nextY !in forest[nextX].indices) continue
        val nextBamBoo = forest[nextX][nextY]
        if (nextBamBoo <= currentBamBoo) continue

        dp[x][y] = dp[x][y].coerceAtLeast(1 + dfs(Vertex(nextX, nextY)))
    }
    return dp[x][y]
}
/*
4
14 9 12 10
1 11 5 4
7 15 2 13
6 3 16 8

3
9 12 10
11 5 4
15 2 13
 */
