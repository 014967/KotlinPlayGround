package programmers.`로또의 최고 순위와 최저 순위`

import baekjoon.solution1744.zeroCount

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
    val solution = Solution()
    val lottos = intArrayOf(0, 0, 0, 0, 0, 0) // intArrayOf(44, 1, 0, 0, 31, 25)
    val wine_nums = intArrayOf(38, 19, 20, 6, 19) // intArrayOf(31, 10, 45, 1, 6, 19)
    println(solution.solution(lottos, wine_nums))
}

class Solution {
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        var answer: IntArray = intArrayOf()

        lottos.sort()
        win_nums.sort()

        var zeroCount = 0
        var minCount = 0
        lottos.forEach {
            if (win_nums.indexOf(it) != -1) {
                // 존재한다는 것.
                minCount++
            }
            if (it == 0) {
                zeroCount++
            }
        }

        answer = intArrayOf(getMin(minCount + zeroCount), getMin(minCount))

        return answer
    }

    fun getMin(count: Int): Int {
        return when (count) {
            2 -> 5
            3 -> 4
            4 -> 3
            5 -> 2
            6 -> 1
            else -> 6
        }
    }
}

/*
44, 1, 0, 0, 31, 25
31, 10, 45, 1, 6, 19

31,1 두개가 겹치네 그렇다면 최소 2고
최소 2개를 맞추고 최대 4개를 맞춘다 -> [3,5]겠다
1등은 6개
2등은 5개
3등은 4개
4등은 3개
5등은 2개
6등은 그외

 */
/*
민우의 동생이 로또에 낙서를 내서, 일부번호를 알아볼수가 없다
당첨 번호 발표후 , 민우는 자신이 구매했던 로또로 당첨이 가능했던
최고 순위와 최저순위를 알아보고 싶다

알아보고 싶은 번호를 0으로 표기하고
순서에 상관없이 일치하는 번호가 있으면 맞힌ㄱ ㅓㅅ.

 */
