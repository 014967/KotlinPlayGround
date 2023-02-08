package baekjoon.`선 긋기`

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

data class Line(
    val start: Int,
    val end: Int
)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()

    val lineList = arrayListOf<Line>()
    for (i in 0 until N) {
        val (start, end) = readLine().split(" ").map { it.toInt() }
        lineList.add(Line(start, end))
    }

    var result = 0

    lineList.sortWith(
        comparator = Comparator<Line> { o1, o2 ->
            o1.start - o2.start
        }.thenComparing { o1, o2 -> o1.end - o2.end }
    )

    var currentLeftIndex = -1000000000
    var currentRightIndex = -1000000000
    for (i in lineList.indices) {
        if (currentRightIndex < lineList[i].start) {
            // 확인하고 있는 구간에 합칠 수 없는 경우
            result += currentRightIndex - currentLeftIndex
            currentLeftIndex = lineList[i].start
            currentRightIndex = lineList[i].end
        } else {
            // 합칠 수 있는 경우는 right만 아닐까 ?
            currentRightIndex = currentRightIndex.coerceAtLeast(lineList[i].end)
        }
    }
    result += currentRightIndex - currentLeftIndex
    println(result)
}
