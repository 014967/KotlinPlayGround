package baekjoon.PPAP

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var first = readLine()
    val stack = Stack<Char>()

    var index = 0

    while (index <= first.length - 1) {
        val currentChar = first[index]
        if (currentChar == 'A') {
            val lastStackIndex = stack.lastIndex

            if (index + 1 == first.length ||
                lastStackIndex - 1 < 0
            ) {
                stack.add(currentChar)
                index++
            } else {
                if (first[index + 1] == 'P' &&
                    stack[lastStackIndex] == 'P' &&
                    stack[lastStackIndex - 1] == 'P'
                ) {
                    repeat(2) {
                        stack.pop()
                    }
                    stack.add('P')
                    index += 2
                } else {
                    stack.add(currentChar)
                    index++
                }
            }
        } else {
            stack.add(currentChar)
            index++
        }
    }
    if (stack.size == 1) {
        if (stack.pop() == 'P') {
            println("PPAP")
        } else {
            println("NP")
        }
    } else {
        println("NP")
    }
}

/*
문자열 P에서 시작하여, 문자열 내의 P를 PPAP로 바꾸는 과정을 반복하여 만들 수 있는 문자열로 정의

문자열 P로 시작하고, 문자열 내부에 있는 P를 PPAP로 바꾸는 과정을 만들 수 있는 문자열로 정의

PPAPAPP

P -> PPAP

PPAPPAP
PPPAPAP
PPAPPAP


P PPAP AP
PPAXP

PPAP
PPPP
P , PPPA,
PP, PPAP
PPP,
 */
