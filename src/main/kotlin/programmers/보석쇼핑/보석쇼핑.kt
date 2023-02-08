package programmers.보석쇼핑

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
    val gems = listOf(
        arrayOf(
            "DIA",
            "RUBY",
            "RUBY",
            "DIA",
            "DIA",
            "EMERALD",
            "SAPPHIRE",
            "DIA"
        ),
        arrayOf(
            "AA",
            "AB",
            "AC",
            "AA",
            "AC"
        ),
        arrayOf(
            "ZZZ",
            "YYY",
            "NNNN",
            "YYY",
            "BBB"
        ),
        arrayOf("KKK", "KKK", "NNN", "SSS", "NNN", "DIA", "RUBY")
    )
    val solution = Solution()
    gems.forEach {
        println(solution.solution(it).joinToString { it.toString() })
    }
}

data class ResultIndex(
    val startIndex: Int,
    val endIndex: Int

)

class Solution {
    fun solution(gems: Array<String>): IntArray {
        var answer = intArrayOf()
        val gemSet = gems.distinct() // 우리가 포함해야하는 보석 배열

        var startIndex = gemSet.size // 최소
        var endIndex = gems.size // 최대

        while (startIndex <= endIndex) {
            val mid = (startIndex + endIndex) / 2
            val range = getRange(gemSet, gems, mid)
            if (range == null) {
                // 범위에서 찾을 수 없는 경우
                startIndex = mid + 1 // 윈도우의 범위를 더 늘림
            } else {
                answer = intArrayOf(range.startIndex, range.endIndex)
                endIndex = mid - 1
            }
        }

        return answer
    }

    private fun getRange(gemSet: List<String>, gems: Array<String>, rangeLength: Int): ResultIndex? {
        // rangeLength == 윈도우 길이

        val countMap = HashMap<String, Int>()
        var countInRange = 0
        var start = 0
        var end = 0
        while (end < gems.size) {
            val addedGem = gems[end++] // 맨 처음에는 start와 같음
            countMap[addedGem] = countMap.getOrDefault(addedGem, 0) + 1
            if (countMap[addedGem]!! == 1) {
                // 처음 추가된 것
                countInRange++
            }

            if (end - start < rangeLength) continue

            if (countInRange == gemSet.size) {
                return ResultIndex(start + 1, end)
            }

            val removedGem = gems[start++] // 맨처음 0
            countMap[removedGem] = countMap[removedGem]!! - 1
            if (countMap[removedGem]!! == 0) {
                // 제거가 되었다면
                countInRange--
            }
        }
        return null
    }
}
/*
        for (i in gemSet.size..gems.size) {
            var count = 0
            if (flag) {
                break
            }
            run {
                gems.toList().windowed(i).forEach { windowedList ->
                    count++
                    val gemCheck = BooleanArray(gemSet.size) { false }
                    if (checkArray(gemCheck, gemSet, windowedList)) {
                        startIndex = count
                        lastIndex = count + i - 1
                        flag = true
                        answer = intArrayOf(startIndex, lastIndex)
                        return@run
                    }
                }
            }
        }
 */
/*
while (low <= high) {
            var flag = false
            val mid = (low + high) / 2
            var count = 0

            run {
                gems.toList().windowed(mid).forEach { windowedList ->
                    count++
                    val gemCheck = BooleanArray(gemSet.size) { false }
                    if (checkArray(gemCheck, gemSet, windowedList)) {
                        startIndex = count
                        lastIndex = count + mid - 1
                        flag = true
                        answer = intArrayOf(startIndex, lastIndex)
                        return@run
                    }
                }
            }
            if (flag) {
                high = mid - 1
            } else {
                low = mid + 1
            }
        }
 */
