package leetcode.LongestPalindromicSubstring

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
    val sol = Solution()
    for (i in listOf("abcda")) {
        println(sol.longestPalindrome(i))
    }
}
class Solution {
    var result = ""
    fun longestPalindrome(s: String): String {
        result = ""

        for (index in 1 until s.length - 1) {
            if (s[index - 1] == s[index + 1]) {
                // index를 사이에 두고서 3개를 확인했을때 , 양쪽이 같기때문에 ㅇㅇ
                check(s, index)
            }
        }

        for (index in 0 until s.length - 1) {
            if (s[index] == s[index + 1]) {
                checkTwo(s, index)
            }
        }

        if (result.isEmpty()) {
            result = s[0].toString()
        }
        return result
    }
    fun checkTwo(s: String, index: Int) {
        var left = index - 1
        var right = index + 2

        val list = LinkedList<Char>()
        list.add(s[index])
        list.add(s[index + 1])
        while (true) {
            if (left < 0 || right > s.length - 1) {
                break
            }
            if (s[left] == s[right]) {
                list.addFirst(s[left])
                list.addLast(s[right])
            } else {
                break
            }
            left--
            right++
        }
        val listStr = list.joinToString("") { it.toString() }
        if (result.length < listStr.length) {
            result = listStr
        }
    }

    fun check(s: String, index: Int) {
        var left = index - 1
        var right = index + 1

        val list = LinkedList<Char>()

        list.add(s[index])
        while (true) {
            if (left < 0 || right > s.length - 1) {
                break
            }
            if (s[left] == s[right]) {
                list.addFirst(s[left])
                list.addLast(s[right])
            } else {
                break
            }
            left--
            right++
        }
        val listStr = list.joinToString("") { it.toString() }
        if (result.length < listStr.length) {
            result = listStr
        }
    }
}
