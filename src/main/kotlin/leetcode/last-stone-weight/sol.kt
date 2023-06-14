package leetcode.`last-stone-weight`

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
    println(sol.lastStoneWeight(intArrayOf(2, 2)))
}

class Solution {

    val stoneQueue = PriorityQueue<Int> { o1, o2 -> o2 - o1 }
    fun lastStoneWeight(stones: IntArray): Int {
        stones.forEach {
            stoneQueue.add(it)
        }

        while (stoneQueue.size > 1) {
            val y = stoneQueue.poll()
            val x = stoneQueue.poll()

            if (x != y) {
                stoneQueue.add(y - x)
            }
        }

        return if (stoneQueue.isEmpty()) {
            0
        } else {
            stoneQueue.poll()
        }
    }
}
