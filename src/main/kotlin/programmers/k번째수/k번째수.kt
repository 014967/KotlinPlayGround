package programmers.k번째수

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
    val array = intArrayOf(1, 5, 2, 6, 3, 7, 4)
    val commands = arrayOf(intArrayOf(2, 5, 3), intArrayOf(4, 4, 1), intArrayOf(1, 7, 3))
    println(solution.solution(array, commands))
}

class Solution {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        var answer = intArrayOf()
        val list = arrayListOf<Int>()
        for (i in commands) {
            val sliceStart = i[0]
            val sliceEnd = i[1]
            val index = i[2]
            val s = array.slice(sliceStart -1 until sliceEnd).sorted()

            list.add(s[index - 1])
        }
        answer = list.toIntArray()
        return answer
    }
}
