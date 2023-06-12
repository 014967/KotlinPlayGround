package leetcode.`kth-largest-element-in-a-stream`

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
    val c = KthLargest(3, intArrayOf(4, 5, 8, 2))
    val addValue = listOf(3, 5, 10, 9, 4)
    addValue.forEach {
        println(c.add((it)))
    }
}

class KthLargest(k: Int, nums: IntArray) {

    val maxHeap = PriorityQueue<Int> { o1, o2 -> o1 - o2 }
    val minHeap = PriorityQueue<Int> { o1, o2 -> o2 - o1 }
    val limit = k
    init {
        nums.forEach { target ->
            if (maxHeap.size < k) {
                maxHeap.add(target)
            } else {
                if (maxHeap.isNotEmpty()) {
                    val top = maxHeap.peek()
                    if (top <= target) {
                        val pop = maxHeap.poll()
                        minHeap.add(pop)
                        maxHeap.add(target)
                    } else {
                        minHeap.add(target)
                    }
                } else {
                    maxHeap.add(target)
                }
            }
        }
    }
    fun add(`val`: Int): Int {
        if (maxHeap.size < limit) {
            maxHeap.add(`val`)
        } else {
            if (maxHeap.isNotEmpty()) {
                val top = maxHeap.peek()
                if (top <= `val`) {
                    val pop = maxHeap.poll()
                    minHeap.add(pop)
                    maxHeap.add(`val`)
                } else {
                    minHeap.add(`val`)
                }
            } else {
                maxHeap.add(`val`)
            }
        }
        return maxHeap.peek()
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * var obj = KthLargest(k, nums)
 * var param_1 = obj.add(`val`)
 */
