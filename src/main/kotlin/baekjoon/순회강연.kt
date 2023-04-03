package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.system.exitProcess

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

data class DayWithPay(
    val d: Int,
    val p: Int
)
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()

    val seminar = Array(n) { DayWithPay(0, 0) }

    val queue = PriorityQueue<DayWithPay>(
        Comparator<DayWithPay> { o1, o2 -> o2.d - o1.d }.thenComparing { o1, o2 -> o2.p - o1.p }
    )

    if (n == 0) {
        println(0)
        exitProcess(0)
    }
    for (i in 0 until n) {
        val (p, d) = readLine().split(" ").map { it.toInt() }
        seminar[i] = seminar[i].copy(d = d, p = p)
    }
    seminar.sortWith(Comparator<DayWithPay> { o1, o2 -> o2.d - o1.d }.thenComparing { o1, o2 -> o2.p - o1.p })

    val table = Array(10001) { 0 }
    for (i in seminar) {
        val index = i.d
        if (table[index] == 0) {
            table[index] = i.p
        } else {
            queue.offer(i)
        }
    }

    while (queue.isNotEmpty()) {
        var flag = false
        val current = queue.peek()
        for (i in current.d downTo 1) {
            if (table[i] == 0) {
                // 빈곳이 있을 경우에 넣어준다.
                table[i] = current.p
                queue.poll()
                flag = true
                break
            }
            if (table[i] < current.p) {
                // 만약에 더 작은게 있으면 교체를 해준다.
                queue.poll()
                queue.offer(DayWithPay(i, table[i]))
                table[i] = current.p
                flag = true
                break
            }
        }
        if (!flag) {
            queue.poll()
        }
    }
    println(table.sum())
}
/*
학자에게 n(0~10000)개의 대학에서 강연요청을 했다
각 대학은 d일 안에 와서 강연을 해주면 p( 1.. 10000)만큼의 강연료를 지불하겠다고 한다.
가장 돈을 많이 벌 수 있는 순회강연을 하려고한다.
하루에 최대 한곳에서만 강의를 할 수 있다.

5
3 3
2 3
1 3
100 4
90 4

스위치 하고 옮겨주는 로직이 필요합니다.


 */
