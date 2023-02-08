package baekjoon.`특정한 최단 경로`

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

data class Node(
    val node: Int,
    val weight: Int
)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, E) = readLine().split(" ").map { it.toInt() }
    val nodeTable = Array(N + 1) { arrayListOf<Node>() }
    for (i in 1..E) {
        val (a, b, c) = readLine().split(" ").map { it.toInt() }
        nodeTable[a].add(Node(b, c))
        nodeTable[b].add(Node(a, c))
    }
    val (specNode1, specNode2) = readLine().split(" ").map { it.toInt() }
    val list = listOf(listOf(1, specNode1), listOf(specNode1, specNode2), listOf(specNode2, N))
    val list2 = listOf(listOf(1, specNode2), listOf(specNode2, specNode1), listOf(specNode1, N))

    var count = 0
    var count2 = 0
    for (i in list) {
        val s = searchWeight(i[0], i[1], nodeTable)
        count += s
        if (s == Integer.MAX_VALUE) {
            count = -1
            break
        }
    }
    for (i in list2) {
        val s = searchWeight(i[0], i[1], nodeTable)
        count2 += s
        if (s == Integer.MAX_VALUE) {
            count2 = -1
            break
        }
    }

//    var first = searchWeight(1, specNode1, nodeTable) + searchWeight(specNode1, specNode2, nodeTable) + searchWeight(specNode2, N, nodeTable)
//    if (first == Integer.MIN_VALUE) {
//        first = -1
//    }
//    var second = searchWeight(1, specNode2, nodeTable) + searchWeight(specNode2, specNode1, nodeTable) + searchWeight(specNode1, N, nodeTable)
//    if (second == Integer.MIN_VALUE) {
//        second = -1
//    }
    if (count == -1 && count2 == -1) {
        println(-1)
    } else if (count != -1 && count2 != -1) {
        println(minOf(count, count2))
    } else {
        println(maxOf(count, count2))
    }
}
fun searchWeight(start: Int, end: Int, nodeTable: Array<ArrayList<Node>>): Int {
    val priQueue = PriorityQueue<Node>() { n1, n2 -> n1.weight - n2.weight }
    val dp = Array(nodeTable.size) { Integer.MAX_VALUE }
    priQueue.offer(Node(start, 0))
    dp[start] = 0
    while (priQueue.isNotEmpty()) {
        val current = priQueue.poll()
        val currentNode = current.node
        val currentWeight = current.weight
        for (i in nodeTable[currentNode]) { // 연결 노드들
            val nextNode = i.node
            val nextWeight = currentWeight + i.weight
            if (nextWeight < dp[nextNode]) {
                dp[nextNode] = nextWeight
                priQueue.offer(Node(nextNode, nextWeight))
            }
        }
    }

    return dp[end]
}
/*
방향성이 없는 그래프. 1번에서 n번으로 이동하려고함.
임의로 주어진 두 정점은 반드시 통과해야한다는 것

한번 이동했던 정점이나 한번 이동했던 간선 다시 이동 가능.
최단 경로로 이동해야한다.
 */
