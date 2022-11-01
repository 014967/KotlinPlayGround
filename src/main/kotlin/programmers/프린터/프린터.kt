package programmers.프린터

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
    val priorities = intArrayOf(2, 1, 3, 2)//intArrayOf(1, 1, 9, 1, 1, 1) //
    val location = 2
    val solution = Solution()
    println(solution.solution(priorities, location))
}
class Solution {
    fun solution(priorities: IntArray, location: Int): Int {
        var answer = 0

        val arr = priorities.mapIndexed { index, i ->
            Pair(index, i)
        }
        val list = LinkedList(arr)
        var count = 1
        while (true) {
            val current = list.peek()
            if (!list.filter {
                it != current
            }.none {
                    it.second > current.second
                }
            ) {
                list.offer(list.poll())
            } else {
                if (list.peek().first == location) {
                    break
                }
                count++
                list.poll()
            }
        }
        answer = count
        return answer
    }
}

/*
인쇄 요청이 들어온 순서대로 인쇄.
중요도가 높은 문서를 먼저 인쇄하는 프린터를 개발.

1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
3. 그렇지 않으면 J를 인쇄합니다.

priorities : 중요도
내가 요청한 문서가 현재 대기목록의 어떤 위치에 있는지 알려주는 location
location이 맨 처음 문서가 위치하는 인덱스
 */
