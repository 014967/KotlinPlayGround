package baekjoon.solution19939

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
    val input = readLine().split(" ").map {
        it.toInt()
    }
    var ballNumber = input[0]
    val teamNumber = input[1]
    require(ballNumber in 2..100000)
    require(teamNumber in 2..1000)

    val arr = Array(teamNumber) { 1 }
    if (canIMake(ballNumber, teamNumber)) {
        val flagNumber = (teamNumber * (teamNumber + 1)) / 2 // 10
        val temp = (ballNumber - flagNumber) / teamNumber // 17 - 10 / 4 = 1
        val el = (ballNumber - flagNumber) % teamNumber //  3

        var min = 1
        var max = teamNumber

        if (el == 0) {
            min += temp
            max += temp
            println(max - min)
        } else {
            min += temp
            max += temp + 1
            println(max - min)
        }
    } else {
        println(-1)
    }
}

fun canIMake(ballNumber: Int, teamNumber: Int): Boolean {
    val flagNumber = (teamNumber * (teamNumber + 1)) / 2
    return flagNumber <= ballNumber
}
