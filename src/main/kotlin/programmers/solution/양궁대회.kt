package programmers.solution

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
    val n = 5
    val info = intArrayOf(2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0)
    val solution19 = Solution19()
    println(solution19.solution(n, info))
}
class Solution19 {
    fun solution(n: Int, info: IntArray): IntArray {
        // n 화살의 갯수
        // info 어피치가 맞힌 과녁 점수의 갯수 10점부터 0점까지 순서 대로
        var answer: IntArray = intArrayOf()
        require(n in 1..10)

        return answer
    }
}
