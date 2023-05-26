package leetcode.ContainerWithMostWater

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
    val height = intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)
    println(sol.maxArea(height))
}

/*
포인터 i,j를 놓은 다음 이보다 더 큰 넓이를 찾아가라.
넓이를 구하는게 가로 * 세로인데
가로는 index의 차이이고, 세로는 선택한 두개중에 높이가 낮은것.
양끝의 선에서 시작하여 안쪽으로 이동하면 너비가 계속 작아지기 때문에 높이가 증가할 때 영역이 더 커질 수 있다.

 */

class Solution {
    fun maxArea(height: IntArray): Int {
        var result = 0
        var leftIndex = 0
        var rightIndex = height.size - 1

        while (leftIndex < rightIndex) {
            var area = 0
            if (height[leftIndex] <= height[rightIndex]) {
                area = height[leftIndex] * (rightIndex - leftIndex)
                leftIndex++
            } else {
                area = height[rightIndex] * (rightIndex - leftIndex)
                rightIndex--
            }
            result = result.coerceAtLeast(area)
        }

        return result
    }
}
