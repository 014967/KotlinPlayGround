package baekjoon.solution14502

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

val dx = listOf(0, 0, 1, -1)
val dy = listOf(1, -1, 0, 0)
var safeArea = 0
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val str = readLine().split(" ").map { it.toInt() }
    val n = str[0] // 세로
    val m = str[1] // 가로

    val arr = Array(n) { Array<Int>(m) { 0 } }
    val queue = LinkedList<Pair<Int, Int>>()

    for (i in arr.indices) {
        readLine().split(" ").mapIndexed { index, s ->
            arr[i][index] = s.toInt()
            if (arr[i][index] == 2) {
                queue.add(Pair(i, index))
            }
        }
    }
    require(queue.size in 2..10)
    dfs(0, arr, queue)
    println(safeArea)
}

private fun dfs(count: Int, arr: Array<Array<Int>>, queue: LinkedList<Pair<Int, Int>>) {
    if (count == 3) {
        val testArr = Array(arr.size) { Array(arr[0].size) { 0 } }
        for (i in testArr.indices) {
            for (j in testArr[i].indices) {
                testArr[i][j] = arr[i][j]
            }
        }
        // 바이러스를 퍼트리는 부분
        for (i in queue) {
            val virus = i
            spreadVirus(virus, testArr)
        }
        getSafeArea(testArr)
        // 남은 영역 구하기
        return
    }
    for (i in arr.indices) {
        for (j in arr[i].indices) {
            if (arr[i][j] == 0) {
                arr[i][j] = 1 // 벽을 세운다.
                dfs(count + 1, arr, queue)
                arr[i][j] = 0 // 벽을 다시 지운다.
            }
        }
    }
}

private fun getSafeArea(arr: Array<Array<Int>>) {
    var count = 0
    for (i in arr.indices) {
        for (j in arr[i].indices) {
            if (arr[i][j] == 0) {
                count++
            }
        }
    }
    safeArea = safeArea.coerceAtLeast(count)
}

private fun spreadVirus(virus: Pair<Int, Int>, arr: Array<Array<Int>>) {

    val queue = LinkedList<Pair<Int, Int>>()
    queue.offer(virus)

    while (queue.isNotEmpty()) {
        if (queue.peek() != null) {
            val virusVertex = queue.poll()
            val virusX = virusVertex.first
            val virusY = virusVertex.second
            for (i in 0..3) {
                val x = virusX + dx[i]
                val y = virusY + dy[i]
                if (x in arr.indices && y in arr[0].indices && arr[x][y] == 0) {
                    arr[x][y] = 2
                    queue.offer(Pair(x, y))
                }
            }
        }
    }
}
/*
1. 안전지역에 모든 경우의 수로 벽을 3개 세운다 - 백트래킹 -
2. 벽 3개를 세운 후 바이러스를 퍼트린다.
3. 안전 구역의 최댓값을 구한다.

 */
