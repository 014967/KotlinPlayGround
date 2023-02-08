package baekjoon.`뱀과 사다리 게임`

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
data class Vertex(
    val x: Int,
    val y: Int
)

lateinit var arr: Array<Array<Int>>
lateinit var map: HashMap<Int, Int>
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M) = readLine().split(" ").map { it.toInt() }
    arr = Array(11) { i -> Array(11) { (i * 10) - 10 + it } }
    val ladderList = arrayListOf<Vertex>()
    val snakeList = arrayListOf<Vertex>()
    map = HashMap<Int, Int>()
    for (i in 0 until N) {
        val (x, y) = readLine().split(" ").map { it.toInt() }
        val vertex = Vertex(x, y)
        ladderList.add(vertex)
        map[x] = y
    }
    for (i in 0 until M) {
        val (x, y) = readLine().split(" ").map { it.toInt() }
        val vertex = Vertex(x, y)
        snakeList.add(vertex)
        map[x] = y
    }
    bfs(Vertex(1, 1))
}
fun bfs(vertex: Vertex) {
    val queue = LinkedList<Vertex>()
    queue.offer(vertex)
    val dp = Array(arr.size) { IntArray(arr[0].size) { 101 } }
    dp[1][1] = 0 // dp 주사위 굴리는 count
    while (queue.isNotEmpty()) {
        val currentVertex = queue.poll()
        var currentX = currentVertex.x
        var currentY = currentVertex.y

        var currentNumber = if (currentVertex.x == 1) {
            currentVertex.y
        } else {
            (currentVertex.x - 1) * 10 + currentVertex.y
        }
        if (map.containsKey(currentNumber)) {
            val moveNumber = map[currentNumber]!!
            val moveNumberList = moveNumber.toString().toList()
            if (moveNumberList.size == 2) {
                val tenValue = Character.getNumericValue(moveNumberList[0])
                val oneValue = Character.getNumericValue(moveNumberList[1])

                if (oneValue == 0) { // if 10
                    if (dp[tenValue][10] > dp[currentX][currentY]) {
                        // 이동후 dp 초기화
                        dp[tenValue][10] = dp[currentX][currentY]
                    }
                    currentX = tenValue
                    currentY = 10
                } else {
                    if (dp[tenValue + 1][oneValue] > dp[currentX][currentY]) {
                        // 이동후 dp 초기화
                        dp[tenValue + 1][oneValue] = dp[currentX][currentY]
                    }
                    currentX = tenValue + 1
                    currentY = oneValue
                }
            } else {
                currentX = 1
                currentY = Character.getNumericValue(moveNumberList[0])
            }
            currentNumber = moveNumber
        }
        for (i in 1..6) {
            // 6까지 이동한다.
            var nextX = 1
            var nextY = 1
            val nextNumber = currentNumber + i
            val nextNumberList = nextNumber.toString().toList()
            if (nextNumberList.size == 2) {
                if (Character.getNumericValue(nextNumberList[1]) == 0) {
                    nextX = currentX
                    nextY = 10
                } else {
                    nextX = Character.getNumericValue(nextNumberList[0]) + 1
                    nextY = Character.getNumericValue(nextNumberList[1])
                }
            } else if (nextNumberList.size == 3) {
                // 100일때
                nextX = 10
                nextY = 10
            } else {
                nextY = Character.getNumericValue(nextNumberList[0])
            }
            /*
            좌표 계산
             */
            if (nextX in 1 until arr.size && nextY in 1 until arr[nextX].size && dp[currentX][currentY] + 1 < dp[nextX][nextY]
            ) {
                queue.offer(Vertex(nextX, nextY))
                dp[nextX][nextY] = dp[currentX][currentY] + 1
            }
        }
    }
    println(dp[arr.size - 1][arr[0].size - 1])
}

/*
최단 거리로 가야하니까 bfs로 한다.
 */
