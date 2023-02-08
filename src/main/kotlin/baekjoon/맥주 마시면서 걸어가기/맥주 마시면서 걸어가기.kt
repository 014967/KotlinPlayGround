package baekjoon.`맥주 마시면서 걸어가기`

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList
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
    val y: Int
)

var cu = 0
lateinit var vertexList: ArrayList<Vertex>
lateinit var graph: ArrayList<MutableSet<Int>>
lateinit var check: BooleanArray
var beerCount = 20

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val t = readLine().toInt()
    require(t <= 50)
    for (i in 1..t) {
        cu = readLine().toInt()
        vertexList = ArrayList<Vertex>()

        graph = ArrayList<MutableSet<Int>>()
        check = BooleanArray(cu + 2) { false }

        for (j in 1..cu + 2) {
            val (x, y) = readLine().split(" ").map { it.toInt() }
            vertexList.add(Vertex(x, y))
            graph.add(mutableSetOf())
        }

        for (j in 0 until cu + 2) {
            val currentVertex = vertexList[j]
            for (k in 0 until cu + 2) {
                if (j == k) {
                    continue
                } else {
                    val targetVertex = vertexList[k]
                    if (distance(currentVertex, targetVertex) <= 1000) { // 맥주 20병으로 갈 수 있는 곳
                        graph[j].add(k)
                        graph[k].add(j)
                    }
                }
            }
        }

        val queue = LinkedList<Int>()
        queue.offer(0)
        check[0] = true
        while (queue.isNotEmpty()) {
            val currentIndex = queue.poll()
            for (targetIndex in graph[currentIndex]) {
                if (check[targetIndex]) continue
                check[targetIndex] = true
                queue.offer(targetIndex)
            }
        }
        if (check[cu + 1]) {
            println("happy")
        } else {
            println("sad")
        }
    }
}
fun distance(startVertex: Vertex, targetVertex: Vertex): Int {
    return abs(startVertex.x - targetVertex.x) + abs(startVertex.y - targetVertex.y)
}

/*
출발 상근이네에서 맥주 한박스 출발
맥주는 20개가 들어있음

50 미터에 한병씩 마심
50 미터를 가려면 그전에 맥주 1병을 마셔야한다

편의점에 들렸을떄, 빈병은 버리고 새 맥주 병을 살 수 있다.
박스 안에 맥주는 20병을 넘길수 없다.
편의점을 나선 직후에도 50미터를 가기전에 맥주 한병을 마셔야한다.
 */
