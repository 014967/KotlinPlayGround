package baekjoon.`단어 수학`

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val wordList = arrayListOf<String>()

    val mapTable = HashMap<String, String>()
    var numberValue = 9

    for (i in 1..n) {
        wordList.add(readLine())
    }
    wordList.sortByDescending { it.length }

    val arr = Array(n) { Array(8) { "" } }
    wordList.forEachIndexed { index, it ->
        val s = it.toList().reversed()
        var lastIndex = arr[index].lastIndex
        for (i in s) {
            arr[index][lastIndex] = i.toString()
            lastIndex--
        }
    }
    val flatSet = wordList.map {
        it.toList()
    }.flatten().groupBy {
        it
    }.map { Pair(it.key, it.value.size) }.sortedByDescending { it.second }

    println(flatSet)
    for (i in 0 until 8) {
        for (row in 0 until n) {
            val current = arr[row][i]
            if (current != "") {
                if (mapTable.containsKey(current)) {
                    arr[row][i] = mapTable[current]!!
                } else {
                    mapTable[current] = numberValue.toString()
                    arr[row][i] = numberValue.toString()
                    numberValue--
                }
            }
        }
    }
    var result = 0
    for (i in arr.indices) {
        val builder = StringBuilder()
        for (j in arr[i].indices) {
            if (arr[i][j] != "") {
                builder.append(arr[i][j])
            }
        }
        result += builder.toString().toInt()
    }
    println(result)
}

/*

단어 수학 문제는 N개의 단어로 이루어짐. 알파벳 대문자로
알파벳 대문자를 0부터 9까지의 숫자중 하나로 바꿔서 N개의 수를 합하는 문제
같은 알파벳은 같은 숫자로 바꿔.
두개 이상의 알파벳이 같은 숫자로 바꿔지면 안된다.

 */
