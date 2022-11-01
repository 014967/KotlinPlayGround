package programmers.큰수만들기

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
    val numbers = listOf(listOf("4321", 1))
    val solution = Solution()
    numbers.forEach {
        println(solution.solution(it[0] as String, it[1] as Int))
    }
}

class Solution {
    fun solution(number: String, k: Int): String {
        var answer = ""
        var kCount = k
        val stack = Stack<Int>()
        stack.add(number[0].getInt())
        var numbersIndex = 1
        while (kCount != 0 && numbersIndex in number.indices) {
            val top = stack.peek()
            val next = number[numbersIndex].getInt()
            if (top < next) {
                // 다음에 오는 값이 더 클경우
                while (stack.isNotEmpty() &&
                    stack.peek() < next &&
                    kCount != 0
                ) {
                    stack.pop()
                    kCount--
                }
                stack.add(next)
            } else {
                if (stack.size != number.length - k) {
                    stack.add(next)
                }
            }
            numbersIndex++
        }
        if (stack.size != number.length - k) {
            for (i in numbersIndex until number.length) {
                stack.add(number[i].getInt())
            }
        }
        answer = stack.joinToString("") { it.toString() }
        return answer
    }
}
fun Char.getInt(): Int {
    return Character.getNumericValue(this)
}
