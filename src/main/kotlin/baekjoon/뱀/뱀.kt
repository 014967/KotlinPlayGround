package baekjoon.뱀

import baekjoon.solution11724.queue
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.HashMap

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

data class CurrentDirection(
    val dx: Int,
    val dy: Int
)
data class CurrentVertex(
    val x: Int,
    val y: Int
)
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()
    val K = readLine().toInt()

    var result = 0
    val board = Array(N + 1) { Array(N + 1) { 0 } }
    for (i in 1..K) {
        val (row, column) = readLine().split(" ").map { it.toInt() }
        board[row][column] = 1
    }

    val L = readLine().toInt()

    val timeMap = HashMap<Int, String>()

    for (i in 1..L) {
        val (x, c) = readLine().split(" ")

        val X = x.toInt() // 시간초
        val C = c
        timeMap[X] = C
    }

    val check = Array(N + 1) { Array(N + 1) { false } }

    var currentVertex = CurrentVertex(1, 1)
    var currentDirection = CurrentDirection(0, 1)

    val path = LinkedHashMap<CurrentVertex, Int>()
    val queue = LinkedList<CurrentVertex>()

    while (true) {
        val x = currentVertex.x
        val y = currentVertex.y

        if (x !in 1..N || y !in 1..N) {
            break
        }
        if (!check[x][y]) {
            check[x][y] = true
        } else {
            break
        }

        if (path.containsKey(currentVertex)) {
            break
        } else {
            path[currentVertex] = 1
            queue.offer(currentVertex)
        }

        if (board[x][y] == 1) {
            board[x][y] = 0
        } else {
            // 꼬리비우기
            if (result != 0) {
                val first = queue.peekFirst()
                check[first.x][first.y] = false
                path.remove(queue.pollFirst())
            }
        }

        if (timeMap.containsKey(result)) {
            // 방향 변환이 있는가?
            val type = timeMap[result]!!
            if (type == "D") {
                // 오른쪽으로 90도
                currentDirection = rotateRight(currentDirection)
            } else {
                currentDirection = rotateLeft(currentDirection)
            }
        }

        // 이동
        currentVertex = currentVertex.copy(
            currentVertex.x + currentDirection.dx,
            currentVertex.y + currentDirection.dy
        )
        result++
    }
    println(result)
}

fun rotateRight(currentDirection: CurrentDirection): CurrentDirection {
    val dx = currentDirection.dx
    val dy = currentDirection.dy

    return if (dx == 0 && dy == 1) {
        CurrentDirection(1, 0)
    } else if (dx == 1 && dy == 0) {
        CurrentDirection(0, -1)
    } else if (dx == 0 && dy == -1) {
        CurrentDirection(-1, 0)
    } else {
        CurrentDirection(0, 1)
    }
}
fun rotateLeft(currentDirection: CurrentDirection): CurrentDirection {
    val dx = currentDirection.dx
    val dy = currentDirection.dy
    return if (dx == 0 && dy == 1) {
        CurrentDirection(-1, 0)
    } else if (dx == -1 && dy == 0) {
        CurrentDirection(0, -1)
    } else if (dx == 0 && dy == -1) {
        CurrentDirection(1, 0)
    } else {
        CurrentDirection(0, 1)
    }
}

//        val nextX = x + currentDirection.dx
//        val nextY = x + currentDirection.dy
//        result++
//
//        if (board[nextX][nextY] == 1) {
//            // 사과가 존재한다면
//            board[nextX][nextY] = 0
//            check[nextX][nextY] = true
//        }
