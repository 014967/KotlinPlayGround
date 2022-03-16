package baekjoon.solution1181

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * @desc
 * 알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.
 * 길이가 짧은 것부터
 * 길이가 같으면 사전 순으로
 * @input
 * 첫째 줄에 단어의 개수 N이 주어진다. (1 ≤ N ≤ 20,000) 둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어진다. 주어지는 문자열의 길이는 50을 넘지 않는다.
 * @output
 * 조건에 따라 정렬하여 단어들을 출력한다. 단, 같은 단어가 여러 번 입력된 경우에는 한 번씩만 출력한다.
 * @example
 *
 */

fun main() = with(System.out.bufferedWriter()) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    require(n >= 1)
    require(n <= 20000)
    val nList = mutableSetOf<String>()

    for (i in 1..n) {
        val str = br.readLine()
        require(str.length <= 50)
        nList.add(str)
    }
    val list = nList.sortedWith(
        compareBy<String> { it.length }
            .thenBy { it }
    )
    for (element in list) {
        println(element)
    }
}

fun solution2(n: Int) {
    var nList = mutableSetOf<String>()

    for (i in 1..n) {
        val str = readLine().toString()
        require(str.length < 50)
        nList.add(str)
    }

    val list = nList.sortedWith { a, b ->
        when {
            a.length < b.length -> -1
            a.length == b.length -> when {
                a < b -> -1
                else -> 1
            }
            else -> 1
        }
    }
    for (element in list) {
        println(element)
    }
}
