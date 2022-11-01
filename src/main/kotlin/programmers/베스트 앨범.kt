package programmers

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

fun main() {
    val genres = arrayOf("classic", "pop", "classic", "classic", "pop")
    val plays = intArrayOf(500, 600, 150, 800, 2500)
    val solution = Solution()
    println(solution.solution(genres, plays))
}

class Solution {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        var answer = intArrayOf()

        for (i in genres.indices) {
            println(genres[i]) // classic , pop ,~~
        }
        val s = genres.indices.groupBy { genres[it] }
            .toList() .sortedByDescending {
                it.second.sumOf { plays[it] }
            } .map {
                it.second.sortedByDescending { plays[it] }.take(2)
            } .flatten()
            .toIntArray()
        // collection 함수
        answer = s
        return answer
    }
}
/*
장르별로 가장 많이 재생된 노래를 두개를 모아서 베스트 앨범을 출시
노래는 고유 번호로 구분하며, 노래를 수록하는 기준이 있다
1. 속한 노래가 많이 재생된 장르를 먼저 수롯
2. 장르 내에서 많이 재생된 노래를 먼저 수록
3. 장르 내에서 재생횟수가 같은 노래중에서는 고유 번호가 낮은 노래를 먼저

 */
