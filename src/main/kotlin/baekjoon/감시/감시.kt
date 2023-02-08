package baekjoon.감시

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

data class Cctv(
    val x: Int,
    val y: Int,
    val type: Int
)

val cctvList = arrayListOf<Cctv>()
var wallCount = 0
var count = 0

var maxCount = Integer.MAX_VALUE

lateinit var room: Array<Array<Int>>
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M) = readLine().split(" ").map { it.toInt() }
    room = Array(N) { Array(M) { 0 } }

    for (i in room.indices) {
        val row = readLine().split(" ").map { it.toInt() }
        for (j in row.indices) {
            room[i][j] = row[j]
            if (row[j] in 1..5) {
                cctvList.add(Cctv(i, j, row[j]))
            }
            if (row[j] == 6) {
                wallCount++
            }
        }
    }
    maxCount = N * M - wallCount
    for (i in cctvList.indices) {
        expand(i)
    }

    println("table ${room.joinToString { it.toString() }}")
    println("cctvList ${cctvList.joinToString { it.toString() }}")
}

data class Vertex(
    val x: Int,
    val y: Int
)
val rotateType1 = listOf(
    listOf(Vertex(0, 1)),
    listOf(Vertex(1, 0)),
    listOf(Vertex(0, -1)),
    listOf(Vertex(-1, 0))
)
val rotateType2 = listOf(
    listOf(Vertex(0, 1), Vertex(0, -1)),
    listOf(Vertex(1, 0), Vertex(-1, 0))
)
val rotateType3 = listOf(
    listOf(Vertex(0, 1), Vertex(-1, 0)),
    listOf(Vertex(1, 0), Vertex(0, 1)),
    listOf(Vertex(0, -1), Vertex(1, 0)),
    listOf(Vertex(-1, 0), Vertex(0, -1))
)
val rotateType4 = listOf(
    listOf(Vertex(0, 1), Vertex(0, -1), Vertex(-1, 0)),
    listOf(Vertex(1, 0), Vertex(0, 1), Vertex(-1, 0)),
    listOf(Vertex(0, -1), Vertex(1, 0), Vertex(0, 1)),
    listOf(Vertex(-1, 0), Vertex(0, -1), Vertex(1, 0))
)
val rotateType5 = listOf(
    listOf(
        Vertex(0, -1),
        Vertex(1, 0),
        Vertex(0, -1),
        Vertex(-1, 0)
    )
)

fun setExpand(rotateType: Vertex, currentX: Int, currentY: Int) {
    var nextX = currentX + rotateType.x
    var nextY = currentY + rotateType.y

    while (
        nextX in room.indices &&
        nextY in room[nextX].indices &&
        room[nextX][nextY] in 1..5
    ) {
        nextX += rotateType.x
        nextY += rotateType.y
    }
    if (
        nextX in room.indices &&
        nextY in room[nextX].indices && room[nextX][nextY] != 6
    ) {
        room[nextX][nextY] = -1
        count++
        setExpand(rotateType, nextX, nextY)
        var zerocount = 0
        for (i in room) {
            for (j in i) {
                if (j == 0) {
                    zerocount++
                }
            }
        }
        println(
            "table ${room.forEach{arr ->
                println(arr.joinToString { it.toString() })
            }}"
        )

        maxCount = maxCount.coerceAtMost(zerocount)
        println(maxCount)
        count--
        room[nextX][nextY] = 0
    }
}

fun expand(currentIndex: Int) {
    count = 0
    if (currentIndex !in cctvList.indices) {
        return
    }
    val currentCctv = cctvList[currentIndex]
    val currentType = currentCctv.type
    val currentX = currentCctv.x
    val currentY = currentCctv.y

    when (currentType) {
        1 -> {
            for (i in rotateType1.indices) {
                for (j in rotateType1[i].indices) {
                    setExpand(rotateType = rotateType1[i][j], currentX, currentY)
                    expand(currentIndex + 1)
                }
            }
        }
        2 -> {
            for (i in rotateType2.indices) {
                for (j in rotateType2[i].indices) {
                    setExpand(rotateType = rotateType2[i][j], currentX, currentY)
                    expand(currentIndex + 1)
                }
            }
        }
        3 -> {
            for (i in rotateType3.indices) {
                for (j in rotateType3[i].indices) {
                    setExpand(rotateType3[i][j], currentX, currentY)
                    expand(currentIndex + 1)
                }
            }
        }
        4 -> {
            for (i in rotateType4.indices) {
                for (j in rotateType4[i].indices) {
                    setExpand(rotateType4[i][j], currentX, currentY)
                    expand(currentIndex + 1)
                }
            }
        }
        else -> {
            for (i in rotateType5.indices) {
                for (j in rotateType5[i].indices) {
                    setExpand(rotateType5[i][j], currentX, currentY)
                    expand(currentIndex + 1)
                }
            }
        }
    }
}
