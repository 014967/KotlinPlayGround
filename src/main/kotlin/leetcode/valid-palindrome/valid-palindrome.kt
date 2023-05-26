package leetcode.`valid-palindrome`

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
    println(sol.isPalindrome(".,"))
}

class Solution {
    fun isPalindrome(s: String): Boolean {
        var leftPointer = 0
        var rightPointer = s.length - 1

        if (s.isEmpty()) {
            return true
        }

        var flag = true
        while (leftPointer != rightPointer && leftPointer < rightPointer) {
            while (!s[leftPointer].toLowerCase().isLetterOrDigit()) {
                leftPointer++
                if (leftPointer >= s.length) {
                    flag = false
                    break
                }
            }
            while (!s[rightPointer].toLowerCase().isLetterOrDigit()) {
                rightPointer--
                if (rightPointer < 0) {
                    flag = false
                    break
                }
            }
            if(!flag){
                flag = true
                break
            }
            if (s[leftPointer].toLowerCase() != s[rightPointer].toLowerCase()) {
                flag = false
                break
            }
            leftPointer++
            rightPointer--
        }

        return flag
    }
}
