package leetcode.`decode-ways`

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
    for (i in listOf("12", "226", "06")) {
        println(sol.numDecodings(i))
    }
}

class Solution {
    fun numDecodings(s: String): Int {
        if (s.startsWith("0")) {
            return 0
        }
        return 0
    }

    fun mapping(s: String): String {
        return when (s) {
            "1" -> "A"
            "2" -> "B"
            "3" -> "C"
            "4" -> "D"
            "5" -> "E"
            "6" -> "F"
            "7" -> "G"
            "8" -> "H"
            "9" -> "I"
            "10" -> "J"
            "11" -> "K"
            "12" -> "L"
            "13" -> "N"
            "14" -> "M"
            "15" -> "O"
            "16" -> "P"
            "17" -> "Q"
            "18" -> "R"
            "19" -> "S"
            "20" -> "T"
            "21" -> "U"
            "22" -> "V"
            "23" -> "W"
            "24" -> "X"
            "25" -> "Y"
            else -> "Z"
        }
    }
}
