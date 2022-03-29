package programmers.highscorekit.bruteforce

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
    println(solution(8, 1).toList())
}
fun solution(brown: Int, yellow: Int): IntArray {
    var answer = intArrayOf()
    var root = brown + yellow
    var count = 1
    val list = mutableListOf<Pair<Int, Int>>()
    while (true) {
        if (root % count == 0) {
            // 나뉘어 떨어진다면
            val k = root / count
            if (k <count) {
                break
            } else {
                val pair = Pair(k, count)
                list.add(pair)
            }
        }
        count++
    }
    for (i in list) {
        val first = i.first - 2
        val second = i.second - 2

        if (first> 0 && second> 0 && first * second == yellow) {
            val arr = intArrayOf(i.first, i.second)
            answer = arr
            break
        }
    }
    return answer
}
