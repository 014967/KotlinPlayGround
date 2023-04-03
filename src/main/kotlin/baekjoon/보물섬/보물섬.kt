package baekjoon.보물섬

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

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
    val y: Int,
    val distance: Int
)

lateinit var checkArray: Array<Array<Boolean>>
lateinit var table: Array<Array<Char>>
var maxDistance = 0
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (R, C) = readLine().split(" ").map { it.toInt() }
    table = Array(R) { Array(C) { ' ' } }

    for (i in 0 until R) {
        readLine().forEachIndexed { index, c ->
            table[i][index] = c
        }
    }

    for (i in 0 until R) {
        for (j in 0 until C) {
            if (table[i][j] != 'W') {
                checkArray = Array(R) { Array(C) { false } }
                bfs(Vertex(i, j, 0))
            }
        }
    }

    println(maxDistance)
}

val dx = listOf(-1, 1, 0, 0)
val dy = listOf(0, 0, -1, 1)
fun bfs(
    startVertex: Vertex
) {
    val queue = LinkedList<Vertex>()
    queue.offer(startVertex)
    checkArray[startVertex.x][startVertex.y] = true

    while (queue.isNotEmpty()) {
        val currentVertex = queue.poll()
        for (i in 0..3) {
            val nextX = currentVertex.x + dx[i]
            val nextY = currentVertex.y + dy[i]
            val nextDistance = currentVertex.distance + 1
            if (nextX !in checkArray.indices || nextY !in checkArray[0].indices) {
                continue
            }
            if (!checkArray[nextX][nextY] && table[nextX][nextY] == 'L') {
                checkArray[nextX][nextY] = true
                queue.offer(Vertex(nextX, nextY, nextDistance))
                maxDistance = maxDistance.coerceAtLeast(nextDistance)
            }
        }
    }
}
/*
보물은 서로 간에 최단 거리로 이동하는데 있어 가장 긴 시간이 걸리는 육지 두곳에
묻혀있다.

각 육지마다 갈 수 있는 최단 거리중에 가장 큰 값을 더해야한다.
 */
