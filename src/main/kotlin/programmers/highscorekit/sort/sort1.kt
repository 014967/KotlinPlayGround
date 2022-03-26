package programmers.highscorekit.sort

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

    val array: IntArray = intArrayOf(1, 5, 2, 6, 3, 7, 4)
    val commands: Array<IntArray> = arrayOf(intArrayOf(2, 5, 3), intArrayOf(4, 4, 1), intArrayOf(1, 7, 3))
    println(solution(array, commands))
}
fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
    var answer = intArrayOf()

    val list = mutableListOf<Int>()
    for (i in commands) {
        val startIndex = i[0] - 1
        val endIndex = i[1]
        val getAfterSorted = i[2] - 1
        var s = array.toList().subList(startIndex, endIndex)
        s = s.sorted()
        list.add(s[getAfterSorted])
    }
    answer = list.toIntArray()
    return answer
}
