package leetcode.BestTimeToBuyAndSellStock

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
    println(sol.maxProfit(intArrayOf(2,1,2,0,1)))
}

class Solution {
    fun maxProfit(prices: IntArray): Int {
        var buy = prices[0]
        var sell = 0
        if (prices.size == 1) {
            return 0
        }
        var result = 0
        var isDescending = true
        for (i in 1 until prices.size) {
            if (buy > prices[i]) {
                buy = prices[i]
            } else {
                isDescending = false
                sell =  prices[i]
                result = result.coerceAtLeast(sell - buy)
            }
        }
        if (isDescending) {
            return 0
        }
        println("buy $buy, sell $sell")
        return result
    }
}
