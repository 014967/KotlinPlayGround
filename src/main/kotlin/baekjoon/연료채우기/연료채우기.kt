package baekjoon.연료채우기

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

lateinit var gasRoad: Array<GasStation>

data class GasStation(
    val distance: Int,
    val weight: Int
)
var max = Integer.MAX_VALUE
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()

    gasRoad = Array(N + 1) { GasStation(0, 0) }
    for (i in 1..N) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        gasRoad[i] = GasStation(a, b)
        // a = distance, b = gas weight
    }
    gasRoad.sortBy { it.distance }
    val (L, P) = readLine().split(" ").map { it.toInt() }
    // L 마을까지의 거리, P 원래 있던 연료의 양

    if (P >= L) {
        max = 0
        println(max)
    } else {
        for (i in 1 until gasRoad.size) {
            if (P - gasRoad[i].distance < 0) {
                break
            }

            dfs(index = i, L - gasRoad[i].distance, P - gasRoad[i].distance + gasRoad[i].weight, count = 1)
        }
        if (max == Integer.MAX_VALUE) {
            max = -1
        }
        println(max)
    }
}
fun dfs(index: Int, target: Int, currentGas: Int, count: Int) {
    if (target <= currentGas) {
        max = max.coerceAtMost(count)
        return
    }

    for (i in index + 1 until gasRoad.size) {
        val distanceGap = (gasRoad[i].distance - gasRoad[index].distance)
        val nextTarget = target - distanceGap
        val nextGas = currentGas - distanceGap + gasRoad[i].weight

        if (distanceGap > nextGas) {
            break
        }
        dfs(
            index = i,
            target = nextTarget,
            currentGas = nextGas,
            count = count + 1
        )
    }
}
