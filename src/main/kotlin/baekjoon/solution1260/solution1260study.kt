package baekjoon.solution1260

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

val dfsList = arrayListOf<Int>()
val bfsList = arrayListOf<Int>()
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val line = readLine().split(" ").map {
        it.toInt()
    }
    val n = line[0] // 정점
    val m = line[1] // 간선
    val v = line[2] // 시작할 정점 번호 v

    val arr = sortedMapOf<Int, ArrayList<Int>>()

    val queue = LinkedList<LinkedList<Int>>()
    for (i in 1..n + 1) {
        queue.add(LinkedList<Int>())
    }

    // m  개 의 줄 간선이 연결하는 두 정점의 번호
    for (i in 1..m) {
        val rLine = readLine().split(" ").map { it.toInt() }
        val startVertex = rLine[0]
        val endVertex = rLine[1]
        if (arr.containsKey(startVertex)) {
            arr[startVertex]!!.add(endVertex)
        } else {
            arr.put(startVertex, arrayListOf(endVertex))
        }

        if (arr.containsKey(endVertex)) {
            arr[endVertex]!!.add(startVertex)
        } else {
            arr.put(endVertex, arrayListOf(startVertex))
        }
        queue[startVertex].add(endVertex)
        queue[endVertex].add(startVertex)
    }

    // 정렬
    for (i in arr) {
        i.value.sort()
    }
    queue.withIndex().sortedWith { o1, o2 -> o1.index - o2.index }.map {
        it.value.sort()
    }

    var checkDfs = Array<Boolean>(n + 1) { false }
    var checkBfs = Array(n + 1) { false }

    dfs(arr, v, checkDfs)

    bfs(arr, v, checkBfs)

    dfsList.forEachIndexed { index, i ->
        if (index != dfsList.size - 1) {
            print("$i ")
        } else {
            println(i)
        }
    }

    bfsList.forEachIndexed { index, i ->
        if (index != bfsList.size - 1) {
            print("$i ")
        } else {
            println(i)
        }
    }
}

private fun bfs(
    arr: SortedMap<Int, ArrayList<Int>>,
    startVertex: Int,
    checkBfs: Array<Boolean>
) {
    val queue = LinkedList<Int>()

    checkBfs[startVertex] = true
    queue.offer(startVertex)
    bfsList.add(startVertex)

    while (queue.isNotEmpty()) {
        var nodeNum = queue.poll()
        val list = arr[nodeNum]
        if (list != null) {
            for (i in list) {
                if (!checkBfs[i]) {
                    queue.offer(i)
                    bfsList.add(i)
                    checkBfs[i] = true
                }
            }
        }
    }
}

private fun dfs(arr: SortedMap<Int, ArrayList<Int>>, startVertex: Int, check: Array<Boolean>) {

    dfsList.add(startVertex)
    check[startVertex] = true
    val list = arr[startVertex]

    if (list != null) {
        for (j in list) {
            if (!check[j]) {
                dfs(arr, startVertex = j, check)
            }
        }
    }
}

/*
 for문 안에서 bfs와 dfs을 호출하기 땜눙 ㅔ
 */
