package leetcode.`decode-ways`

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
    for (i in listOf("12", "226", "06")) {
        println(sol.numDecodings(i))
    }
}

class Solution {
    fun numDecodings(s: String): Int {
        val n = s.length
        val dp = IntArray(n + 1)
        dp[0] = 1
        dp[1] = if (s[0] != '0') 1 else 0
        for (i in 2..n) {
            val first = Integer.valueOf(s.substring(i - 1, i))
            val second = Integer.valueOf(s.substring(i - 2, i))
            if (first in 1..9) {
                dp[i] += dp[i - 1]
            }
            if (second in 10..26) {
                dp[i] += dp[i - 2]
            }
        }
        return dp[n]
    }
}