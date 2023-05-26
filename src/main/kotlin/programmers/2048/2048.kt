package programmers.`2048`

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

import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer
import kotlin.math.max

var n = 0
var max = 0L

fun main() {
    val br = System.`in`.bufferedReader()

    n = br.readLine().toInt()

    val arr = Array(n) { Array(n) { 0L } }

    repeat(n) { x ->
        val st = StringTokenizer(br.readLine())
        repeat(n) { y ->
            arr[x][y] = st.nextToken().toLong()
        }
    }

    // 백트래킹
    dfs(0, arr)

    println(max)
}

fun dfs(depth: Int, arr: Array<Array<Long>>) {

    // 5번 모두 이동 했을 경우 최대값 저장
    if (depth == 5) {
        repeat(n) { x ->
            repeat(n) { y ->
                max = max(max, arr[x][y])
            }
        }
        return
    }

    for (i in 0 until 4) {
        // 배열 복사
        val copyArr = Array(n) { Array(n) { 0L } }
        repeat(n) { x ->
            repeat(n) { y ->
                copyArr[x][y] = arr[x][y]
            }
        }

        when (i) {
            0 -> up(copyArr)
            1 -> down(copyArr)
            2 -> right(copyArr)
            3 -> left(copyArr)
        }

        dfs(depth + 1, copyArr)
    }
}


fun up(arr: Array<Array<Long>>) {
    for (i in 0 until n) {
        val q = LinkedList<Long>() as Queue<Long>

        for (j in 0 until n) {
            if (arr[j][i] == 0L) continue

            q.offer(arr[j][i])
            arr[j][i] = 0
        }

        var ptr = 0

        while (q.isNotEmpty()) {
            val target = q.poll()
            if (q.isNotEmpty() && target == q.peek()) {
                arr[ptr][i] = target * 2
                q.poll()
            } else {
                arr[ptr][i] = target
            }
            ptr++
        }
    }
}

fun down(arr: Array<Array<Long>>) {
    for (i in 0 until n) {
        val q = LinkedList<Long>() as Queue<Long>

        for (j in n - 1 downTo 0) {
            if (arr[j][i] == 0L) continue

            q.offer(arr[j][i])
            arr[j][i] = 0
        }

        var ptr = n - 1

        while (q.isNotEmpty()) {
            val target = q.poll()
            if (q.isNotEmpty() && target == q.peek()) {
                arr[ptr][i] = target * 2
                q.poll()
            } else {
                arr[ptr][i] = target
            }
            ptr--
        }
    }
}


fun left(arr: Array<Array<Long>>) {
    for (i in 0 until n) {
        val q = LinkedList<Long>() as Queue<Long>

        for (j in 0 until n) {
            if (arr[i][j] == 0L) continue

            q.offer(arr[i][j])
            arr[i][j] = 0L
        }

        var ptr = 0

        while (q.isNotEmpty()) {
            val target = q.poll()
            if (q.isNotEmpty() && target == q.peek()) {
                arr[i][ptr] = target * 2
                q.poll()
            } else {
                arr[i][ptr] = target
            }
            ptr++
        }
    }
}

fun right(arr: Array<Array<Long>>) {
    for (i in 0 until n) {
        val q = LinkedList<Long>() as Queue<Long>

        for (j in n - 1 downTo 0) {
            if (arr[i][j] == 0L) continue

            q.offer(arr[i][j])
            arr[i][j] = 0
        }

        var ptr = n - 1

        while (q.isNotEmpty()) {
            val target = q.poll()
            if (q.isNotEmpty() && target == q.peek()) {
                arr[i][ptr] = target * 2
                q.poll()
            } else {
                arr[i][ptr] = target
            }
            ptr--
        }
    }
}

//var max = 0L
//fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
//    val n = readLine().toInt()
//    val table = Array(n) { Array(n) { 0L } }
//
//    for (row in table.indices) {
//        val items = readLine().split(" ").map { it.toLong() }
//        for (index in items.indices) {
//            table[row][index] = items[index]
//        }
//    }
//
//    dfs(0, table)
//    println(max)
//}
//fun dfs(depth: Int, arr: Array<Array<Long>>) {
//    if (depth == 5) {
//        for (x in arr.indices) {
//            for (y in arr[x].indices) {
//                max = max(max, arr[x][y])
//            }
//        }
//        return
//    }
//    for (i in 0 until 4) {
//        // 방향
//
//        val copyArray = Array(arr.size) { Array(arr[0].size) { 0L } }
//        for (x in copyArray.indices) {
//            for (y in copyArray[x].indices) {
//                copyArray[x][y] = arr[x][y]
//            }
//        }
//
//        when (i) {
//            0 -> {
//                up(copyArray)
//            }
//            1 -> {
//                down(copyArray)
//            }
//            2 -> {
//                left(copyArray)
//            }
//            3 -> {
//                right(copyArray)
//            }
//        }
//        dfs(depth + 1, copyArray)
//    }
//}
//
//fun up(arr: Array<Array<Long>>) {
//    for (i in arr.indices) {
//        val q = LinkedList<Long>()
//        for (j in arr[i].indices) {
//            if (arr[j][i] == 0L) continue
//            q.offer(arr[j][j])
//            arr[j][i] = 0L
//        }
//
//        var index = 0
//        while (q.isNotEmpty()) {
//            val current = q.poll()
//            if (q.isNotEmpty() && current == q.peek()) {
//                arr[index][i] = current * 2
//                q.poll()
//            } else {
//                arr[index][i] = current
//            }
//            index++
//        }
//    }
//}
//fun down(arr: Array<Array<Long>>) {
//    for (i in arr.indices) {
//        val q = LinkedList<Long>()
//        for (j in arr.size - 1 downTo 0) {
//            if (arr[j][i] == 0L) continue
//            q.offer(arr[j][i])
//            arr[j][i] = 0L
//        }
//
//        var index = arr.size - 1
//        while (q.isNotEmpty()) {
//            val current = q.poll()
//            if (q.isNotEmpty() && current == q.peek()) {
//                arr[index][i] = current * 2
//                q.poll()
//            } else {
//                arr[index][i] = current
//            }
//            index--
//        }
//    }
//}
//
//fun left(arr: Array<Array<Long>>) {
//    for (i in arr.indices) {
//        val q = LinkedList<Long>()
//        for (j in arr.indices) {
//            if (arr[i][j] == 0L) continue
//            q.offer(arr[i][j])
//            arr[i][j] = 0L
//        }
//
//        var index = 0
//        while (q.isNotEmpty()) {
//            val current = q.poll()
//            if (q.isNotEmpty() && current == q.peek()) {
//                arr[i][index] = current * 2
//                q.poll()
//            } else {
//                arr[i][index] = current
//            }
//            index++
//        }
//    }
//}
//
//fun right(arr: Array<Array<Long>>) {
//    for (i in arr.indices) {
//        val q = LinkedList<Long>()
//        for (j in arr.size - 1 downTo 0) {
//            if (arr[i][j] == 0L) continue
//            q.offer(arr[i][j])
//            arr[i][j] = 0L
//        }
//
//        var index = arr.size - 1
//        while (q.isNotEmpty()) {
//            val current = q.poll()
//            if (q.isNotEmpty() && current == q.peek()) {
//                arr[i][index] = current * 2
//                q.poll()
//            } else {
//                arr[i][index] = current
//            }
//            index--
//        }
//    }
//}
