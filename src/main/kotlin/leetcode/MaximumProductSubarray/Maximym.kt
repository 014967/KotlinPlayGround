package leetcode.MaximumProductSubarray

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
    val test = listOf(
        intArrayOf(1, 2, -1, -2, 2, 1, -2, 1, 4, -5, 4),
        intArrayOf(2, 3, -2, 4),
        intArrayOf(-2, 0, -1),
        intArrayOf(2, 3, -2, 4)

    )
    for (i in test) {
        println(sol.maxProduct(nums = i))
    }
}

class Solution {
    fun maxProduct(nums: IntArray): Int {
        val minArray = IntArray(nums.size) { nums[0] }
        minArray[0] = nums[0]

        val maxArray = IntArray(nums.size) { nums[0] }
        maxArray[0] = nums[0]

        for (i in 1 until nums.size) {
            maxArray[i] = maxOf(nums[i], maxArray[i - 1] * nums[i], minArray[i - 1] * nums[i])
            minArray[i] = minOf(nums[i], maxArray[i - 1] * nums[i], minArray[i - 1] * nums[i])
        }

        var maxInArray = Integer.MIN_VALUE
        var minInArray = Integer.MIN_VALUE

        for (i in nums.indices) {
            maxInArray = maxInArray.coerceAtLeast(maxArray[i])
            minInArray = minInArray.coerceAtLeast(minArray[i])
        }
        return maxOf(maxInArray, minInArray)
    }
}
/*
곱했을 때 최댓값이 될 수 있는 가능성은
현재 탐색중인 원소가 양수인경우 가장 큰 양수를 곱하는 경우
탐색중인 원소가 음수인 경우 가장 작은 음수를 곱하는 경우
배열을 탐색해나가면서 원소의 곱이 가장 큰 경우와 가장 작은 경우를 변수에 저장해ㅈ둔다.
 */
