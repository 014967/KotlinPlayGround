package baekjoon.solution2212

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

data class Sensor(
    val startSensor: Int,
    val endSensor: Int
)

data class SensorBetweenLength(
    val length: Int,
    val sensor: Sensor
)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt() // 센서

    val k = readLine().toInt() // 집중국

    val sensor = readLine().split(" ").map { it.toInt() }.sortedBy { it }

    var arr = arrayListOf<SensorBetweenLength>()
    for (i in 0 until sensor.size - 1) {
        arr.add(SensorBetweenLength((sensor[i + 1] - sensor[i]), Sensor(startSensor = sensor[i], endSensor = sensor[i + 1])))
    }
    var s = arr.sortedWith(compareBy<SensorBetweenLength> { it.length }.reversed())
    s = s.drop(k - 1)

    var result = 0
    for (i in s) {
        result += (i.sensor.endSensor - i.sensor.startSensor)
    }
    println(result)
}
/*

6개
집중국 2개

1 2 3 4 5 6 7 8 9
-   -     - -   -
          -
    *       *

*

1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
    -     - - -   -     -     -   -       -     -


5개의 집중국
1 4 1 2 2
[6,10] 4
[3] 0
[12] 0
[14,15] 1
[18,20] 2


길이가 긴곳은 기지국을 설치하지 않는다고 하면
이곳에 기지국을 설치할 수 있는 가장 짧은 거리를 가짐
6 , 7
7 , 8
14, 15

 */
