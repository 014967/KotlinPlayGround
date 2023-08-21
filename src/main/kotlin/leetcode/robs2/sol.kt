package leetcode.robs2

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
    val nums = listOf(

        intArrayOf(2, 1, 1, 2)
    )

    for (num in nums) {
        println(sol.rob(num))
    }
}

class Solution {
    fun rob(nums: IntArray): Int {
        val dp = IntArray(nums.size) { 0 }
        for (i in nums.indices) {
            dp[i] = nums[i]
        }
        if (nums.size == 1) {
            return nums[0]
        }
        if (nums.size == 2) {
            return if (nums[0] > nums[1]) {
                nums[0]
            } else {
                nums[1]
            }
        }

        if (nums.size == 3) {
            return maxOf(nums[1], nums[0], nums[2])
        }

        if (nums.size == 4) {
            return maxOf(nums[1] + nums[3], nums[0] + nums[2])
        }

        var max = Integer.MIN_VALUE

        // 1을 선택했다면?

        for (i in nums.indices) {
            dp[i] = nums[i]
        }
        for (i in 2 until nums.size) {
            if (i == 2) {
                dp[i] = maxOf(nums[i], dp[i - 1])
            } else {
                if (i == 3) {
                    dp[i] = maxOf(
                        dp[i - 1],
                        dp[i - 2] + nums[i]
                    )
                } else {
                    dp[i] = maxOf(
                        dp[i - 2] + nums[i],
                        dp[i - 1],
                        dp[i - 3] + nums[i]
                    )
                }
            }
        }
        max = max.coerceAtLeast(dp[nums.size - 1])
        for (i in nums.indices) {
            dp[i] = nums[i]
        }

        // 0을 선택했다면?
        for (i in 2 until nums.size) {
            if (i == 2) {
                dp[2] = dp[0] + dp[2]
            } else {
                if (i == 3) {
                    dp[i] = maxOf(dp[2], dp[0] + nums[i])
                } else {
                    if (i == nums.size - 1) {
                        dp[i] = dp[i - 1]
                    } else {
                        dp[i] = maxOf(
                            dp[i - 2] + dp[i],
                            dp[i - 1],
                            dp[i - 3] + dp[i]
                        )
                    }
                }
            }
        }
        max = max.coerceAtLeast(dp[nums.size - 1])

        return max
    }
}

/*
4 2 5
4 7 3

 */
