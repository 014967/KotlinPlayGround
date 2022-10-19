package programmers.`문자열 압축`

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
    val strList = listOf("a", "abced", "aabbaccc", "ababcdcdababcdcd", "abcabcdede", "abcabcabcabcdededededede", "xababcdcdababcdcd")
    val solution = Solution()
    for (i in strList) {
        println(solution.solution(i))
    }
}

class Solution {
    fun solution(s: String): Int {
        var answer = Integer.MAX_VALUE
        val queue = LinkedList<String>()
        if (s.length == 1) {
            answer = 1
        } else {
            for (i in 1..(s.length / 2)) {
                var count = 1
                s.chunked(i).map {
                    var k = StringBuilder()

                    k.append(it)

                    if (queue.isEmpty()) {
                        queue.offer(k.toString())
                    } else {
                        val top = queue.peekLast()
                        if (top == k.toString()) {
                            count++
                        } else {

                            val temp = queue.pollLast()
                            if (count != 1)
                                queue.offerLast(count.toString())
                            queue.offerLast(temp)
                            count = 1
                            queue.offerLast(k.toString())
                        }
                    }
                }
                if (count != 1) {
                    val temp = queue.pollLast()
                    queue.offerLast(count.toString())
                    queue.offerLast(temp)
                }
                answer = answer.coerceAtMost(queue.joinToString("").length)
                queue.clear()
            }
        }

        return answer
    }
}

/*
aabbaccc -> 2a 2b a 3c
1은 생략

abcabcdede
문자열을 1개 이상의 단위로 잘라서 압축하여 더 짧은 문자열로 표현할 수 있는 방법 찾기

ababcdcdababcdcd 문자를 1개 단위로 자르면 압축이 되지 않지만,
2개 단위로 잘라서 압축한다면 2ab2cd2ab2cd로 표현이 간으하다
다른 방법으로 8개 단위로 잘라서 압축한다면 2ababcdcd로 표현이 가능하다
가장 짧게 압축하는 방법은

s의 길이는 1이상 1000이하
소문자로만 이뤄짐

문자열은 제일 앞부터 정해진 길이만큼 짤라야함,
 */
