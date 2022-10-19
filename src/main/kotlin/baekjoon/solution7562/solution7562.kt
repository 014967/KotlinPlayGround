package baekjoon.solution7562

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

val dx = listOf(-2, -2, -1, -1, 1, 1, 2, 2)
val dy = listOf(1, -1, 2, -2, 2, -2, 1, -1)
data class Vertex(
    val x: Int,
    val y: Int
)
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val testCaseCount = readLine().toInt()
    for (i in 1..testCaseCount) {
        val length = readLine().toInt()
        val arr = Array(length) { Array<Int>(length) { 0 } } // 각 칸이 0, length -1로 주어짐
        val check = Array(length) { Array(length) { false } }
        val current = readLine().split(" ").map { it.toInt() }
        val currentX = current[0]
        val currentY = current[1]

        val target = readLine().split(" ").map { it.toInt() }
        val targetX = target[0]
        val targetY = target[1]
        bfs(Vertex(currentX, currentY), Vertex(targetX, targetY), check, arr)
    }
}

private fun bfs(currentVertex: Vertex, targetVertex: Vertex, check: Array<Array<Boolean>>, arr: Array<Array<Int>>) {
    var queue = LinkedList<Vertex>()
    val tempQueue = LinkedList<Vertex>()
    queue.offer(currentVertex)
    var count = 0
    while (queue.isNotEmpty()) {
        val current = queue.poll()
        if (current == targetVertex) {
            println(count)
            break
        }
        for (k in 0 until 8) {
            val x = current.x + dx[k]
            val y = current.y + dy[k]
            if (x in arr.indices && y in arr[x].indices && !check[x][y]) {
                check[x][y] = true
                tempQueue.offer(Vertex(x, y))
            }
        }
        if (queue.isEmpty()) {
            queue = LinkedList(tempQueue)
            tempQueue.clear()
            count++
        }
    }
}
