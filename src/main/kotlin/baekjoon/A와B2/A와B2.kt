package baekjoon.A와B2

import java.io.BufferedReader
import java.io.InputStreamReader
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
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val s = readLine().toString()
    val t = readLine().toString()
    search(t, s)
}

fun search(t: String, s: String) {
    val queue = LinkedList<String>()
    queue.offer(t)
    var flag = false
    while (queue.isNotEmpty()) {
        val current = queue.poll()
        if (current == s) {
            flag = true
            break
        }
        if (current.length >= 2 && current.first() == 'B') {
            // 이전에 B를 추가하고 뒤집었다

            val before = current.substring(1, current.length).reversed()
            queue.offer(before)
        }

        if (current.length >= 2 && current.last() == 'A') {
            val before = current.dropLast(1)
            queue.offer(before)
        }
    }
    if (flag) { println(1) } else println(0)
}

// s 에서 t로는 안된데 T에서 s로 바꿔야한대


/*
문자열 s와 t가 주어졌을때
s를 t로 바꾸려고함
문자열을 바꿀때는 뒤에 A를 추가하거나,
문자열 뒤에 B를 추가하고 문자열을 뒤집는다.
주어진 조건을 이용해서 s를 t로 바꿀 수 있는지 알아내샘.

 */
