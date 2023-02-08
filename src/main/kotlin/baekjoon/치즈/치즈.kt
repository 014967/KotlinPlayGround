package baekjoon.치즈

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
    val y: Int
)
lateinit var table: Array<Array<Int>>
lateinit var check: Array<Array<Boolean>>

val list = LinkedList<Vertex>()
var cheese = 0
var time = 0
var remainCheese = 0
var Row = 0
var Column = 0
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (row, col) = readLine().split(" ").map { it.toInt() }
    Row = row
    Column = col
    table = Array(row) { Array(col) { 0 } }
    check = Array(row) { Array(col) { false } }

    for (i in table.indices) {
        val rowList = readLine().split(" ").map { it.toInt() }
        for (j in rowList.indices) {
            table[i][j] = rowList[j]
            if (rowList[j] == 1) {
                cheese++
            }
        }
    }

    while (cheese > 0) {
        time++
        remainCheese = cheese
        bfs()
    }
    println(time)
    println(remainCheese)
}

val dx = listOf(0, 0, -1, 1)
val dy = listOf(1, -1, 0, 0)
fun bfs() {
    val queue = LinkedList<Vertex>()
    queue.offer(Vertex(0, 0))
    check = Array(Row) { Array(Column) { false } }
    while (queue.isNotEmpty()) {
        val currentVertex = queue.poll()
        val currentVertexX = currentVertex.x
        val currentVertexY = currentVertex.y
        check[currentVertexX][currentVertexY] = true
        for (i in 0..3) {
            val nextX = currentVertexX + dx[i]
            val nextY = currentVertexY + dy[i]
            if (
                nextX in table.indices && nextY in table[nextX].indices &&
                !check[nextX][nextY]
            ) {
                if (table[nextX][nextY] == 0) {
                    queue.offer(Vertex(nextX, nextY))
                } else {
                    // 0을 탐색하면서 주변에 치즈가 있는지 확인
                    // 1d일 경우
                    cheese -= 1
                    table[nextX][nextY] = 0
                }
                check[nextX][nextY] = true
            }
        }
    }
}

/*
input : 사각형 모양의 크기와 한 조각의 치즈가 판위에 주어짐.
치즈가 모두 녹아 없어지는데 걸리는 시간,
모두 녹기 한 시간 전에 남아있는 치즈 조각이 놓여있는 칸의 개수를 구해라.
 */
