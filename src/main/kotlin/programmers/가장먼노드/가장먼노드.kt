package programmers.가장먼노드

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
    val n = 6
    val vertex = arrayOf(intArrayOf(3, 6), intArrayOf(4, 3), intArrayOf(3, 2), intArrayOf(1, 3), intArrayOf(1, 2), intArrayOf(2, 4), intArrayOf(5, 2))
    val solution = Solution()
    println(solution.solution(n, vertex))
}

data class Node(
    val nodeNum: Int,
    val depth: Int
)

class Solution {
    fun solution(n: Int, edge: Array<IntArray>): Int {
        var answer = 0
        val queue = LinkedList<Node>()
        val edgeList = Array<ArrayList<Int>>(n + 1) { arrayListOf() }
        edge.forEach {
            val start = it[0]
            val end = it[1]
            edgeList[start].add(end)
            edgeList[end].add(start)
        }

        queue.offer(Node(1, depth = 0))
        val check = Array(n + 1) { false }

        val resultList = arrayListOf<Node>()
        var maxDepth = 0
        while (queue.isNotEmpty()) {
            val current = queue.poll()
            check[current.nodeNum] = true
            var flag = false
            edgeList[current.nodeNum].forEach {
                if (!check[it]) {
                    flag = true
                    queue.offer(Node(it, current.depth + 1))
                    maxDepth = maxDepth.coerceAtLeast(current.depth + 1)
                    check[it] = true
                }
            }
            if (!flag) {
                // leaf 노드인가?
                resultList.add(current)
            }
        }
        answer = resultList.count {
            it.depth == maxDepth
        }
        return answer
    }
}
/*
n개의 노드가 있는 그래프.
노드는 1부터 n까지 번호가 적혀있다.
1번노드에서 가장 멀리 떨어진 노드의 갯수를 구하려고 한다.
가장 멀리 떨어진노드란 최단 경로로 이동했을때 간선의 갯수가 가장 많은 노드들을 의미
노드의 갯수 n개, 간선에 대한 정보다 담긴 2차원 배열
1번 노드로부터 가장 멀리 떨어진 노드가 몇개인지 return

 */
