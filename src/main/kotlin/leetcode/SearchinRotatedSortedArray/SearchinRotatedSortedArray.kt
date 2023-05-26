package leetcode.SearchinRotatedSortedArray

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
    println(sol.search(intArrayOf(8, 9, 2, 3, 4), 9))
}

class Solution {
    fun search(nums: IntArray, target: Int): Int {
        if (nums.size == 1) {
            if (nums[0] == target) {
                return 0
            } else {
                return -1
            }
        }
        if (nums.size == 2) {
            if (target in nums) {
                return nums.indexOf(target)
            } else {
                return -1
            }
        }

        var start = 0
        var end = nums.size - 1

        while (start <= end) {
            val midIndex = (start + end) / 2
            val midNums = nums[midIndex]

            if (midNums == target) {
                return midIndex
            }
            if (nums[start] == target) {
                return start
            }

            if (nums[end] == target) {
                return end
            }

            if (nums[start] <= nums[end]) {
                // 정렬이 되었다.
                if (nums[start] > target) {
                    return -1
                }
                if (midNums < target) {
                    // 오른쪽에 있다.
                    start = midIndex + 1
                } else {
                    // 왼쪽에 있다.
                    end = midIndex
                }
            } else {
                if (nums[end] < target && midNums < target) {
                    // 8 9 2 3 4 처리 에서 9찾기
                    // 4 5 6 7 8 1 2 3에서 8찾기
                    /*
                    위의 두가지 케이스가 midNums와 끝 숫자가 타켓보다 작다.
                     */
                    if (nums[end] > midNums) {
                        end = midIndex
                    } else {
                        start = midIndex + 1
                    }
                } else if (nums[end] < target && midNums > target) {
                    // 타켓이 왼쪽에 있음
                    end = midIndex
                } else if (nums[end] > target && midNums < target) {
                    // 타켓이 오른쪽에 있음
                    start = midIndex + 1
                } else if (nums[end] > target && midNums > target) {
                    /*

                   4, 5, 6, 7, 0, 1, 2 에서 0의 위치가
                   mid = 7
                   nums[end] = 2
                   target = 0

                   nums[end] 2 > target = true
                   midNums 7 > target = true

                   5, 1, 2, 3, 4 에서 1의 위치가


                   nums[end] =4
                   target =1
                   nums[end] 4 > 1 = true
                   midNums 2 > 1 = true

                   위의 두가지의 경우에서 각각의 target의 같은 조건에서 위치가 다르다.

                    */

                    if (midNums < nums[end]) {
                        end = midIndex
                    }
                    if (midNums > nums[end]) {
                        start = midIndex + 1
                    }
                }
            }
        }
        return -1
    }
}
