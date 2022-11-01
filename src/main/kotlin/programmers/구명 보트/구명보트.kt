package programmers.`구명 보트`

import java.util.*

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
    val case = listOf(listOf(intArrayOf(70, 50, 80, 50), 100), listOf(intArrayOf(70, 80, 50), 100))
    case.forEach { println(solution.solution(it[0] as IntArray, it[1] as Int)) }
}

class Solution {
    fun solution(people: IntArray, limit: Int): Int {
        people.sort()
        val peopleStack = LinkedList<Int>(people.toList())

        var count = 0
        while (peopleStack.isNotEmpty()) {
            if (peopleStack.size == 1) {
                peopleStack.poll()
                count++
            } else {
                val front = peopleStack.peekFirst()
                val back = peopleStack.peekLast()
                if (front + back <= limit) {
                    peopleStack.pollFirst()
                    peopleStack.pollLast()
                    count++
                } else {
                    peopleStack.pollLast()
                    count++
                }
            }
        }

        return count
    }
}

/*
구명 보트는 작아서 한번에 최대 2명씩 밖에 탈수 없고, 무게 제한도 있다.
구명보트를 최대한 적게 사용해서 모든 사람을 구출하려고한다.
구명보트 무게 제한 40 <= 240

구명보트는 최대 2명밖에 탈 수 없다.
어차피 구명밖에 탈수가 없다면 꽉 채워서 탈수만 있다면 좋은 거잖아.
10 10 몸무게가 적게 나가는 사람들도 채우는 것은 별로고
몸무게가 많이 나가는 사람과 적게 나가는 사람을 조합해서 태우는게 너무 좋을 꺼같은데


 */
