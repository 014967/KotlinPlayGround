package programmers.`숫자 문자열과 영단어`


import java.io.BufferedReader
import java.io.InputStreamReader

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
    val solution = Solution()
    println(solution.solution("23four5six7"))
}

class Solution {
    fun solution(s: String): Int {
        var answer = StringBuilder()

        val temp = StringBuilder()
        for (i in s) {
            if (temp.length == 3 || temp.length == 4 || temp.length == 5) {
                val transInt = translate(temp.toString())
                if (transInt != -1) {
                    answer.append(transInt)
                    temp.clear()
                }
            }
            if (i.isDigit()) {
                answer.append(i)
            } else {
                temp.append(i)
            }
        }
        if (temp.isNotEmpty()) {
            answer.append(translate(temp.toString()))
        }
        return answer.toString().toInt()
    }

    fun translate(str: String): Int {
        return when (str.length) {
            3 -> {
                when (str) {
                    "one" -> { 1 }
                    "two" -> { 2 }
                    "six" -> { 6 }
                    else -> { -1 }
                }
            }
            4 -> {
                when (str) {
                    "zero" -> { 0 }
                    "four" -> { 4 }
                    "five" -> { 5 }
                    "nine" -> { 9 }
                    else -> { -1 }
                }
            }
            else -> {
                when (str) {
                    "three" -> { 3 }
                    "seven" -> { 7 }
                    "eight" -> { 8 }
                    else -> { -1 }
                }
            }
        }
    }
}

/*

fun translate(str: String): Int {
        return when (str) {
            "zero" -> { 0 }
            "one" -> { 1 }
            "two" -> { 2 }
            "three" -> { 3 }
            "four" -> { 4 }
            "five" -> { 5 }
            "six" -> { 6 }
            "seven" -> { 7 }
            "eight" -> { 8 }
            else -> { 9 }
        }
    }
 */
/*
네오가 프로도에게 숫자를 건넬 때 일 부 자릿수를 영단어로 바꾼 카드를 건네주면
프로도는 원래 숫자를 찾는 것.

 */
