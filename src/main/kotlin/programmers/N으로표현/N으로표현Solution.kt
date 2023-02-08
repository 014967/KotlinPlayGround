package programmers.N으로표현

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
    val arg = listOf(listOf(5, 12), listOf(2, 11))
    val solution = Solution2()
    arg.forEach {
        println(solution.solution(it[0], it[1]))
    }
}

class Solution2 {
    fun solution(N: Int, number: Int): Int {
        var answer = -1
        val dp = Array(8) { mutableSetOf<Int>() }
        var sum = 0
        for (element in dp) {
            sum = 10 * sum + N
            element.add(sum)
        }
        for (i in 1 until dp.size) {
            for (j in 0 until i) {
                for (a in dp[j]) { // 교환법칙으로 곱해주기 위해서
                    for (b in dp[i - j - 1]) { //  교환법칙으로 곱해주기 위해서
                        dp[i].add(a + b)
                        dp[i].add(a - b)
                        dp[i].add(a * b)
                        if (b != 0) {
                            dp[i].add(a / b)
                        }
                    }
                }
            }
        }
        for (i in dp.indices) {
            if (dp[i].any { it == number }) {
                answer = i + 1
                break
            }
        }

        return answer
    }
}
