package baekjoon.가르침

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

lateinit var visited: BooleanArray
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    /*
       학생들이 되도록이면 많은 단어를 읽을 수 있어야한다.
       지구온난화로 곧 학교가 무너진다
       김지민은 K개의 글자를 가르칠 시간 밖에 없다

       김지민이 가르치고 난후에는, 학생들은 그 K개의 글자로만 이루어진 단어만을 읽을 수 있다.
       어떤 K개의 글자를 가르쳐야 학생들이 읽을 수 있는 단어의 갯수가 최대가 되는지 ?

       모든 단어는 anta로 시작 tica로 끝난다.
       남극 언어에 단어는 N개만 존재한다.
       읽을 수 있는 단어의 최댓값을 구해줘
     */

    val (N, K) = readLine().split(" ").map { it.toInt() }
    require(N in 1..50)
    require(K in 0..26)

    val wordList = arrayListOf<String>()
    val wordMap = arrayListOf<Char>()
    val canLearnWordCount = K - 5
    for (i in 1..N) {
        val word = readLine().drop(4).dropLast(4).filter {
            it !in listOf('a', 'n', 't', 'i', 'c')
        }.toCharArray().joinToString("") { it.toString() }
        if (word.length <= canLearnWordCount) {
            wordList.add(word)
            for (j in word) {
                wordMap.add(j)
            }
        }
    }

    val wordMapSet = wordMap.toSet().toList()
    visited = BooleanArray(wordMapSet.size) { false }
    val lengthMax = minOf(wordList.maxOf { it.length }, canLearnWordCount)
    println("canLearn $canLearnWordCount")
    combination(wordList, wordMapSet, 0, lengthMax, 0)

    println(result)
}

val tempList = StringBuilder()
var result = 0
fun combination(wordList: List<String>, wordMapSet: List<Char>, depth: Int, max: Int, startIndex: Int) {
    if (depth == max) {
        var count = 0
        val stringList = tempList.toString()

        for (i in wordList) {
            if (stringList.contains(i.toSet().joinToString("") { it.toString() })) {
                count++
            }
        }

        result = result.coerceAtLeast(count)
        return
    }

    for (index in startIndex until wordMapSet.size) {
        if (!visited[index]) {
            visited[index] = true
            tempList.append(wordMapSet[index])
            combination(wordList, wordMapSet, depth + 1, max, index + 1)
            tempList.deleteCharAt(tempList.lastIndex)
            visited[index] = false
        }
    }
}
/*

anta tica
a = 3
n = 1
t= 2
i =1
c= 1
총 5글자는 기본적으로 알고 있어야함

 */
