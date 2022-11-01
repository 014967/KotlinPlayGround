package programmers.제일큰수

import java.util.*

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
    val numbers = listOf(intArrayOf(6, 10, 2), intArrayOf(3, 30, 34, 5, 9), intArrayOf(0, 0, 0, 0))
    val solution = Solution()
    for (i in numbers) {
        println(solution.solution(i))
    }
}

class Solution {
    fun solution(numbers: IntArray): String {
        var answer = StringBuilder()

        val s = numbers.sortedWith(
            comparator = Comparator<Int> { o1, o2 -> o2.toString()[0] - o1.toString()[0] }
                .thenComparing { o1: Int, o2: Int ->
                    "${o2}$o1".toInt() - "${o1}$o2".toInt()
                }
        )
        s.forEach { answer.append(it) }
        if (answer.none {
            it != '0'
        }
        ) {
            answer.clear()
            answer.append('0')
        }
        return answer.toString()
    }
}
/*
0 또는 양의 정수가 주어졌을 때, 정수를 이어붙여 만들 수 있는 가장 큰수를 알아내라

6 , 10 ,2
6102, 6210 , 1062 ~ 가장 큰수는 6210이다.

구현 봄 ;
 */
