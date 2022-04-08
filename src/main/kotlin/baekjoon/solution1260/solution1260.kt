package baekjoon.solution1260

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val NMV = readLine().split(" ").map {
        it.toInt()
    }
    val solution = Solution1260()
    val N = NMV[0]
    val M = NMV[1]
    val V = NMV[2]

    var nodeArr = Array<Array<Int>>(N + 1) { Array<Int>(N + 1) { 0 } }
    var checkArr = BooleanArray(N + 1) { false }
    for (i in 0 until M) {
        val nodes = readLine().split(" ").map { it.toInt() }
        val startNode = nodes[0]
        val endNode = nodes[1]
        nodeArr[startNode][endNode] = 1
        nodeArr[endNode][startNode] = 1
    }

    solution.dfs(nodeArr, V, checkArr)
    println()
    checkArr = BooleanArray(N + 1) { false }
    solution.bfs(nodeArr, V, checkArr)
}
class Solution1260 {

    fun dfs(nodeArr: Array<Array<Int>>, start: Int, checkArr: BooleanArray) {

        if (checkArr[start])
            return
        checkArr[start] = true
        print("$start ")

        for (i in nodeArr.indices) {
            for (j in nodeArr[i].indices) {
                if (i == start && nodeArr[i][j] == 1 && !checkArr[j]) {
                    dfs(nodeArr, j, checkArr)
                }
            }
        }
    }

    fun bfs(nodeArr: Array<Array<Int>>, start: Int, checkArr: BooleanArray) {
        val q = LinkedList<Int>()
        q.offer(start)
        checkArr[start] = true
        while (q.isNotEmpty()) {
            val x = q.peek()
            print("${q.poll()} ")
            for (i in nodeArr.indices) {
                for (j in nodeArr[i].indices) {
                    if (i == x && nodeArr[i][j] == 1 && !checkArr[j]) {
                        q.offer(j)
                        checkArr[j] = true
                    }
                }
            }
        }
    }
}
