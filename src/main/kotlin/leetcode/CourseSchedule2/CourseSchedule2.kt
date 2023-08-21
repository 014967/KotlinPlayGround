package leetcode.CourseSchedule2

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
    val numCourses = 3
    val prerequisites = arrayOf(
        intArrayOf(1, 0),
        intArrayOf(1, 2),
        intArrayOf(0, 1)
    )
    val sol = Solution()
    println(sol.findOrder(numCourses, prerequisites).joinToString { it.toString() })
}

class Solution {
    lateinit var inDegree: Array<Int>
    lateinit var linked: Array<ArrayList<Int>>
    var count = 0
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        inDegree = Array(numCourses) { 0 }
        linked = Array(numCourses) { arrayListOf() }
        for (i in prerequisites.indices) {
            val (current, before) = prerequisites[i]
            inDegree[current]++
            linked[before].add(current)
        }
        val queue = PriorityQueue<Int>().apply {
            // 진입차수가 0 인것부터 queue에 넣는다.
            inDegree.forEachIndexed { index, i ->
                if (i == 0) {
                    offer(index)
                }
            }
        }
        val result = arrayListOf<Int>()
        while (queue.isNotEmpty()) {
            val current = queue.poll()
            result.add(current)
            count++
            for (i in linked[current]) {
                inDegree[i]--
                if (inDegree[i] == 0) {
                    queue.offer(i)
                }
            }
        }
        if (count != numCourses) {
            return intArrayOf()
        } else {
            return result.toTypedArray().toIntArray()
        }
    }
}
