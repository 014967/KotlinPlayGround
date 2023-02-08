package baekjoon.배

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
    val n = readLine().toInt()
    require(n in 1..50)
    val crains = readLine().split(" ").map { it.toInt() }.sortedDescending()
    val m = readLine().toInt()
    require(m in 1..10000)

    val weights = readLine().split(" ").map { it.toInt() }.sortedDescending()

    val weightStack = Stack<Int>().apply {
        weights.forEach {
            add(it)
        }
    }
    if (weightStack[0] > crains[0]) {
        println(-1)
    } else {
        var time = 0
        while (weightStack.isNotEmpty()) {
            time++
            var weightIndex = 0
            for (i in crains.indices) {
                val currentCrain = crains[i]
            println("currentCrain $currentCrain")

                while (weightIndex != weightStack.size) {
                    val currentWeight = weightStack[weightIndex]
                println("currentWeight $currentWeight")
                    var flag = false
                    if (currentCrain >= currentWeight) {
                        flag = true
                        weightStack.removeAt(weightIndex)

                    println("match crain : $currentCrain,  weight : $currentWeight")
                        break
                    }
                    if (flag) {
                        if (weightIndex != 0) {
                            weightIndex--
                        }
                    } else {
                        weightIndex++
                    }
                }
            }
        }
        println(time)
    }
}


// 4 3 2 1
// 4 4 3 3 2 2 1 1

/*
항구에 크레인이 N대 있고, 1분에 박스를 하나씩 배에 실을 수 있다.
모든 크레인은 동시에 움직임

각 크레인은 무게제한이 있다. 이 무게제한 보다 무거운 박스는 크레인으로 움직일 수 없다.
모든 박스를 배로 옮기는데 드는 시간의 최솟값

 */
