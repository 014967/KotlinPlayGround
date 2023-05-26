package leetcode.FindMininumInRotatedSortedArray

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
    println(sol.findMin(intArrayOf(11,12,13,14)))
}
class Solution {
    fun findMin(nums: IntArray): Int {
        // 몇번을 이동했는지 파악할 수 있는 방법이 무엇인가요?
        // 정렬을 한 후에, rotated되었다.
        var result = Integer.MAX_VALUE

        var left = 0
        var right = nums.size - 1

        while (left < right) {
            val mid = (left + right) / 2
            val start = nums[left]
            val end = nums[right]

            val min = minOf(nums[mid], start, end)
            result = result.coerceAtMost(min)

            if (min == nums[mid] || min == start) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return result
    }
}
