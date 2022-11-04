package baekjoon.중량제한

import baekjoon.solution11724.queue
import baekjoon.solution2667.arr
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

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
    val (N, M) = readLine().split(" ").map { it.toInt() }
    // N은 섬의 갯수
    val bridges = Array(N + 1) { arrayListOf<Pair<Int, Int>>() }

    repeat(M) {
        val (A, B, C) = readLine().split(" ").map { it.toInt() }
        bridges[A].add(Pair(B, C))
        bridges[B].add(Pair(A, C))
    }

    val (fac1, fac2) = readLine().split(" ").map { it.toInt() }

//    bfs(start = fac1, fac2, arr)
    println(check(start = fac1, end = fac2, 0, 1000000001, bridges))
}

fun check(start: Int, end: Int, low: Int, high: Int, arr: Array<ArrayList<Pair<Int, Int>>>): Int {
    var low = low
    var high = high
    while (low + 1 < high) {
        val mid = (low + high) / 2 // 물품의 중량 값
        if (bfs(start = start, end = end, arr = arr, mid)) {
            // 도달 했는가?
            high = mid
        } else {
            // 도달 하지 못했는가?
            low = mid
        }
    }
    return low
}

fun bfs(start: Int, end: Int, arr: Array<ArrayList<Pair<Int, Int>>>, mid: Int): Boolean {
    val queue = LinkedList<Int>() // Node Num & 중량 최대값
    queue.offer(start)
    val check = Array(arr.size) { false }
    check[start] = true
    while (queue.isNotEmpty()) {
        val nodeNum = queue.poll()
        check[nodeNum] = true
        for (i in arr[nodeNum]) {
            val nextNode = i.first
            val cost = i.second
            if (!check[nextNode] && cost <= mid) {
                queue.offer(nextNode)
                check[nodeNum] = true
            }
        }
    }
    return check[end]
}

/*
N(2 .. 10_000)개의 섬으로 이루어진 나라있음.
이들 중 몇개의 섬사이에는 다리가 설치

영식 중공업에서는 두 개의 섬에 공장을 세움.
공장에서 다른 공장으로 물품 수송
각 다리마다 중량제한 있음.
중량 제한을 초과하는 양의 물품이 다리를 지나게 되면 다리가 무너짐.
한 번의 이동에서 옮길 수 있는 물품들의 중량의 최댓값을 구하는 프로그램 작성

lower bound = 원하는 값 k이상이 처음 나오는 위치
upper bound = 원하는 값 k를 초과한 값이 나오는 위치 // arr[mid] 와 target를 비교하는 부분에서 등호 제거
 */
