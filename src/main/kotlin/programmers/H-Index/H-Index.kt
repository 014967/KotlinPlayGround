package programmers.`H-Index`

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
    val citations = listOf(intArrayOf(3, 0, 6, 1, 5), intArrayOf(0, 1, 1))
    val solution = Solution()
    for (i in citations) {
        println(solution.solution(i))
    }
}

class Solution {
    fun solution(citations: IntArray): Int {
        var answer = 0
        var max = Integer.MIN_VALUE
        val s = citations.sorted()
        for (h in 0..10000) {
            val count = s.filter {
                it >= h // h번 이상 인용
            }.count()
            if (count >= h) {
                max = max.coerceAtLeast(h)
            }
        }
        answer = max
        return answer
    }
}
/*
h를 구하고자함

발표한 논문 n 중, h번 이상 인용된 논문이 h편이상이고 , 나머지 논문이 h번 이하 인용되었다면
h의 최댓삾이 h-index다

ex)
논문의 수가 5편, 그 중 3편의 논문은 3회이상 인용, 나머지 2편의 논문은 3회이하 인용

6편중 h(0)번 이상 인용된 논문이 0편이상이고 나머지가 0번 이하 인용되었다면 h
 */
