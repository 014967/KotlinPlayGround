package baekjoon.합

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

    val map = HashMap<Char, Long>().apply {
        this['A'] = 0
        this['B'] = 0
        this['C'] = 0
        this['D'] = 0
        this['E'] = 0
        this['F'] = 0
        this['G'] = 0
        this['H'] = 0
        this['I'] = 0
        this['J'] = 0
    }

    val canZero = HashMap<Char, Boolean>().apply {
        this['A'] = true
        this['B'] = true
        this['C'] = true
        this['D'] = true
        this['E'] = true
        this['F'] = true
        this['G'] = true
        this['H'] = true
        this['I'] = true
        this['J'] = true
    }

    val resultList = arrayListOf<String>()
    for (i in 1..n) {
        val str = readLine().toString()
        resultList.add(str)
        var m = 1L
        for (j in str.length - 1 downTo 0) {
            map[str[j]] = map[str[j]]!!.plus(m)
            if (j == 0) {
                canZero[str[j]] = false
            }
            m *= 10
        }
    }
    val sortedMap = map.toList().sortedByDescending { it.second }.toMutableList()

    if (!canZero[sortedMap.last().first]!!) {
        for (i in sortedMap.size - 1 downTo 0) {
            if (canZero[sortedMap[i].first] == true) {
                val temp = sortedMap[i]
                sortedMap.removeAt(i)
                sortedMap.add(temp)
                break
            }
        }
    }

    var count = 9L
    for (i in sortedMap.indices) {
        sortedMap[i] = sortedMap[i].copy(second = count)
        count--
    }

    val resultMap = sortedMap.toMap()

    val result = resultList.map { str ->
        var mutableString = str
        for (i in mutableString.indices) {
            if (!mutableString[i].isDigit()) {
                mutableString = mutableString.replace(mutableString[i].toString(), resultMap[mutableString[i]].toString())
            }
        }
        mutableString
    }.map {
        it.toLong()
    }.sum()
    println(result)
}

/*
10
A
BB
CCC
DDDD
EEEEE
FFFFFF
GGGGGGG
HHHHHHHH
IIIIIIIII
AJJJJJJJJJ
 */
