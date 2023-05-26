package programmers.`개인정보 수집 유효기간`
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

    solution.solution(
        today = "2022.05.19",
        terms = arrayOf("A 6", "B 12", "C 3"),
        privacies = arrayOf("2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C")
    ).forEach {
        println(it)
    }
}

class Solution {
    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()

        val (t_yyyy, t_mm, t_dd) = today.split(".").map { it.toInt() }
        val termMap = HashMap<String, Int>()

        terms.forEach { term ->
            val (type, duration) = term.split(" ")
            require(duration.toInt() in 1..100)
            termMap[type] = duration.toInt()
        }

        val list = arrayListOf<Int>()
        for (i in privacies.indices) {
            val (date, type) = privacies[i].split(" ")
            val (p_yyyy, p_mm, p_dd) = date.split(".").map {
                it.toInt()
            }

            // 일단 유효기간을 더한 값을 찾는다
            if (!termMap.containsKey(type)) {
                continue
            }

            val p_duration = termMap[type]!! // 달의 단위
            val p_duration_yyyy = p_duration / 12
            val p_duration_mm = p_duration % 12

            var target_mm = p_duration_mm + p_mm
            val target_yyyy = if (target_mm > 12) {
                val newYYYY = target_mm / 12
                val newMM = target_mm % 12
                target_mm = newMM
                p_yyyy + newYYYY + p_duration_yyyy
            } else {
                p_yyyy + p_duration_yyyy
            }

            val date_today = t_yyyy * 12 * 28 + t_mm * 28 + t_dd
            val date_target = target_yyyy * 12 * 28 + target_mm * 28 + p_dd

            if (date_today >= date_target) {
                list.add(i + 1)
            }

            // 년도 비교
        }
        answer = list.toIntArray()
        return answer
    }
}
