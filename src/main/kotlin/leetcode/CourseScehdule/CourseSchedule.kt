package leetcode.CourseScehdule

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

fun main() {
    val sol = Solution()
    val numCourses = 5
    val prerequisites = arrayOf(
        intArrayOf(4, 0),
        intArrayOf(0, 1),
        intArrayOf(3, 0),
        intArrayOf(1, 2),
        intArrayOf(3, 2),
    )
    println(sol.canFinish(numCourses, prerequisites))
}
/*
위상정렬
순서가 정해져있는 일련의 작업을 차례대로 수행해야할 때 사용가능
사이클이 없는 방향 그래프의 모든 노드를 방향성에 거스르지 않도록 순서대로 나열하는 것.

- 진입차수 (indegree) : 특정한 노드로 들어오는 간선의 갯수
- 진출차수 (Outdegree) :  특정한 노드에서 나가는 간선의 갯수

동작과정
1. 진입차수가 0인 노드를 큐에 넣는다.
2. 큐가 빌때까지 다음의 과정을 반복한다.
    - 큐에서 원소를 꺼내 해당 노드에서 나가는 간선을 그래프에서 제거
    - 새롭게 진입차수가 0이 된 노드를 큐에 삽입.

위상 정렬은 사이클이 없는 방향 그래프에서만 수행할 수 있다.
모든 원소를 방문하기 전에 큐가 비게 되다면 사이클이 존재한다고 판단할 수 있다.
사이클에 포함된 원소 중에서 해당되는 어떠한 원소도 큐에 들어가지 못하게 되기 때문이다.

중요한건 방향그래프여야한다는것.
 */

data class Node(
    val key: Int,
    val indegree: Int
)

class Solution {
    lateinit var arr: Array<Int>
    lateinit var check: Array<Boolean>
    var count = 0
    var max = Integer.MAX_VALUE
    var result = true
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val inDegree = Array(numCourses) { 0 }
        val linkList = Array(numCourses) { arrayListOf<Int>() }
        for (i in prerequisites.indices) {
            val (current, before) = prerequisites[i]
            inDegree[current]++
            linkList[before].add(current)
        }

        val queue = PriorityQueue<Int>().apply {
            inDegree.forEachIndexed { index, i ->
                if (i == 0) {
                    offer(index)
                }
            }
        }
        while (queue.isNotEmpty()) {
            count++
            val node = queue.poll()
            println(node)
            for (i in linkList[node]) {
                inDegree[i]--
                if (inDegree[i] == 0) {
                    queue.offer(i)
                }
            }
        }
        return count == numCourses
    }
}
