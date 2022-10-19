package baekjoon.solution7576

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

/**
 * @desc
 보관후 하루가 지나면, 익은 토마토의 인접한 토마토들의 영향을 받는다.
 위아래 왼쪽 오른쪽을 의미한다.
 대각선에는 영향을 주지 못하여 , 혼자저절로 익지는 않는다.
 토마토들이 며칠이 지나면 다 익는지,그 최소 일수를 알고 싶어한다.
 * @input
 상자의 크기를 나타내는 m, n ㅣ 주어진다. m이 가로, n이 세로
 2<= m , n <= 1000
 * @output
 *
 * @example
 *
 */

private val dx = listOf(1, -1, 0, 0)
private val dy = listOf(0, 0, 1, -1)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val str = readLine().split(" ").map {
        it.toInt()
    }
    val m = str[1] // 세로
    val n = str[0] // 가로
    // n * m
    val arr = Array(m) { Array(n) { 0 } }

    var queue = LinkedList<Pair<Int, Int>>()
    var canTomato = 0
    var checkTomato = 0

    for (i in 0 until m) {
        readLine().split(" ").mapIndexed { index, s ->
            arr[i][index] = s.toInt()
            if (arr[i][index] == 1) {
                queue.offer(Pair(i, index)) // 1인거를 queue에 넣는다.
            }
            if (arr[i][index] == 1 || arr[i][index] == 0) {
                // 익은 것이나 익을 수 잇는 토마토의 갯수를 센다
                canTomato++
            }
        }
    }

    val check = Array(m) { BooleanArray(n) { false } }
    var dayCount = 1

    val tempQueue = LinkedList<Pair<Int, Int>>()

    while (queue.isNotEmpty()) {
        val vertex = queue.poll() // x, y
        val i = vertex.first
        val j = vertex.second
        check[i][j] = true
        // 체크한 토마토 실제 내가 체크한 토마토
        checkTomato++

        for (k in 0..3) {
            val x = i + dx[k]
            val y = j + dy[k]
            if (x in arr.indices && y in arr[0].indices && arr[x][y] == 0 && !check[x][y]) {
                // tempQueue를 만들어서 0인 토마토를 넣는다.
                tempQueue.offer(Pair(x, y))
                check[x][y] = true
            }
        }
        if (queue.isEmpty()) {
            if (tempQueue.isEmpty()) {
                dayCount--
                break
            }
            dayCount++
            // temp 로 queue를 교체
            queue = LinkedList(tempQueue)
            tempQueue.clear()
        }
    }
    if (checkTomato == canTomato) {
        // -1로 막힌 토마토가 있다면 위의 실제 체크한 토마토와 canTomato의 갯수가 다르기 때문에 dayCount를 출력한다.
        println(dayCount)
    } else {
        println(-1)
    }
}
