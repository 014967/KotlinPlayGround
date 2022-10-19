package baekjoon.solution9935

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

fun main(): Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    val stack = Stack<Char>()
    val read = readLine().toString()
    val bomb = readLine().toString()

    for (i in read) {
        stack.add(i)
        val top = stack.peek()
        if (top == bomb.last() && stack.size >= bomb.length) {
            var flag = false
            for (j in bomb.indices) {
                if (stack[stack.size - bomb.length + j] != bomb[j]) {
                    flag = true
                    break
                }
            }
            if (!flag) {
                repeat(bomb.length) {
                    stack.pop()
                }
            }
        }
    }
    if (stack.isEmpty()) {
        println("FRULA")
    } else {
        println(stack.joinToString("") { it.toString() })
    }
}
