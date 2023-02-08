package baekjoon.환승

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
var size: Int = 0
lateinit var table: Array<ArrayList<Int>>
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, K, M) = readLine().split(" ").map { it.toInt() }
    table = Array(101001) { arrayListOf<Int>() }
    size = table.size
    for (i in 1..M) {
        val infoHighperTube = readLine().split(" ").map { it.toInt() }
        val highperTubeNum = 100000 + i
        for (j in infoHighperTube) {
            table[highperTubeNum].add(j)
            table[j].add(highperTubeNum)
        }
    }

    println(bfs(N))
}

data class Vertex(
    val tubeNum: Int,
    val distance: Int
)

fun bfs(end: Int): Int {
    val queue = LinkedList<Vertex>()
    queue.offer(Vertex(1, 1))
    val check = BooleanArray(size) { false }
    check[1] = true
    var result = -1
    while (queue.isNotEmpty()) {
        val currentTube = queue.poll()
        val currentTubeNumber = currentTube.tubeNum
        val currentDistance = currentTube.distance
        check[currentTubeNumber] = true
        if (currentTubeNumber == end) {
            result = currentDistance
            break
        }

        for (i in table[currentTubeNumber]) {
            if (!check[i]) {
                check[i] = true
                if (i > 100000) {
                    // highper tube
                    queue.offer(Vertex(i, currentDistance))
                } else {
                    queue.offer(Vertex(i, currentDistance + 1))
                }
            }
        }
    }
    return result
}

/*
하이퍼튜브. 하이퍼튜브는 역 k개를 서로 연결한다
1번역에서 N번역으로 가는데 방문하는 최소 역의 수 .

https://cocoon1787.tistory.com/312
 */
