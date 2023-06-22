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
    val candidates = intArrayOf(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1)
    val target = 30
    val sol = Solution()

    println(sol.combinationSum2(candidates, target))
}
class Solution {
    lateinit var result: MutableSet<ArrayList<Int>>
    lateinit var checker: BooleanArray
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        checker = BooleanArray(51) { false }
        val sortedCandidates = candidates.sortedArray()
        result = mutableSetOf()

        for (i in sortedCandidates.indices) {
            if (checker[sortedCandidates[i]]) {
                continue
            }
            checker[sortedCandidates[i]] = true
            getComb(sortedCandidates, target, arrayListOf(sortedCandidates[i]), i + 1)
        }

        return result.toList()
    }
    fun getComb(candidates: IntArray, target: Int, currentList: ArrayList<Int>, index: Int) {
        val sum = currentList.sum()

        if (sum > target) {
            return
        }

        if (sum == target) {
            result.add(currentList)
        }

        for (i in index until candidates.size) {
            val temp = ArrayList(currentList)
            temp.add(candidates[i])
            getComb(candidates, target, temp, i + 1)
        }
    }
}
