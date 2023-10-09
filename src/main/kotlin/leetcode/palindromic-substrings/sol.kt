package leetcode.`palindromic-substrings`

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
    val sList = listOf(
       "aabaa"
    )

    val sol = Solution()
    for (s in sList) {
        println(sol.countSubstrings(s))
        println()
    }
}
class Solution {
    fun countSubstrings(s: String): Int {
        val dp = Array(s.length) { BooleanArray(s.length) { false } }
        for (i in s.indices) {
            dp[i][i] = true
        }

        var count = s.length
        var index = 0
        while (index + 1 < s.length) {
            if (s[index] == s[index + 1]) {
                dp[index][index + 1] = true
                count++
            }
            index++
        }

        for (length in 2 until s.length) {
            index = 0
            while (index + length < s.length) {
                val j = index + length
                if ((s[index] == s[j]) && dp[index + 1][j - 1]) {
                    dp[index][j] = true
                    count++
                }
                index++
            }
        }
        return count
    }
}
/*
어떻게 하면 팰린드롬 체크를 O(1)에 할 수 있을까 ?

s의 길이는 최대 1000자 인데

 */
