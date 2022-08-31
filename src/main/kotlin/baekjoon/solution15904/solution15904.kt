package baekjoon.solution15904

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

/**
 * @desc
 * 축약 임의의 문잗르을 제거하는 행동
 * @input
 *
 * @output
 *
 * @example
 *
 */

fun main(args: Array<String>): Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    val str = readLine().toString().split(" ") // 공백으로 리스트를 만든다.

    var i = 0

    var result = "I hate UCPC"

    val stack = Stack<Char>()
    stack.push('C')
    stack.push('P')
    stack.push('C')
    stack.push('U')

    while (i != str.size) {
        if (stack.isEmpty()) {
            result = "I love UCPC"
            break
        }
        var k = str[i]
        for (j in k) {
            if (stack.isNotEmpty() && j == stack.peek()) {
                stack.pop()
            }
        }
        if(stack.isEmpty()){
            result = "I love UCPC"
            break
        }
        i++
    }
    println(result)
}
