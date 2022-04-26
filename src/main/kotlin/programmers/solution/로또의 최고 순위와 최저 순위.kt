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
    val solution = Solution2()
    val lottos = intArrayOf(44, 1, 0, 0, 31, 25)
    val win_nums = intArrayOf(31, 10, 45, 1, 6, 19)
    println(solution.solution(lottos, win_nums))
}

class Solution2 {
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        require(lottos.size == 6)

        var answer: IntArray = IntArray(2) { 0 }
        var table = Array(7) { 0 }
        table[0] = 6
        table[1] = 6
        table[2] = 5
        table[3] = 4
        table[4] = 3
        table[5] = 2
        table[6] = 1

        var sameCount = 0
        var zeroCount = 0
        for (i in lottos) {
            if (win_nums.indexOf(i) != -1) {
                sameCount += 1
            }
            if (i == 0) {
                zeroCount += 1
            }
        }
        answer[1] = table[sameCount]
        answer[0] = table[sameCount + zeroCount]

        return answer
    }
}
