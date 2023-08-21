package leetcode.WordLadder

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

fun main() {
    val beginWord = "hit"
    val endWord = "cog"
    val wordList = listOf(
        "hot",
        "dot",
        "dog",
        "lot",
        "log",
        "cog"
    )

    val sol = Solution()
    println(sol.ladderLength(beginWord, endWord, wordList))
}
/*
wordLength <= 10
wordList <= 5000
 */

class Solution {

    var check = HashMap<String, Boolean>()
    val table = HashMap<String, ArrayList<String>>()
    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        if (!wordList.contains(endWord)) {
            return 0
        }

        check.apply {
            wordList.forEach {
                this[it] = false
            }
        }
        var result = 0

        for (i in wordList.indices) {
            if (isOnlyDifferenceOneLetter(beginWord, wordList[i])) {
                if (table[beginWord] == null) {
                    table[beginWord] = arrayListOf(wordList[i])
                } else {
                    table[beginWord]?.add(wordList[i])
                }
            }
            for (j in i + 1 until wordList.size) {
                if (wordList[i] == wordList[j]) {
                    continue
                }
                if (isOnlyDifferenceOneLetter(wordList[i], wordList[j])) {
                    if (table[wordList[i]] == null) {
                        table[wordList[i]] = arrayListOf(wordList[j])
                    } else {
                        table[wordList[i]]?.add(wordList[j])
                    }

                    if (table[wordList[j]] == null) {
                        table[wordList[j]] = arrayListOf(wordList[i])
                    } else {
                        table[wordList[j]]?.add(wordList[i])
                    }
                }
            }
        }

        result = bfs(startWord = beginWord, endWord = endWord)

        return result
    }

    data class CountWord(
        val word: String,
        val count: Int
    )
    private fun bfs(startWord: String, endWord: String): Int {
        val queue = LinkedList<CountWord>()
        queue.offer(CountWord(word = startWord, 1))

        var count = 0
        while (queue.isNotEmpty()) {
            val countWord = queue.poll()
            val currentWord = countWord.word
            val currentCount = countWord.count
            if (currentWord == endWord) {
                count = currentCount
                break
            }
            check[currentWord] = true
            val transableCurrentWordList = table[currentWord] ?: continue
            for (i in transableCurrentWordList.indices) {
                if (!check[transableCurrentWordList[i]]!!) {
                    queue.offer(CountWord(word= transableCurrentWordList[i], currentCount + 1))
                }
            }
        }

        return count
    }

    private fun isOnlyDifferenceOneLetter(word1: String, word2: String): Boolean {
        var count = 0
        for (w in word1.indices) {
            if (word1[w] != word2[w]) {
                count++
            }

            if (count >= 2) {
                break
            }
        }
        return count == 1
    }
}

/*
1개만 변환을 해야한다.

hit <-> hot

hot <-> dot
    <-> lot

dot <-> dog
    <-> lot

lot <-> dot
    <-> log

dog <-> dot
    <-> log
    <-> cog

log <-> lot
    <-> cog
    <-> dog

cog <-> log
    <-> dog


 */
