package baekjoon.최단경로

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

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

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (V, E) = readLine().split(" ").map { it.toInt() }
    require(V in 1..20000)
    require(E in 1..300000)
    val nodeTable = Array(V + 1) { arrayListOf<Pair<Int, Int>>() }
    val start = readLine().toInt()
    for (i in 1..E) {
        val (u, v, w) = readLine().split(" ").map { it.toInt() }
        nodeTable[u].add(Pair(v, w))
    }
    search(start, nodeTable)
}

data class Node(
    val node: Int,
    val weight: Int
)
fun search(start: Int, nodeTable: Array<ArrayList<Pair<Int, Int>>>) {
    val dp = Array(nodeTable.size) { Integer.MAX_VALUE }
    val queue = PriorityQueue<Node> { n1, n2 -> n1.weight - n2.weight }
    queue.offer(Node(start, 0))
    dp[start] = 0
    while (queue.isNotEmpty()) {
        val current = queue.poll()
        val currentNode = current.node
        val currentWeight = current.weight
        for (i in nodeTable[currentNode]) { // 연결되어 있는 노드들
            val nextNode = i.first
            val nextWeight = currentWeight + i.second // 해당 노드까지의 비용
            if (nextWeight < dp[nextNode]) {
                dp[nextNode] = nextWeight
                queue.offer(Node(nextNode, nextWeight))
            }
        }
    }

    dp.drop(1).forEach { i ->
        if (i == Integer.MAX_VALUE) {
            println("INF")
        } else {
            println(i)
        }
    }
}

/*
방향 그래프가 주어지면 시작점에서 다른 모든 정점으로의 최단경로
-> 다익스트라를 사용해야하네.

첫째줄에 정점의 갯수 V와 간선의 갯수 E가 주어진다.
 */
