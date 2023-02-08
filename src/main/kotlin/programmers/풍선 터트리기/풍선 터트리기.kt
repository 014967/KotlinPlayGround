package programmers.`풍선 터트리기`

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
    val aList = listOf(
        intArrayOf(9, -1, -5),
        intArrayOf(-16, 27, 65, -2, 58, -92, -71, -68, -61, -33)
    )
    val solution = Solution()
    aList.forEach {
        println(solution.solution(it))
    }
}

class Solution {
    fun solution(a: IntArray): Int {
        var answer: Int = 0
        return answer
    }
}
/*
일렬로 나열된 n개의 풍선이 있습니다. 모든 풍선에는 서로 다른 숫자가 써져 있습니다.
규칙
1. 인접한 두 풍선을 고른뒤, 두풍선중 하나를 터뜨립니다.
2. 터진 풍선으로 인해 풍선들 사이에 빈 공간이 생겼다면, 빈공간이 없도록 중앙으로 밀착 -> queue나 stack을 사용

인접한 두 풍선 중에서 번호가 더 작은 풍선을 터트리는 행위는 최대 1번.
일렬로 나열된 풍선들의 번호가 담긴 배열 a가 주어질때,
1개만 남을 때까지 터트렸을때 최후까지 남기는 것이 가능한 풍선들의 갯수를 반환


 */
