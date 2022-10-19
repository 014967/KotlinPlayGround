package programmers.체육복

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
    val solution = Solution()
    val k = listOf(listOf(5, intArrayOf(2, 4), intArrayOf(1, 3, 5)), listOf(5, intArrayOf(2, 4), intArrayOf(3)), listOf(7, intArrayOf(2,4,7), intArrayOf(1,3,5)))
    for (i in k.indices) {
        println(solution.solution(k[i][0] as Int, k[i][1] as IntArray, k[i][2] as IntArray))
    }
}

class Solution {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        var answer = 0
        lost.sort()
        reserve.sort() // 이게 없으면 통과를 하지를 못하네


        val person = Array(n + 1) { 1 }
        for (i in lost) {
            person[i]--
        }
        for (i in reserve) {
            person[i]++
        }
        for (i in reserve) {
            if (person[i] >= 2) { // 일단 여분의 옷을 가지고 있는 친구의 옷 갯수가 아직도 2개 이상인지 확인한다.
                if (i in 1..person.size) {
                    if (i == 1) {
                        if (person[i + 1] == 0) {
                            person[i]--
                            person[i + 1]++
                        }
                    } else if (i == person.size - 1) {
                        if (person[i - 1] == 0) {
                            person[i - 1]++
                            person[i]--
                        }
                    } else {
                        if (person[i - 1] == 0) {
                            person[i - 1]++
                            person[i]++
                        } else {
                            if (person[i + 1] == 0) {
                                person[i + 1]++
                                person[i]--
                            }
                        }
                    }
                }
            }
        }
        answer = person.drop(1).filter {
            it >= 1
        }.count()
        return answer
    }
}
/*

중요한건 여벌의 체육복을 가지고 있는 사람만 나눌 수 있다는 점!!

 */
