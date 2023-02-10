package baekjoon.`행복 유치원`

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
    val (n, k) = readLine().split(" ").map { it.toInt() }
    // n : 원생 수 , k : 나누려고하는 조
    val personList = readLine().split(" ").map { it.toInt() }
    val arr = IntArray(personList.size - 1) { 0 } // 옆사람과의 차이를 저장할 배열
    var answer = 0
    for (i in arr.indices) {
        arr[i] = personList[i + 1] - personList[i]
        answer += arr[i]
    }
    arr.sortDescending()
    for (i in 0 until k - 1) {
        answer -= arr[i]
    }
    println(answer)
}
/*
N명의 원생들을 키 순서대로 일렬로 줄세우고, 총 K개의 조로 나누려고한다.
각 조에는 원생이 적어도 한명이 있어야하며, 같은 조에 속하 원생들을 서로 인접해야한다.
조별로 인원수가 같을 필요는 없다.

나누어진 조들은 티를 맞춰야한느데, 조에서 가장 키가 큰 원생과 가장 키가 작은 원생의 키 차이만큼비용이 듬.

K개의 조에 대해서 티셔츠를 만든느 비용의 합을 최소로 하고 싶다.



 */
