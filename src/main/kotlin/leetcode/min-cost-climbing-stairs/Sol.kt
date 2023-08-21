package leetcode.`min-cost-climbing-stairs`

fun main() {
    val sol = Solution()
    println(sol.minCostClimbingStairs(cost = intArrayOf(
        1, 100, 1,1,1,100,1,1,100,1
    )))
}
class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        val dp = Array(cost.size) { 0 }

        if (cost.size <= 2) {
            return minOf(cost[0], cost[1])
        }

        for (i in 2 until cost.size) {
            dp[i] = minOf(dp[i - 2] + cost[i-2], dp[i - 1] + cost[i-1])
        }


        return minOf(dp[cost.size-2] + cost[cost.size-2], dp[cost.size-1] + cost[cost.size-1])
    }
}
