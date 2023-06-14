package leetcode.KClosestPointsToOrigin

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
    val points = arrayOf(intArrayOf(1, 3), intArrayOf(-2, 2))
    val k = 1
    val sol = Solution()
    println(sol.kClosest(points, k))
}

data class VertexWithDistance(
    val point: IntArray,
    val distance: Int
) : Comparable<VertexWithDistance> {
    override fun compareTo(other: VertexWithDistance): Int {
        return this.distance - other.distance
    }
}
class Solution {

    val queue = PriorityQueue<VertexWithDistance>()
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        points.forEach {
            val x = it[0]
            val y = it[1]

            val distance = x * x + y * y
            queue.offer(VertexWithDistance(it, distance))
        }
        val resultArray = Array(k) { IntArray(2) { 0 } }
        var count = 0
        while (count != k) {
            resultArray[count] = queue.poll().point
            count++
        }
        return resultArray
    }
}
