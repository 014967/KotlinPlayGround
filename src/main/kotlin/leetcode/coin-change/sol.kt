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
/*

1,2,5

(1 .. 11)
dp[1] = if(1- 1>=0)
dp[1] = minOf(dp[1] = 11 , 1 + dp[a-c] = dp[0] + 1) = dp[0] + 1 = 1


dp[2] = coin ( 1,2,5)

dp[2] = minOf(dp[2] = 11 , dp[1] + 1 ) = 2
dp[2] = minOf(dp[2] = 11 , dp[0] + 1 ) = 1

dp[3] = minOf(dp[3] =11 , dp[2] + 1 ) = 2 , 1 + 2 =2
dp[3] = minOf(dp[3] =2 , dp[1] + 1 ) = 1 + 2  , 2 +1  = 2

dp[5] = minOf(dp[a-c] + 1 )  = 1



dp[11] ~~~

if(dp[11] = amount -1 dp[amount]


 */