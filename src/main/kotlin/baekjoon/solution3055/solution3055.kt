package baekjoon.solution3055

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
/*
물과 고슴도치는 돌을 통과할 수 없다
고슴도치는 물이있는곳으로 이동ㅁ소함
물도 비버의 소굴로 못가
물도 비어있는 칸으로 확장
고슴도치는 인접한 칸으로 이동가능

 */

val dx = listOf(0, 0, -1, 1)
val dy = listOf(1, -1, 0, 0)
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val input = readLine().split(" ").map { it.toInt() }
    val r = input[0]
    val c = input[1]
    val arr = Array(r) { Array(c) { ' ' } }
    val check = Array(r) { Array(c) { false } }

    var beaver = Pair<Int, Int>(0, 0)
    var water = LinkedList<Pair<Int, Int>>()
    var home = Pair<Int, Int>(0, 0)
    for (i in 0 until r) {
        val line = readLine()
        for (j in line.indices) {
            if (line[j] == 'S') {
                beaver = Pair(i, j)
            }
            if (line[j] == '*') {
                water.offer(Pair(i, j))
            }
            if (line[j] == 'D') {
                home = Pair(i, j)
            }
            arr[i][j] = line[j]
        }
    }

    bfs(beaver, water, home, arr)
}

fun bfs(beaver: Pair<Int, Int>, water: LinkedList<Pair<Int, Int>>, home: Pair<Int, Int>, arr: Array<Array<Char>>) {

    val beaverQueue = LinkedList<Pair<Int, Int>>()
    beaverQueue.offer(beaver)
    var count = 0

    while (beaverQueue.isNotEmpty()) {
        val waterSize = water.size
        for (i in 0 until waterSize) {

            val currentWater = water.poll()
            var currentWaterX = currentWater.first
            var currentWaterY = currentWater.second

            for (k in 0 until 4) {
                val x = currentWaterX + dx[k]
                val y = currentWaterY + dy[k]

                if (x in arr.indices && y in arr[0].indices && arr[x][y] == '.') {
                    water.offer(Pair(x, y))
                    arr[x][y] = '*'
                }
            }
        }

        val beaverSize = beaverQueue.size
        for (i in 0 until beaverSize) {
            val currentBe = beaverQueue.poll()
            val currentBeX = currentBe.first
            val currentBeY = currentBe.second

            for (k in 0 until 4) {
                val x = currentBeX + dx[k]
                val y = currentBeY + dy[k]
                if (x == home.first && y == home.second) {
                    count++
                    println(count)
                    return
                }
                if (x in arr.indices && y in arr[0].indices && arr[x][y] == '.') {
                    beaverQueue.offer(Pair(x, y))
                    arr[x][y] = 'S'
                }
            }
        }
        count++
    }
    println("KAKTUS")
    return
}
