package baekjoon.solution2206

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

val dx = listOf(0, 0, -1, 1)
val dy = listOf(1, -1, 0, 0)
data class Vertex(
    val x: Int,
    val y: Int
)
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val line = readLine().split(" ").map { it.toInt() }
    val n = line[0]
    val m = line[1]
    val arr = Array(n + 1) { Array(m + 1) { -1 } }
    val check = Array(n + 1) { Array(m + 1) { false } }
    for (i in 1..n) {
        val row = readLine().toString()
        for (j in row.indices) {
            arr[i][j + 1] = Character.getNumericValue(row[j])
        }
    }
    println(arr)
}

fun bfs(arr: Array<Array<Int>>, check: Array<Array<Boolean>>) {
    val queue = LinkedList<Vertex>()
    queue.offer(Vertex(1, 1))
    while (queue.isNotEmpty()) {
        val current = queue.poll()
        for (i in 0 until 4) {
            val x = current.x + dx[i]
            val y = current.y + dy[i]

            if (x in arr.indices && y in arr[0].indices && !check[x][y]) {
                if (arr[x][y] == 1) {
                    arr[x][y] = 0
                    queue.offer(Vertex(x,y))

                } else if (arr[x][y] == 0) {
                }
            }
        }
    }
}
