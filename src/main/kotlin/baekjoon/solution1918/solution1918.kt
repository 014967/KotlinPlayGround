package baekjoon.solution1918

import java.util.*

/**
 * @desc
 * 주어진 중위 표기식을 연산자의 우선순위에 따라 괄호로 묶어준다. 그런 다음에 괄호 안의 연산잘르 괄호의 오른쪽으로 옮겨준다.
 * 예를 들어 a+b*c는 (a+(b*c))의 식과 같게 된다. 그 다음에 안에 있는 괄호의 연산자 *를 괄호 밖으로 꺼내게 되면 (a+bc*)가 된다.
 * 마지막으로 또 +를 괄호의 오른쪽으로 고치면 abc*+r가 되게 된다.
 * @input
 * 첫째 줄에 중위 표기식이 주어진다. 단 이 수시그이 피연산자는 알파벳 대문자로 이루어지며 수식에서 한번씩만 등장한다.
 * -A + B와 같이 -r가 가장 앞에 오거나 AB와 같이 *가 생략되는 등의 수식은 주어지지않는다.
 * 표기식은 알파벳 대문자와 +, -, *, / ,(,) 로만 이루어져 있으며, 길이는 100을 넘지 않는다.
 * @output
 *
 * @example
 *
 */

fun main() {
    val str = readLine()
    solution(str.toString())
}
fun solution(str: String) {
    val stack = Stack<Char>()

    val result = StringBuilder()
    val map = HashMap<Char, Int>()
    map.put('(', 0)
    map.put('+', 1)
    map.put('-', 1)
    map.put('*', 2)
    map.put('/', 2)

    for (i in str) {
        if (i in 'A'..'Z') {
            result.append(i)
        } else if (i == '(') {
            stack.push('(')
        } else if (i == ')') {
            while (true) {
                if (stack.peek() == ('(')) {
                    stack.pop()
                    break
                } else {
                    result.append(stack.pop())
                }
            }
        } else {
            // 다른 연산자 일 때
            while (true) {
                if (stack.size != 0 && map[stack.peek()]!! < map[i]!!) {
                    stack.push(i)
                    break
                } else if (stack.size == 0) {
                    stack.push(i)
                    break
                } else {
                    result.append(stack.pop())
                }
            }
        }
    }
    while (!stack.isEmpty()) {
        result.append(stack.pop())
    }
    println(result)
}
