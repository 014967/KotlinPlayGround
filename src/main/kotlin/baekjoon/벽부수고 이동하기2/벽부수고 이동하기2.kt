package baekjoon.`벽부수고 이동하기2`

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
    val distance: Int,
    val wall: Int

)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M, K) = readLine().split(" ").map { it.toInt() }
    val arr = Array(N) { Array(M) { 0 } }
    for (i in 0 until N) {
        val row = readLine().toString().toList().map {
            Character.getNumericValue(it)
        }
        for (j in row.indices) {
            arr[i][j] = row[j]
        }
    }
    if (N - 1 == 0 && M - 1 == 0) println(1)
    else println(bfs(arr, Vertex(0, 0, 0, 0), K))
}

val dx = listOf(0, 0, -1, 1)
val dy = listOf(1, -1, 0, 0)
fun bfs(arr: Array<Array<Int>>, vertex: Vertex, k: Int): Int {
    val queue = LinkedList<Vertex>()

    // 벽을 부순 횟수, 행 , 열
    val checked = Array(k + 1) { Array(arr.size) { BooleanArray(arr[0].size) } }

    var result = -1
    queue.offer(vertex)
    checked[0][0][0] = true

    while (queue.isNotEmpty()) {
        val currentVertex = queue.poll()
        val currentX = currentVertex.x
        val currentY = currentVertex.y
        val currentDistance = currentVertex.distance
        val currentWall = currentVertex.wall

        if (currentX == arr.size - 1 && currentY == arr[0].size - 1) {
            result = currentDistance + 1
            break
        }
        for (i in 0..3) {
            val nextX = currentX + dx[i]
            val nextY = currentY + dy[i]
            if (nextX !in arr.indices || nextY !in arr[0].indices) {
                continue
            }
            val nextWall = if (arr[nextX][nextY] == 1) currentWall + 1 else currentWall
            val nextDistance = currentDistance + 1
            if (nextWall <= k && !checked[nextWall][nextX][nextY]) {
                queue.offer(
                    Vertex(
                        x = nextX,
                        y = nextY,
                        distance = nextDistance,
                        wall = nextWall
                    )
                )
                checked[nextWall][nextX][nextY] = true
            }
        }
    }
    return result
}

/*
k번 이하로 벽을 부수면서 목적지에 도달하는 최단 거리는 가장 처음 목적지에 도착히는 탐색 루트의 distacne값이므로
메모이제이션이 필요없다.
 */
