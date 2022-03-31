package programmers.highscorekit.greedy

import java.util.*
import kotlin.system.measureTimeMillis

/**
 * @desc
 *어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.
예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다. 이 중 가장 큰 숫자는 94 입니다.
문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다.
number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.
제한 조건
number는 2자리 이상, 1,000,000자리 이하인 숫자입니다.
k는 1 이상 number의 자릿수 미만인 자연수입니다.
 * @input
number	k	return
"1924"	2	"94"
"1231234"	3	"3234"
"4177252841"	4	"775841"
 * @output
 *
 * @example
 *
 */

fun main() {
    val number = "987654321"
    val k = 5
    val time = measureTimeMillis {
        println(solution(number, k))
    }
    println("${time}ms")
}

private fun solution(number: String, k: Int): String {
    var answer = StringBuilder()
    val stack = Stack<Int>()

    var del = k
    for (i in number.indices) {
        val newNumber = Character.getNumericValue(number[i])

        if (i == 0)
            stack.push(newNumber)
        else {

            if (stack.peek() < newNumber) {
                while (stack.isNotEmpty() && stack.peek() < newNumber && del> 0) {
                    stack.pop()
                    del-- // pop()을 한다는것은 k만큼 제거를 한게 된다는 것.
                }
            }
            stack.push(newNumber)
        }
    }
    // stack.peek() > newNumber 전부 이럴경우에는 stack에서 del 만큼 take하자.
    for (i in 0 until number.length - k) {
        answer.append(stack[i])
    }
    return answer.toString()
}
/*
4
4 1
4 1 7 -> 7
7 7 -> 7 7
7 7 2
7 7 2 5 -> 7 7 5
7 7 5 2 -> 7 7 5 2
7 7 5 2 8 ->
 */
/*
private fun solution(number: String, k: Int): String {
    var answer = ""
    val returnSize = number.length - k
    var arr = StringBuilder()
    var sbNum = StringBuilder()
    sbNum.append(number)
    recursion(arr, sbNum, returnSize)
    answer = arr.toString()

    return answer
}
 */

/* 시간 초과 발생
private fun recursion(answer: StringBuilder, number: StringBuilder, returnSize: Int) {
    if (answer.length == returnSize) {
        // 내가 뽑아야할 사이즈와 answer.size가 같으면 return
        return
    }
    val maxQueue = PriorityQueue<Int>(reverseOrder())
    val list = mutableListOf<Int>()
    list.addAll(
        number.map {
            Character.getNumericValue(it)
        }
    )
    maxQueue.addAll(list)
    var str = StringBuilder()
    while (true) {
        if (number.length - list.indexOf(maxQueue.peek()) >= returnSize - answer.length) {
            // 7글자 - 6 >= 3? ㄴㄴ
            // 7글자 - 2 >= 3? ㅇㅇ -> 5글자
            for (i in list.indexOf(maxQueue.peek()) until number.length) {
                if (list.indexOf(maxQueue.peek()) == i) {
                    answer.append(number[i])
                } else {
                    str.append(number[i])
                }
            }
            recursion(answer, str, returnSize)
            break
        } else {
            maxQueue.poll()
        }
    }
}
 */
