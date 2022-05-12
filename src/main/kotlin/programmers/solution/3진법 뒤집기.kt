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
    val n = 125
    val solution15 = Solution15()
    println(solution15.solution(n))
}

class Solution15 {
    fun solution(n: Int): Int {
        var answer: Int = 0
        var newN = n
        val str = StringBuilder()
        val answerStr = StringBuilder()
        while (newN / 3 != 0) {
            val value = newN % 3
            str.insert(0, value)
            newN /= 3
        }
        str.insert(0, newN % 3)
        for (i in (str.toString().length - 1) downTo 0) {
            answerStr.append(str[i])

        }
        var count = 0
        for (i in answerStr.toString().length - 1 downTo 0) {
            if (count == 0) {
                answer += 1 * answerStr[i].toString().toInt()
                count++
            } else {
                var target = 1
                for (j in 1..count) {
                    target *= 3
                }
                answer += target * answerStr[i].toString().toInt()
                count++
            }
        }
        return answer
    }
}
//1001
//1 + 0 + 0+ 8  9
//
//1 * 1 + 3 * 1 + 9 * 1 + 27 * 2 + 81 * 2
//        1 + 4 + 9 + 54 + 162