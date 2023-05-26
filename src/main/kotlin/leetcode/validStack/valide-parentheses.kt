package leetcode.validStack

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
 println( sol.isValid("(("))
}

class Solution {
    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        var result = true

        for (i in s) {
            if (!result) break
            if (i in listOf('(', '{', '[')) {
                stack.add(i)
            } else {
                if (stack.isNotEmpty()) {
                    when (i) {
                        ')' -> {
                            if (stack.peek() == '(') {
                                stack.pop()
                            } else {
                                result = false
                            }
                        }
                        '}' -> {
                            if (stack.peek() == '{') {
                                stack.pop()
                            } else {
                                result = false
                            }
                        }
                        ']' -> {
                            if (stack.peek() == '[') {
                                stack.pop()
                            } else {
                                result = false
                            }
                        }
                    }
                }
            }
        }
     if(stack.isNotEmpty()){
      result = false
     }
        return result
    }
}
