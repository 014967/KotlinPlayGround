package baekjoon.`숨바꼭질 3`

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

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, K) = readLine().split(" ").map { it.toInt() }
    search(N, K)
}

data class Vertex(
    val node: Int,
    val time: Int
)

val move = listOf(2, 1, -1)
fun search(start: Int, end: Int) {
    val queue = LinkedList<Pair<Int, Int>>()
    val dp = Array(100001) { Integer.MAX_VALUE } // 최소비용을 넣음.
    dp[start] = 0 // 시작은 0

    queue.offer(Pair(start, 0))

    val visited = Array(100001) { false }
    visited[start] = true
    while (queue.isNotEmpty()) {
        val current = queue.poll()

        val currentNode = current.first
        val time = current.second
        visited[currentNode] = true

        if (currentNode == end) {
            println(time)
            break
        }

        for (i in move) {
            val nextNode = if (i != 2) currentNode + i else currentNode * 2
            val nextTime = if (i != 2) time + 1 else time
            if (nextNode in dp.indices && !visited[nextNode] && nextTime < dp[nextNode]) {
                // 한노드에서 점프를 하거나 좌우로 이동한다.
                if (i == 2) {
                    queue.offerFirst(Pair(nextNode, nextTime))
                } else {
                    queue.offer(Pair(nextNode, nextTime))
                }
                dp[nextNode] = nextTime
            }
        }
    }
}
// fun search(start: Int, end: Int) {
//    val priQueue = PriorityQueue<Vertex>() { v1, v2 ->
//        v1.time - v2.time
//    } // 시간이 제일 짧은 순으로 저장
//
//    val visited = Array(100001) { false }
//    priQueue.offer(Vertex(start, 0))
//    visited[start] = true
//    while (priQueue.isNotEmpty()) {
//        val current = priQueue.poll()
//        visited[current.node] = true
//        if (current.node == end) {
//            println(current.time)
//            break
//        }
//        if (current.node * 2 < visited.size && !visited[current.node * 2]) {
//            priQueue.offer(Vertex(current.node * 2, current.time))
//        }
//        if (current.node + 1 < visited.size && !visited[current.node +1]) {
//            priQueue.offer(Vertex(current.node + 1, current.time + 1))
//        }
//        if (current.node - 1 >= 0 && !visited[current.node -1]) {
//            priQueue.offer(Vertex(current.node - 1, current.time + 1))
//        }
//    }
// }

/*
https://velog.io/@ich0906/%EB%B0%B1%EC%A4%80-13549-%EC%88%A8%EB%B0%94%EA%BC%AD%EC%A7%883




 */

/*
다익스트라는, 반복문만 이용하는 방법과  O(노드의 갯수 ^ 2)
힙 자료주고를 사용하는 우선순위 큐가 있음 O( 간선의 갯수 * log 노드의 갯수)

BFS는 모든 간선의 가중치가 동일해야한다는 전제조건이 있지만,
이 문제의 경우는 순간이동과 좌우 이동의 가중치가 다르다.

우선순위 큐를 사용하지 않으면, 정점은 많은데 간선의 갯수는 적은 경우 굉장히 비효율적이다.
 */
