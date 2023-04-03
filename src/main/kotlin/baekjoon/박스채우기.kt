package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.log2
import kotlin.math.pow
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

lateinit var cubeArray: Array<Int>

data class Box(
    val length: Int,
    val width: Int,
    val height: Int
)
var count2 = 0L
lateinit var box: Box
fun main(): Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (length, width, height) = readLine().split(" ").map { it.toInt() }
    box = Box(length, width, height)
    val n = readLine().toInt() // cube 갯수

    cubeArray = Array(20) { 0 }
    for (i in 0 until n) {
        val (Ai, Bi) = readLine().split(" ").map { it.toInt() }

        // Ai 는 유니크한 크기다.
        cubeArray[Ai] = Bi // 승 이 0일때 갯수
    }

    // 제일 큰것부터 보자

    getCount(length, width, height, n - 1)
    println(count2)
}

private fun getCount(length: Int, width: Int, height: Int, index: Int) {
    if (length == 0 || width == 0 || height == 0) {
        /*
        length , widht, height 중에 하나라도 0 이 된다면
        이것은 정사각형이 들어갈 수가 없다return
         */
        return
    }

    val short = minOf(length, width, height) // 세 변중에 가장 짧은 것을 구합니다. 그래야 정사각형을 만들 수 있어서
    var half = log2(short.toFloat()).toInt() // 최대 변의 크기

    // 4

    // 한변의 길이가 2의 제곱꼴이라서, 최대 나올 수 있는 변의 크기는 다음과 같음.

    // 2^2 2승에해당하는 cubeArray[2] 갯수를 하나 빼준다.

    var flag = false

    for (i in half downTo 0) { // 2승부터 0승까지 cube를 돌려봐요
        if (cubeArray[i] > 0) {
            // cube 갯수 가 0 일경우는 사용할 수없으니까 해당 승 -1 의 큐브를 찾아봅니다
            flag = true // 나중에 이 재귀를  취소할 flag
            half = i // half  = 2
            break
        }
    }
    if (!flag) {
        println(-1)
        exitProcess(0)
    }
    val t = 2f.pow(half).toInt() // 실제 2승에 해당하는 변의 길이는 2 ^ 2 =4
    count2++ // 사용하는 큐브의 갯수니까 하나 늘려줍니다.
    cubeArray[half]-- // 빼주고
    getCount(length, width - t, height, half) // 3 영역에서 또다시 cube를 넣을 수 있는지 판단하는거죠
    getCount(length - t, t, height, half)
    getCount(t, t, height - t, half)
}

/*
첫째 줄에 세 자연수 length, width, height가 주어진다
둘째 줄에는 세준이가 가지고 있는 큐브의 종류의 갯수 N이 주어진다.
N개의 줄에 큐브의 종류 Ai와 Bi가 i가 중가하는 순서로 주어진다.
큐브의 종류는 한변의 길이를 나타낼 때 쓰는 2^i에서 i이다.

채울 수 있다면 필요한 큐브의 갯수의 최소값을 출력해라. 채울수 없다면 -1

 */
