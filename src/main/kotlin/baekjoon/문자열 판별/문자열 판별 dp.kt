package baekjoon.`문자열 판별`

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.system.exitProcess

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

lateinit var wordArray: Array<String>
lateinit var S: String
var n: Int = 0
val dp = BooleanArray(101) { false }
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    S = readLine()
    require(S.length <= 100)
    n = readLine().toInt()
    require(n in 1..100)

    wordArray = Array(101) { "" }

    for (i in 0 until n) {
        val A = readLine().apply {
            require(this.length <= 100)
        }
        wordArray[i] = A
    }
    solve(0)
    println(0)
}

fun solve(index: Int) {
    if (dp[index]) {
        println("index: $index and dp[index] :${dp[index]}")
        return
    }
    if (index == S.length) {
        println(1)
        exitProcess(0)
    }
    dp[index] = true
    for (i in 0 until n) {
        val currentWord = wordArray[i]
        val length = currentWord.length
        val regex = Regex(currentWord)

        if (S.length < index + length) {
        } else {
            val tempString = S.substring(index, index + length)
            val matchResult: MatchResult? = regex.matchEntire(tempString)
            if (matchResult != null) {
                solve(index + length)
            }
        }
    }
}

/*
dp[index] 는 index에서부터 남은 문자열을 만ㄷ르 수 있는지 없는지를 의미한다.
현재 index에서부터 N개의 문자열 중 동일하게 매칭되는 문자열이 있는 경우 위치를 이동하여 계속 진행

 */
