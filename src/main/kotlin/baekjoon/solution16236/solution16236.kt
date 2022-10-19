package baekjoon.solution16236

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

val dx = listOf(0, 0, -1, 1)
val dy = listOf(1, -1, 0, 0)
var min_Distance = Integer.MAX_VALUE
var minX = Integer.MAX_VALUE
var minY = Integer.MAX_VALUE
var shark_size = 2
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()

    val arr = Array(n) { IntArray(n) { -1 } }
    val distance = Array(n) { IntArray(n) { -1 } }
    var shark = Pair<Int, Int>(0, 0)
    var result = 0
    var count = 0

    for (i in 0 until n) {
        readLine().split(" ").mapIndexed { index, s ->
            arr[i][index] = s.toInt()
            if (s.toInt() == 9) {
                shark = Pair(i, index)
            }
        }
    }

    while (true) {
        min_Distance = Integer.MAX_VALUE
        minX = Integer.MAX_VALUE
        minY = Integer.MAX_VALUE

        for (i in distance.indices) {
            for (j in distance[i].indices) {
                distance[i][j] = -1
            }
        }
        bfs(arr, distance, shark) // 물고기를 찾아

        if (minX != Integer.MAX_VALUE && minY != Integer.MAX_VALUE) {
            result += distance[minX][minY]
            count++
            if (count == shark_size) {
                shark_size++
                count = 0
            }

            arr[minX][minY] = 0

            shark = Pair(minX, minY)
        } else {
            break
        }
    }
    println(result)
}

private fun bfs(arr: Array<IntArray>, distance: Array<IntArray>, shark: Pair<Int, Int>) {

    val queue = LinkedList<Pair<Int, Int>>()
    queue.offer(Pair(shark.first, shark.second))
    distance[shark.first][shark.second] = 0 // 처음 시작을 0으로 초기화
    // 시작 인덱스
    while (queue.isNotEmpty()) {
        val currentVertex = queue.poll()
        val currentX = currentVertex.first
        val currentY = currentVertex.second

        for (i in 0..3) {
            val x = currentX + dx[i]
            val y = currentY + dy[i]

            if (currentX < 1 || currentX > arr.size - 1 || currentY < 1 || currentY > arr.size) continue
            if (distance[x][y] != -1 || arr[x][y] > shark_size) continue

            if(x in arr.indices && y in arr[0].indices){
                // 물고기가 있다면
                if (arr[x][y] != 0 && arr[x][y] < shark_size) {
                    distance[x][y] = distance[currentX][currentY] + 1 // 거리 1증가
                    if (min_Distance > distance[x][y]) {
                        minX = x
                        minY = y
                        min_Distance = distance[x][y]
                    } else if (min_Distance == distance[x][y]) {
                        if (minX == x) {
                            if (minY > y) {
                                minX = x
                                minY = y
                            }
                        } else if (minX > x) {
                            minX = x
                            minY = y
                        }
                    }
                }
            }


            queue.offer(Pair(x, y))
        }
    }
}

/*
1) 최단 경로
BFS는 모든 간선의 가중치가 1로 같을 때 최단 경로를 찾아준다
2) 자료구조

3) 이동

4) 가장 거리가 짧은 물고기가 여러마리일 경우

1억에 1초가 걸리고 2초가 주어졌기 때문에 시간안에 충분히 풀 수 있습니다.

 */
