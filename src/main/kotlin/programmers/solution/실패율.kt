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
    val n = 4
    val stages = intArrayOf(4, 4, 4, 4, 4) // intArrayOf(2, 1, 2, 6, 2, 4, 3, 3)
    val solution = Solution11()
    println(solution.solution(n, stages))
}

class Solution11 {
    fun solution(N: Int, stages: IntArray): IntArray {
        val answer = DoubleArray(N + 1) { 0.toDouble() }
        val resultArr = arrayListOf<Int>()
        var list = mutableListOf<Pair<Int, Double>>()
        for (i in 1..N) {
            var stopCount = 0.toDouble()
            var successCount = 0.toDouble()
            for (j in stages) {

                if (i < j) {
                    successCount++
                } else {
                    if (i == j) {
                        stopCount++
                    }
                }
            }
            if (successCount + stopCount == 0.toDouble())
                answer[i] = 0.toDouble()
            else
                answer[i] = stopCount / (successCount + stopCount)
        }
        for (i in answer.indices) {
            if (i != 0) {
                list.add(Pair(i, answer[i]))
            }
        }
        list = list.sortedByDescending { it.second }.toMutableList()

        for (i in list) {
            if (i.first != 0)
                resultArr.add(i.first)
        }
        return resultArr.toIntArray()
    }
}
