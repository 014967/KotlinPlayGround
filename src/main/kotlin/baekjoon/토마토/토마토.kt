package baekjoon.토마토

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

data class Vertex(
    val H: Int,
    val M: Int,
    val N: Int

)
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (M, N, H) = readLine().split(" ").map { it.toInt() }

    val arr = Array(H) { Array(N) { Array(M) { 0 } } }

    val greenTomatoList = ArrayList<Vertex>()
    val igTomatoList = ArrayList<Vertex>()
    for (i in 0 until H) {
        // 층
        for (j in 0 until N) {
            val info = readLine().split(" ").map { it.toInt() }
            info.forEachIndexed { index, k ->
                arr[i][j][index] = k
                if (k == 0) {
                    greenTomatoList.add(
                        Vertex(
                            M = index,
                            N = j,
                            H = i
                        )
                    )
                } else if (k == 1) {
                    igTomatoList.add(
                        Vertex(
                            H = i,
                            M = index,
                            N = j
                        )
                    )
                }
            }
        }
    }

    var day = 0
    var greenTomato = greenTomatoList.size
    val queue = LinkedList(igTomatoList)
    while (greenTomato > 0 && queue.isNotEmpty()) {
        val size = queue.size
        for (i in 0 until size) {
            val currentTomato = queue.poll()
            // 현재 토마토 기준으로 6방향 확인
            for (i in 0 until 6) {
                val nextH = currentTomato.H + dz[i]
                val nextM = currentTomato.M + dx[i]
                val nextN = currentTomato.N + dy[i]

                if (nextH in 0 until H && nextM in 0 until M && nextN in 0 until N) {
                    if (arr[nextH][nextN][nextM] != 0) {
                        continue
                    }
                    arr[nextH][nextN][nextM] = 1
                    greenTomato--
                    queue.offer(
                        Vertex(
                            H = nextH,
                            M = nextM,
                            N = nextN
                        )
                    )
                }
            }
        }
        day++
    }
    if (greenTomato == 0) {
        println(day)
    } else {
        println(-1)
    }
}
val dz = listOf(0, 0, 0, 0, -1, 1)
val dy = listOf(0, 0, -1, 1, 0, 0)
val dx = listOf(-1, 1, 0, 0, 0, 0)
