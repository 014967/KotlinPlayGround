package programmers.solution

import kotlin.math.sqrt

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
    val n = 10000000
    val k = 3
    val solution17 = Solution17()

    println(solution17.solution(n, k))
}
class Solution17 {
    fun solution(n: Int, k: Int): Int {
        var answer = 0

        var num = 0L

        for (i in changeTK(n, k)) {
            // char로 접근
            if (i != '0') {
                num = num * 10 + Character.getNumericValue(i)
            } else {
                if (isPrime(num)) {
                    answer += 1
                }
                num = 0
            }
        }
        if (isPrime(num))
            answer += 1
        return answer
    }
    fun changeTK(n: Int, k: Int): String {
        val kStr = StringBuilder()
        var newN = n
        while (newN != 0) {
            kStr.append(newN % k)
            newN /= k
        }
        return kStr.reverse().toString()
    }

    fun isPrime(p: Long): Boolean {
        var result = true
        if (p <= 1) {
            result = false
            return result
        }
        val limit = sqrt(p.toDouble()).toLong()
        for (i in 2..limit) {
            if (p % i == 0L) {
                result = false
                break
            }
        }
        return result
    }
}
