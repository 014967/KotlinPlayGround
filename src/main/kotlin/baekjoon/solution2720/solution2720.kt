package baekjoon.solution2720

import java.io.BufferedReader
import java.io.InputStreamReader

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

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val T = readLine().toInt() // 입력받을 테스트 케이스

    val list = mutableListOf<Int>()
    for (i in 1..T) { // 1부터 T까지
        list.add(readLine().toInt())
    }

    var count = 0
    while (true) {
        val table = HashMap<Int, Int>().toSortedMap(reverseOrder())
        table[25] = 0
        table[10] = 0
        table[5] = 0
        table[1] = 0
        if (count >= list.size)
            break
        var case = list[count]
        for (j in table) {
            if (case / j.key > 0) {
                table[j.key] = case / j.key
                case %= j.key
            }
        }
        count++

        table.toList().forEachIndexed { index, pair ->
            // println(pair)
            print(pair.second)
            if (index != 3) {
                print(" ")
            } else {
                println()
            }
        }
    }
}
