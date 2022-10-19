package baekjoon.solution1916

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

data class Node(val index: Int, val distance: Int) : Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return this.distance - other.distance
    }
}
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val m = readLine().toInt()
    val list = MutableList(n) { PriorityQueue<Node>() }
    repeat(m) {
        val (start: Int, dest: Int, dist: Int) = readLine()
            .split(" ")
            .map { it.toInt() }
        list[start - 1 ].add(Node(dest - 1, dist))
    }
    val (start: Int, terminal: Int) = readLine()
        .split(" ")
        .map { it.toInt() - 1 }

    val queue: PriorityQueue<Node> = PriorityQueue()
    var distance: IntArray = IntArray(n) { Int.MAX_VALUE }
    var check: BooleanArray = BooleanArray(n) { false }

    distance[start] = 0
    queue.add(Node(start, 0))

    while (queue.isNotEmpty()) {
        val now = queue.poll().index

        if (check[now]) continue
        check[now] = true

        for (next in list[now]) {
            if (distance[next.index] > distance[now] + next.distance) {
                /*

                diatance[now] 현재 거리
                + 버스

             스   */
                distance[next.index] = distance[now] + next.distance
                queue.add(Node(next.index, distance[next.index]))
            }
        }
    }

    println(distance[terminal])
}
