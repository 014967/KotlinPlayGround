package baekjoon.solution2812

import java.io.BufferedReader
import java.io.InputStreamReader
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

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val str = readLine().split(" ").map {
        it.toInt()
    }
    val n = str[0]
    val k = str[1]
    val num = readLine().toString()

    val stack = Stack<Int>()
    stack.push(Character.getNumericValue(num[0]))

    var index = 1
    while (index < num.length) {
        val b = Character.getNumericValue(num[index])

        while (stack.isNotEmpty() && stack.peek() < b && stack.size + num.length - index != (n - k)) {
            stack.pop()
        }
        if (stack.size != n - k) {
            stack.push(b)
        }

        index++
    }
    var result = StringBuilder()
    stack.forEach {
        result.append(it)
    }
    println(result)
}
