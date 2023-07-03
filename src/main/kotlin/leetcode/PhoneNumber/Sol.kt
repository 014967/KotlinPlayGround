package leetcode.PhoneNumber

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

    println(sol.letterCombinations("23"))
}

class Solution {
    val digitMap = HashMap<Int, List<Char>>().apply {
        this[2] = listOf('a', 'b', 'c')
        this[3] = listOf('d', 'e', 'f')
        this[4] = listOf('g', 'h', 'i')
        this[5] = listOf('j', 'k', 'l')
        this[6] = listOf('m', 'n', 'o')
        this[7] = listOf('p', 'q', 'r', 's')
        this[8] = listOf('t', 'u', 'v')
        this[9] = listOf('w', 'x', 'y', 'z')
    }

    var result = arrayListOf<String>()

    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) {
            return result
        }

        getCombination(digits, 0, StringBuilder())
        return result
    }

    fun getCombination(digits: String, index: Int, temp: StringBuilder) {
        if (index >= digits.length) {
            result.add(temp.toString())
            return
        }
        val mapList = digitMap[Character.getNumericValue(digits[index])]!!

        for (j in mapList.indices) {
            val newTemp = StringBuilder(temp).append(mapList[j])
            getCombination(digits, index + 1, newTemp)
        }
    }
}
