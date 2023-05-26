package leetcode.LongestConsecutiveSequence

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
    val nums = intArrayOf(9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6)
    println(sol.longestConsecutive(nums))
}

/*
가장 긴 연속 시퀀스

정수 nums의 정렬되지 않은 배열이 주어지면 가장 긴 연속 요소 시퀀스의 길이를 반환합니다.

O(n) 시간에 실행되는 알고리즘을 작성해야 합니다.
 */
class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val sortedNums = nums.sortedBy { it } // Nlogn
        // val stack = Stack<Int>()
        val list = arrayListOf<Int>()
        var max = Integer.MIN_VALUE
        if (nums.isEmpty()) {
            return 0
        }
        /*
        최장 등차수열 구하기
         */
        list.add(sortedNums[0])
        // stack.add(sortedNums[0])
        for (i in 1 until sortedNums.size) {
            if (list.isEmpty()) {
                list.add(sortedNums[i])
                // stack.add(sortedNums[i])
            } else {
                if (list[i-1] == sortedNums[i] - 1) {
                    list.add(sortedNums[i])
                } else if (list[i - 1] == sortedNums[i]) {
                    continue
                } else {
                    max = max.coerceAtLeast(list.size)
                    list.clear()
                    list.add(sortedNums[i])
                }

                // if (stack.peek() + 1 == sortedNums[i]) {
                //     stack.add(sortedNums[i])
                // } else if (
                //     stack.peek() == sortedNums[i]) {
                //     continue
                // } else {
                //     max = max.coerceAtLeast(stack.size)
                //     stack.clear()
                //     stack.add(sortedNums[i])
                // }
            }
        }
        if (list.isNotEmpty()) {
            max = max.coerceAtLeast(list.size)
        }
        return max
    }
}
