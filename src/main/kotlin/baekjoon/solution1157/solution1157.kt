package baekjoon.solution1157

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringBuilder(br.readLine()).toString().toCharArray()
    val multiSet = MultiSet()
    for (i in st.indices) {
        multiSet.add(st[i], 1)
    }
    val x = multiSet.getMax()
    if (x == -1) {
        println("?")
    } else {
        println(multiSet.getValueByIndex(x))
    }
}
class MultiSet {
    private val value = listOf<String>().toMutableList()
    private val frequency = listOf<Int>().toMutableList()
    fun add(v: Char, i: Int) {
        val element = v.uppercase()
        if (value.indexOf(element) != -1) {
            var preCount = frequency[value.indexOf(element)]
            frequency.add(value.indexOf(element), preCount + 1)
        } else {
            value.add(element)
            frequency.add(i)
        }
    }
    fun getValueByIndex(index: Int): String {
        return value[index]
    }
    fun getMax(): Int {
        val indexList = mutableListOf<Int>()
        val count = frequency.maxOrNull()
        for (i in 0 until frequency.size) {
            if (frequency[i] == count) {
                indexList.add(i)
            }
        }
        return if (indexList.size >= 2) {
            -1
        } else {
            indexList[0]
        }
    }
}
