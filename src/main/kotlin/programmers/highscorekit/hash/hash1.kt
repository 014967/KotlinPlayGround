package programmers.highscorekit

import kotlin.system.measureNanoTime

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
    val time = measureNanoTime {
        val parti = arrayOf("leo", "kiki", "eden")
        val compl = arrayOf("eden", "kiki")
        val result = solution(parti, compl)
        println(result)
    }
    println(time)
}

fun solution(participant: Array<String>, completion: Array<String>): String {
    var result = ""
    val map = HashMap<String, Int>()
    for (i in participant) {
        if (map.containsKey(i)) {
            val count = map[i]?.plus(1)
            if (count != null) {
                map[i] = count
            }
        } else {
            map[i] = 1
        }
    }
    val s = map - completion
    result = s.keys.first()
    return result
}
