package baekjoon.과제

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

data class Subject(
    val date: Int,
    val score: Int
)
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()

    val scoreTable = Array(1001) { 0 }
    val arr = Array(n) { Subject(0, 0) }
    for (i in 0 until n) {
        val (d, w) = readLine().split(" ").map { it.toInt() }

        arr[i] = arr[i].copy(date = d, score = w)
    }
    arr.sortByDescending { it.score }

    for (subject in arr) {
        if (scoreTable[subject.date - 1] == 0) {
            // 이미 큰 가격순ㄴ으로 정렬이 되어있으니까, 0 이라면 무조건 초기화
            scoreTable[subject.date - 1 ] = subject.score
        } else {
            var index = subject.date - 1
            while (index >= 0) {
                if (scoreTable[index] == 0) {
                    // 비어있는 곳에 넣어준다
                    scoreTable[index] = subject.score
                    break
                }
                index--
            }
        }
    }
    println(scoreTable.sum())
}
/*
과제들을 순서대로 순회하며

(4 60) - 4일차에 60점을 획득한다.
(2 50) - 2일차에 50점을 획득한다.
(4 40) - 4일차에 이미 60점을 얻었으므로 3일차에 40점을 획득한다.
(3 30) - 3일차와 2일차에 이미 점수를 얻었으므로 1일차에 30점을 획득한다.
(1 20) - 1일차에 30점을 얻었으므로 무시한다.
(4 10) - 1~4일차 모두 점수가 있으므로 무시한다.
(6 5) - 6일차에 5점을 획득한다.


 */
