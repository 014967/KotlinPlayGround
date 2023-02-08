package baekjoon.`치킨 배달`

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.abs

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

lateinit var array: Array<Array<Int>>
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M) = readLine().split(" ").map { it.toInt() }

    val chickenList = arrayListOf<Vertex>()
    val homeList = arrayListOf<Vertex>()
    array = Array(N + 1) { Array(N + 1) { 0 } }
    for (i in 1..N) {
        val row = readLine().split(" ").map { it.toInt() }
        for (j in row.indices) {
            if (row[j] == 2) {
                chickenList.add(Vertex(i, j + 1, 0))
            }
            if (row[j] == 1) {
                homeList.add(Vertex(i, j + 1, 0))
            }
            array[i][j + 1] = row[j]
        }
    }
    val check = Array(chickenList.size) { false }
    val combList = arrayListOf<List<Vertex>>()
    combination(combList, chickenList, check, 0, target = M)

    var result = Integer.MAX_VALUE
    for (i in combList) {
        var count = 0
        for (j in i) {
            for (k in homeList) {
                count += getDistance(j, k)
            }
        }
        result = result.coerceAtMost(count)
    }
    println(result)
}

fun<T> combination(answer: MutableList<List<T>>, el: List<T>, ck: Array<Boolean>, start: Int, target: Int) {
    if (target == 0) {
        answer.addAll(listOf(el.filterIndexed { index, t -> ck[index] }))
    } else {
        for (i in start until el.size) {
            ck[i] = true
            combination(answer, el, ck, i + 1, target - 1)
            ck[i] = false
        }
    }
}
val dx = listOf(-1, 1, 0, 0)
val dy = listOf(0, 0, -1, 1)
fun getDistance(chicken: Vertex, home: Vertex): Int {
    return abs(home.x - chicken.x) + abs(home.y - chicken.y)
}
fun bfs(vertex: Vertex): Int {
    val queue = LinkedList<Vertex>()
    queue.offer(vertex)
    var distance = Integer.MAX_VALUE
    val checked = Array(array.size) { BooleanArray(array.size) { false } }
    while (queue.isNotEmpty()) {
        val currentVertex = queue.poll()
        val currentVertexX = currentVertex.x
        val currentVertexY = currentVertex.y
        val currentDistance = currentVertex.distance

        checked[currentVertexX][currentVertexY] = true

        if (array[currentVertexX][currentVertexY] == 1) {
            // 모든 집에 대해서 구한다.
            distance = distance.coerceAtMost(currentDistance)
        }

        for (i in 0..3) {
            val nextVertexX = currentVertexX + dx[i]
            val nextVertexY = currentVertexY + dy[i]

            if (nextVertexX in 1 until array.size && nextVertexY in 1 until array.size && !checked[nextVertexX][nextVertexY]) {
                val nextDistance = abs(nextVertexX - vertex.x) + abs(nextVertexY - vertex.y)
                checked[nextVertexX][nextVertexY] = true
                queue.offer(Vertex(nextVertexX, nextVertexY, nextDistance))
            }
        }
    }
    return distance
}
/*
N * N 인도시에.
빈칸이거나, 치킨집, 집 중 하나입니다.
(1,1)에서 시작합니다.

치킨 거리는 집과 가장 가까운 치킨집 사이의 거리.
치킨 거리는 집을 기준으로 정해진다.

도시의 치킨 거리는 모든 집의 치킨 거리의 합이다.

각 치킨집 별로 모든 집에 대한 경로를 구한다. 그중 가장 가까운 거리를 구한다.
이 거리가 가장짧은 M개를 구한다. 이렇게 구하면안된다.

최대 M개?
 */
