package leetcode.LongestSubStringWithOutRepeatingCharacters

import java.util.*
import kotlin.math.max

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
    println(sol.lengthOfLongestSubstring("pwwkew"))
}
class Solution {
    /*
    반복없이 가장 긴 subString을 구해라
    subString은 하위 문자열, 문자열 내에서 비어있지 않은 연속적인 문자 시퀸스
    주어진 문자열에서 알파벳이 중복되지 않고 가장 길게 연속되는 문자열 일부를 반환하라.
    문자열 길이가 5만
     */
    fun lengthOfLongestSubstring(s: String): Int {
        var maxLength = 0
        val queue = LinkedList<Char>()
        for (i in s.indices) {
            if (queue.isNotEmpty()) {
                when {
                    queue.first == s[i] -> queue.poll()
                    queue.last == s[i] -> queue.clear()
                    queue.contains(s[i]) -> {
                        while (queue.isNotEmpty()) {
                            if (queue.poll() == s[i]) break
                        }
                    }
                }
            }

            maxLength = max(maxLength, queue.size+1)
            queue.offer(s[i])
        }

        return maxLength
    }
}