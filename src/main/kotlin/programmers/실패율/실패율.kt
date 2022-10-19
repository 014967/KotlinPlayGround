package programmers.실패율

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
    solution.solution(5, intArrayOf(2, 1, 2, 6, 2, 4, 3, 3)).forEach {
        println(it)
    }
}

class Solution {
    fun solution(N: Int, stages: IntArray): IntArray {
        var answer = IntArray(N) { 0 }
        val arr = Array(N + 1) { 0 }
        var person = stages.size

        var lastClearCount = 0

        val list = mutableListOf<Pair<Float, Int>>()

        for (i in stages.indices) {
            val currentStage = stages[i]
            if (currentStage != N + 1)
                arr[currentStage] += 1
            else
                lastClearCount++
        }

        for (i in 1 until arr.size) {
            var cal = Pair<Float, Int>(0f, 0)
            val challenge = arr[i] // 도전
            if (challenge == 0 && person != 0) {
                cal = Pair(0f, i)
            }
            if (challenge != 0) {
                if (person == 0) {
                    cal = Pair(0f, i)
                } else {
                    val s = challenge.toFloat() / person.toFloat()
                    cal = Pair(s, i)
                }
            }
            list.add(cal)

            person -= challenge
        }
        list.sortWith(
            compareBy<Pair<Float, Int>> { it.first }.reversed().thenComparator { a, b -> a.second - b.second }
        )
        list.mapIndexed { index, pair ->
            answer[index] = pair.second
        }
        return answer
    }
}
