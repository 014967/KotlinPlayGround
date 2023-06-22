package leetcode.Subset

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
    val nums = intArrayOf(1, 2, 3)
    println(sol.subsets(nums))
}

class Solution {
    val result = arrayListOf<ArrayList<Int>>(arrayListOf<Int>())
    var maxDepth = 0
    fun subsets(nums: IntArray): List<List<Int>> {
        maxDepth = nums.size
        getSubSet(nums, 0, arrayListOf())

        return result.toList()
    }

    fun getSubSet(nums: IntArray, index: Int, currentList: ArrayList<Int>) {
        if (index >= maxDepth) {
            return
        }

        for (i in index until maxDepth) {
            val tempList = ArrayList(currentList)
            tempList.add(nums[i])
            result.add(tempList)
            getSubSet(nums, i + 1, tempList)
        }
    }
}
