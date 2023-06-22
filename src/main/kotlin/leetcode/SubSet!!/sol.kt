package leetcode.`SubSet!!`

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
    val nums = intArrayOf(1, 2, 2)
    val sol = Solution()
    println(sol.subsetsWithDup(nums))
}
class Solution {

    lateinit var check: BooleanArray
    lateinit var result: MutableSet<ArrayList<Int>>

    var maxDepth = 0
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        result = mutableSetOf(arrayListOf())
        maxDepth = nums.size
        getSubSet(nums.sortedArray(),0, arrayListOf())
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
