package leetcode.robs

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
}

class Solution {
    fun rob(nums: IntArray): Int {
        val dp = IntArray(nums.size) { 0 }
        for (i in nums.indices) {
            dp[i] = nums[i]
        }
        if (nums.size <= 2) {
            return nums.maxOf { it }
        }
        for (i in 2 until nums.size) {
            dp[i] = maxOf(
                dp[i - 2] + dp[i],
                dp[i - 1]
            )
        }
        return dp[nums.size - 1]
    }
}
