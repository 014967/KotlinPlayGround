package programmers.`괄호 변환`

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
    val p = listOf("(()())()", ")(", "()))((()")
    val solution = Solution()
    p.forEach { println(solution.solution(it)) }
}

class Solution {
    fun solution(p: String): String {
        var answer = ""

        answer = check(p)
        return answer
    }
}

fun check(p: String): String {
    var result = ""
    val arr = Array<Int>(2) { 0 }
    var index = 0
    if (p.isEmpty()) {
        return ""
    } else {
        for (i in p.indices) {
            if (p[i] == '(') {
                arr[0]++
            } else {
                arr[1]++
            }
            if (arr[0] == arr[1]) {
                index = i
                break
            }
        }
        var u = p.substring(0, index + 1)
        val v = p.substring(index + 1, p.length)

        val queue = LinkedList<Char>()
        if (u.isNotEmpty()) {
            queue.offer(u[0])
        }
        for (i in 1 until u.length) {
            if (queue.peek() == '(' && u[i] == ')') {
                queue.poll()
            } else {
                queue.offer(u[i])
            }
        }
        if (queue.isEmpty()) {
            // 올바른
            result += u + check(v)
        } else {
            val str = StringBuilder()
            str.append('(')
            str.append(check(v))
            str.append(')')
            u = u.substring(1, index)
            for (i in u) {
                if (i == '(') {
                    str.append(')')
                } else {
                    str.append('(')
                }
            }
            result += str.toString()
        }
    }

    return result
}
