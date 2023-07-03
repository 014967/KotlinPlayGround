package leetcode.CombinationSum2

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
    val candidates = intArrayOf(10, 1, 2, 7, 6, 1, 5)
    val target = 8
    val sol = Solution()

    println(sol.combinationSum2(candidates, target))
}
class Solution {
    lateinit var result: MutableSet<ArrayList<Int>>
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        val sortedCandidates = ArrayList(
            candidates.sortedArray().groupBy {
                it
            }.map {
                Pair(it.key, it.value.count())
            }
        )
        result = mutableSetOf()

        for (i in sortedCandidates.indices) {
            combination(sortedCandidates, i, arrayListOf(), target)
        }

        return result.toList()
    }

    fun combination(
        sortedCandidates: ArrayList<Pair<Int, Int>>,
        index: Int,
        temp: ArrayList<Int>,
        target: Int
    ) {
        val sum = temp.sum()
        if (sum == target) {
            result.add(ArrayList(temp))
            return
        }

        if (sum > target) {
            return
        }

        for (i in index until sortedCandidates.size) {
            val count = sortedCandidates[index].second
            if (count <= 0) {
                continue
            }
            val current = sortedCandidates[index].first
            sortedCandidates[index] = sortedCandidates[index].copy(second = count - 1)
            temp.add(current)
            combination(
                sortedCandidates,
                i,
                temp,
                target
            )
            val lastIndex = temp.size - 1
            temp.removeAt(lastIndex)
            sortedCandidates[index] = sortedCandidates[index].copy(second = count)
        }
    }
}