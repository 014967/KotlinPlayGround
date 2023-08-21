package leetcode.`coin-change`

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
    println(
        sol.coinChange(
            coins = intArrayOf(2, 5),
            amount = 11
        )
    )
}

class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        val dp = IntArray(amount + 1) { amount + 1 }
        dp[0] = 0
        for (a in 1..amount) {
            for (c in coins) {
                if (a - c >= 0) {
                    dp[a] = minOf(dp[a], 1 + dp[a - c])
                }
            }
        }

        return if (dp[amount] != amount + 1) dp[amount] else -1
    }
}
