package leetcode.Permutations

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
    val nums = intArrayOf(1, 2, 3)
    val sol = Solution()

    println(sol.permute(nums))
}

class Solution {
    lateinit var check: BooleanArray
    lateinit var result: ArrayList<ArrayList<Int>>

    fun permute(nums: IntArray): List<List<Int>> {
        check = BooleanArray(nums.size) { false }
        result = arrayListOf()
        getPermute(nums, currentList = Array(nums.size) { 0 }, 0)
        return result
    }

    fun getPermute(nums: IntArray, currentList: Array<Int>, index: Int) {
        if (index == nums.size) {
            result.add(ArrayList(currentList.toList()))
        }

        for (i in nums.indices) {
            if (check[i]) {
                continue
            }
            check[i] = true
            val temp = currentList.copyOf()
            temp[index] = nums[i]
            getPermute(nums, temp, index + 1)
            check[i] = false
        }
    }
}
