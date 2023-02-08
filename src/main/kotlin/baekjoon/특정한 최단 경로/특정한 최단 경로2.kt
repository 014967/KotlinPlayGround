package baekjoon.`특정한 최단 경로`

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

data class Info(
    val end: Int,
    val distance: Int
)
lateinit var lineMap: HashMap<Int, ArrayList<Info>>
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val(N, E) = readLine().split(" ").map { it.toInt() }
    require(N in 2..800)
    require(E in 0..200000)

    lineMap = HashMap<Int, ArrayList<Info>>()

    for (i in 0 until E) {
        val (a, b, c) = readLine().split(" ").map { it.toInt() }
        // a번 정점에서 b번 정점까지 그 거리가 c다
        require(c in 1..1000)

        if (lineMap.containsKey(a)) {
            if (lineMap[a] != null) {
                lineMap[a]?.add(Info(b, c))
            }
        } else {
            lineMap[a] = arrayListOf()
            if (lineMap[a] != null) {
                lineMap[a]?.add(Info(b, c))
            }
        }
        if (lineMap.containsKey(b)) {
            if (lineMap[b] != null) {
                lineMap[b]?.add(Info(a, c))
            }
        } else {
            lineMap[b] = arrayListOf()
            if (lineMap[b] != null) {
                lineMap[b]?.add(Info(a, c))
            }
        }
    }
    val (v1, v2) = readLine().split(" ").map { it.toInt() }
    // 반드시 거쳐야하는 정점 2개

    val case1_1 = bfs(1, v1)
    val case1_2 = bfs(v1, v2)
    val case1_3 = bfs(v2, N)

    val case1_result = if (case1_1 == Integer.MAX_VALUE || case1_2 == Integer.MAX_VALUE || case1_3 == Integer.MAX_VALUE) {
        Integer.MAX_VALUE
    } else {
        case1_1 + case1_2 + case1_3
    }

    val case2_1 = bfs(1, v2)
    val case2_2 = bfs(v2, v1)
    val case2_3 = bfs(v1, N)

    val case2_result = if (case2_1 == Integer.MAX_VALUE || case2_2 == Integer.MAX_VALUE || case2_3 == Integer.MAX_VALUE) {
        Integer.MAX_VALUE
    } else {
        case2_1 + case2_2 + case2_3
    }

    if (case1_result == Integer.MAX_VALUE && case2_result == Integer.MAX_VALUE) {
        println(-1)
    } else {
        println(minOf(case1_result, case2_result))
    }

    // 1번 정점에서 v1까지 최단 거리
    // v1 에서 v2까지 최단 거리
    // v2에서 N번정점까지 최단거리를 합해
}
fun bfs(startNode: Int, endNode: Int): Int {
    val queue = LinkedList<Info>()
    queue.offer(Info(startNode, 0))

    val dp = Array(lineMap.size + 1) { Integer.MAX_VALUE }
    dp[startNode] = 0
    while (queue.isNotEmpty()) {
        val currentNode = queue.poll()
        val info = lineMap[currentNode.end]
        if (info != null) {
            for (i in info) {
                val nextDistance = currentNode.distance + i.distance
                if (dp[i.end] > nextDistance) {
                    dp[i.end] = nextDistance
                    queue.offer(Info(i.end, distance = nextDistance))
                }
            }
        }
    }
    return dp[endNode]
}

// 그냥 bfs로는 싸이클에 대해서 해결할 수 없다.
/*
방향성 없는 그래프
1번 정점에서  N번까지 최단 거리 하려고함.
임의의 두 정점은 반드시 통과해야한다.

한번 이동했던 정점은 물론 한번 이동했던 간선도 다시 이동할 수 있다.

지나간 경로를 또 가지 않게 하기 위해서는 메모이제이션을 사용하는 것이 좋음.

 */
