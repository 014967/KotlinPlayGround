package leetcode.ProductOfArrayExceptSelf

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
//    val nums = intArrayOf(0, 4, 0)
    val nums = intArrayOf(1, 2, 3, 4)
//    val nums = intArrayOf(-1, 1, 0, -3, 3)
    val result = sol.solution(nums)
    println(result.joinToString { it.toString() })
}

/*
나누기 연산을 하지 않고 현재 값을 제외한 나머지의 곱을 얻는 과정을 출력
근데 O(n)을 소모해야함.
 */
class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val result = IntArray(nums.size) { 0 }
        val zeroCount = nums.count { it == 0 }
        if (zeroCount >= 2) {
            return result
        }
        val product = nums.fold(1) {
                acc: Int, i: Int ->
            if (i == 0) {
                acc * 1
            } else {
                acc * i
            }
        }
        if (zeroCount == 1) {
            val index = nums.indexOf(0)
            result[index] = product
            return result
        }

        for (i in nums.indices) {
            result[i] = product / nums[i]
        }
        return result
    }
    fun solution(nums: IntArray): IntArray {
        val ans = IntArray(nums.size)
        var n = 1
        for (i in 0..nums.size - 1) {
            ans[i] = n
            n *= nums[i]
        }
        n = 1
        for (i in nums.size - 1 downTo 0) {
            ans[i] = n * ans[i]
            n *= nums[i]
        }

        return ans
    }
}
