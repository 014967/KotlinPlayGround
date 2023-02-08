package baekjoon.`단어 수학`

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
    val n = readLine().toInt()
    val wordList = arrayListOf<String>()

    for (i in 1..n) {
        wordList.add(readLine())
    }
    wordList.sortByDescending { it.length }

    val flatSet = wordList.asSequence().map {
        it.toList()
    }.flatten().groupBy {
        it
    }.map { it.key.toString() }

    // 각 알파벳에 모든 경우의 수를 따져보자
    val list = permutation(flatSet)

    var answer = 0
    for (i in list) {
        var count = 0
        var max = 9
        val table = HashMap<String, String>()

        for (j in i) {
            table[j] = max.toString()
            max--
        }
        for (k in wordList) {
            val temp = StringBuilder()
            for (s in k) {
                val q = table[s.toString()]
                temp.append(q)
            }
            count += temp.toString().toInt()
        }
        answer = answer.coerceAtLeast(count)
    }
    println(answer)
}

fun <T> permutation(el: List<T>, fin: List<T> = listOf(), sub: List<T> = el): List<List<T>> {
    return if (sub.isEmpty()) listOf(fin)
    else sub.flatMap { permutation(el, fin + it, sub - it) }
}
/*
백트래킹을 사용할꺼면 1자리 수일때부터 9자리 수일때까지의 모든 경우의 수를 구해야한다.
 */
