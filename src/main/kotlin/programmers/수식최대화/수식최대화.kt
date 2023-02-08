package programmers.수식최대화

import java.util.*
import kotlin.math.abs

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
    val solution = Solution()
    println(solution.solution("100-200*300-500+20"))
}

class Solution {
    fun solution(expression: String): Long {
        var answer: Long = 0

        val str = StringBuilder()

        for (i in expression) {
            if (i.isDigit()) {
                str.append(i)
            } else {
                str.append(" ")
                str.append(i)
                str.append(" ")
            }
        }
        for (i in list) {
            val stack = Stack<String>()
            var exList = str.toString().split(" ")
            while (exList.size != 1) {
                for (j in i) {
                    //  우선순위 별로 계속
                    var k = 0
                    while (k < exList.size) {
                        if (exList[k] == j) {
                            val before = stack.pop().toLong()
                            val current = exList[k]
                            val after = exList[k + 1].toLong()
                            val result = when (current) {
                                "+" -> {
                                    before + after
                                }
                                "-" -> {
                                    before - after
                                }
                                else -> {
                                    before * after
                                }
                            }
                            stack.add(result.toString())
                            k += 2
                        } else {
                            stack.add(exList[k])
                            k++
                        }
                    }
                    exList = stack.toList()
                    stack.clear()
                }
            }
            answer = answer.coerceAtLeast(abs(exList.first().toLong()))
        }
        return answer
    }
}

val list = listOf(
    listOf("+", "-", "*"),
    listOf("+", "*", "-"),
    listOf("-", "+", "*"),
    listOf("-", "*", "+"),
    listOf("*", "+", "-"),
    listOf("*", "-", "+")
)
