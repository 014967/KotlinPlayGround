package baekjoon.`소가 길을 건너간 이유6`

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

data class Cow(
    val x: Int,
    val y: Int
)

lateinit var visit: Array<Array<Array<BooleanArray>>>
lateinit var check: Array<BooleanArray>
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, K, R) = readLine().split(" ").map { it.toInt() }

    visit = Array(N + 1) {
        Array(N + 1) {
            Array(N + 1) {
                BooleanArray(N + 1) { false }
            }
        }
    }
    for (i in 0 until R) {
        val (r, c, r_, c_) = readLine().split(" ").map { it.toInt() }
        visit[r][c][r_][c_] = true
        visit[r_][c_][r][c] = true
        // 미리 다리를 방문처리해서 건너지 않도록 함.
    }

    val cowArray = Array<Cow>(K) { Cow(0, 0) }
    for (i in 0 until K) {
        // 소는 k마리 만큼 있음
        val (cowR, cowC) = readLine().split(" ").map { it.toInt() }
        cowArray[i] = Cow(cowR, cowC)
    }

    var result = 0
    for (i in 0 until K) {
        check = Array(N + 1) { BooleanArray(N + 1) { false } }
        bfs(cowArray[i].x, cowArray[i].y, N)
        for (j in i + 1 until K) {
            if (!check[cowArray[j].x][cowArray[j].y]) {
                result++
            }
        }
    }
    println(result)
}

val dx = listOf(0, 0, -1, 1)
val dy = listOf(1, -1, 0, 0)
fun bfs(x: Int, y: Int, N: Int) {
    val queue = LinkedList<Cow>()
    queue.add(Cow(x, y))
    check[x][y] = true
    while (queue.isNotEmpty()) {
        val current = queue.poll()
        for (i in 0 until 4) {
            val nextX = current.x + dx[i]
            val nextY = current.y + dy[i]
            if (nextX !in 1..N || nextY !in 1..N) {
                continue
            }
            if (visit[current.x][current.y][nextX][nextY] || check[nextX][nextY]) {
                continue
            }
            check[nextX][nextY] = true
            queue.offer(Cow(nextX, nextY))
        }
    }
}
/*

길을 건너지 않으면 만날 수 없는 소?
-> 다리를 이용하지 않고 다른 소들을 방문할 수 있는가?
-> 자신을 제외한 소들이 방문이 되지 않았다면 count를 증가
 */
