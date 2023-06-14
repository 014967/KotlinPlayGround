package leetcode.KthLargestElementInAnArray

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
    println(sol.findKthLargest(intArrayOf(3, 2, 1, 5, 6, 4), 2))
}

/*
intArray가 주어졌을때, 정렬했을때의 k번째로 큰수를 구해라.
 */
class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val minusArray = Array(10001) { 0 }
        val plusArray = Array(10001) { 0 }
        for (i in nums) {
            if (i < 0) {
                val convertI = kotlin.math.abs(i)
                minusArray[convertI] = minusArray[convertI] + 1
            } else {
                plusArray[i] = plusArray[i] + 1
            }
        }
        var count = k
        for (index in plusArray.size - 1 downTo 0) {
            if (count <= plusArray[index]) {
                return index
            } else {
                count -= plusArray[index]
            }
        }

        if (count > 0) {
            for (index in 1 until minusArray.size) {
                if (count <= minusArray[index]) {
                    return -index
                } else {
                    count -= minusArray[index]
                }
            }
        }

        return 0
    }
}
