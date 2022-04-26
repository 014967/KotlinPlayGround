package programmers.solution

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
    val s = "one4seveneight"
    val solution = Solution4()
    println(solution.solution(s))
}

class Solution4 {
    fun solution(s: String): Int {
        var answer = StringBuilder()

        var map = HashMap<String, Int>()
        map["zero"] = 0
        map["one"] = 1
        map["two"] = 2
        map["three"] = 3
        map["four"] = 4
        map["five"] = 5
        map["six"] = 6
        map["seven"] = 7
        map["eight"] = 8
        map["nine"] = 9

        var str = StringBuilder()
        for (i in s) {

            if (!i.isDigit()) {
                str.append(i)
            } else {
                answer.append(Character.getNumericValue(i))
            }
            if (map.containsKey(str.toString())) {
                answer.append(map[str.toString()])
                str.clear()
            }
        }

        return answer.toString().toInt()
    }
}
