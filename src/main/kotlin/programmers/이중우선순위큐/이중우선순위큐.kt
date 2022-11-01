package programmers.이중우선순위큐

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
    val operations = arrayOf("I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333")
    val solution = Solution()
    println(solution.solution(operations))
}

class Solution {
    fun solution(operations: Array<String>): IntArray {
        var answer = intArrayOf()
        val MaxQueue = PriorityQueue<Int>(compareByDescending { it })
        val MinQueue = PriorityQueue<Int>(compareBy { it })
        operations.forEach {
            val s = it.split(" ")
            when (s[0]) {
                "I" -> {
                    MaxQueue.offer(s[1].toInt())
                    MinQueue.offer(s[1].toInt())
                }
                else -> {
                    when (s[1]) {
                        "1" -> {
                            if (MaxQueue.isNotEmpty()) {
                                val max = MaxQueue.poll()
                                if (MinQueue.isNotEmpty()) {
                                    MinQueue.remove(max)
                                }
                            }
                        }
                        "-1" -> {
                            if (MinQueue.isNotEmpty()) {
                                val min = MinQueue.poll()
                                if (MaxQueue.isNotEmpty()) {
                                    MaxQueue.remove(min)
                                }
                            }
                        }
                    }
                }
            }
        }
        if (MaxQueue.isEmpty() && MinQueue.isEmpty()) {
            answer = intArrayOf(0, 0)
        } else {
            answer = intArrayOf(MaxQueue.poll(), MinQueue.poll())
        }
        return answer
    }
}
/*
명령어	수신 탑(높이)
I 숫자	큐에 주어진 숫자를 삽입합니다.
D 1	큐에서 최댓값을 삭제합니다.
D -1	큐에서 최솟값을 삭제합니다.
 */
