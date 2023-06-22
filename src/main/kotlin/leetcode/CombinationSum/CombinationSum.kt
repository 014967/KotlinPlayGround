package leetcode.CombinationSum

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
    val sol = Solution()
    val candidates = intArrayOf(2, 3, 6, 7)
    val target = 7
    println(sol.combinationSum(candidates, target))
}

class Solution {

    val result = arrayListOf<List<Int>>()
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        getSum(candidates, index = 0, target = target, currentCandidate = arrayListOf())

        return result.toList()
    }

    fun getSum(candidates: IntArray, index: Int, currentCandidate: ArrayList<Int>, target: Int) {
        val sum = currentCandidate.sum()
        if (sum > target) {
            return
        }

        if (sum == target) {
            result.add(currentCandidate)
        }
        for (i in index until candidates.size) {
            val newList = ArrayList(currentCandidate)
            newList.add(candidates[i])
            getSum(candidates, i, newList, target)
        }
    }
}
