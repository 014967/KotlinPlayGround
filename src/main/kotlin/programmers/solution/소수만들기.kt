package programmers.solution

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
    val nums = intArrayOf(1, 2, 7, 6, 4)
    val solution = Solution8()
    println(solution.solution(nums))
}

class Solution8 {
    fun solution(nums: IntArray): Int {
        var answer = mutableListOf <Int>()
        val visited = Array(nums.size) { false }

        combination(answer, nums.toList(), visited, 0, 3)

        return answer.size
    }
    fun combination(
        answer: MutableList<Int>, // 조합의 결과를 저장하는 리스트 , 이중 리스트도 가능
        el: List<Int>, // 조합을 구할 원소들의 집합
        ck: Array<Boolean>, // 원소 선택 여부를 확인하기 위한 배열
        start: Int, // 탐색 시작 인덱스
        target: Int // 구할 조합의 원소 갯수
    ) {
        if (target == 0) {
            val sum = el.filterIndexed { index, t -> ck[index] }
                .sum()
            if (isPrime(sum)) {
                answer.add(sum)
            }
        } else {
            for (i in start until el.size) {
                ck[i] = true
                combination(answer, el, ck, i + 1, target - 1)
                ck[i] = false
            }
        }
    }

    fun isPrime(sum: Int): Boolean {
        var i = 2
        while (i * i <= sum) {
            if (sum % i++ == 0)
                return false
        }
        return true
    }
}
