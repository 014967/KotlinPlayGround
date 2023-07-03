package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

data class Tree(
    val x: Int,
    val y: Int,
    val z: Int
)

val nx = listOf(-1, -1, -1, 0, 0, 1, 1, 1)
val ny = listOf(-1, 0, 1, -1, 1, -1, 0, 1)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M, K) = readLine().split(" ").map { it.toInt() }
    val treeTable = Array(N + 1) { Array(N + 1) { 5 } }

    val yangTable = Array(N + 1) { Array(N + 1) { 0 } }
    for (i in 1..N) {
        val row = readLine().split(" ").map { it.toInt() }
        for (j in 1..row.size) {
            yangTable[i][j] = row[j - 1]
        }
    }

    var treeList = ArrayDeque<Tree>()
    for (i in 1..M) {
        val (x, y, z) = readLine().split(" ").map { it.toInt() }
        treeList.add(Tree(x, y, z))
    }

    treeList = ArrayDeque(treeList.sortedBy { it.z })

    var currentYear = 0
    while (currentYear != K) {
        if (treeList.isEmpty()) {
            break
        }
        val tempTreeQueue = LinkedList<Tree>()

        val deadTreeList = LinkedList<Tree>()
        // 봄
        while (treeList.isNotEmpty()) {
            val tree = treeList.poll()
            val (currentTreeX, currentTreeY, currentTreeZ) = tree
            val yangBun = treeTable[currentTreeX][currentTreeY]
            if (currentTreeZ <= yangBun) {
                treeTable[currentTreeX][currentTreeY] -= currentTreeZ
                // 나이만큼 양분을 먹고 나이 1증가
                tempTreeQueue.add(tree.copy(z = currentTreeZ + 1))
            } else {
                deadTreeList.add(tree)
            }
        }
        // 여름
        while (deadTreeList.isNotEmpty()) {
            val (x, y, z) = deadTreeList.poll()
            treeTable[x][y] += z / 2
        }
        // 가을
        while (tempTreeQueue.isNotEmpty()) {
            val tree = tempTreeQueue.poll()
            treeList.addLast(tree)
            if (tree.z % 5 != 0) {
                continue
            }
            for (i in 0 until 8) {
                val nextX = tree.x + nx[i]
                val nextY = tree.y + ny[i]
                val nextZ = 1
                if (nextX in 1 until treeTable.size && nextY in 1 until treeTable[nextX].size) {
                    // treeTable내로 범위 한정
                    treeList.addFirst(Tree(nextX, nextY, nextZ))
                }
            }
        }
        // 겨울
        for (i in 1 until yangTable.size) {
            for (j in 1 until yangTable[i].size) {
                treeTable[i][j] += yangTable[i][j]
            }
        }

        currentYear++
    }
    println(treeList.size)
}

/*
M : 산 나무 갯수

봄 : 나무가 자신의 나이만큼 양분을 먹고 나이 + 1
한칸에 나무가 여러개면 제일 적은 나이의 나무 부터 양분 먹음.
양분을 못먹으면 바로 죽음

여름 : 봄에 죽은 나무가 양분이 됨.
죽은 나무마다 나이를 2로 나눈 값이 나무가 있던 칸에 양분으로 추가됨.

가을 : 나무가 번식
번식하는 나무는 나이가 5의 배수
인접한 8개의 칸에 나이가 1인 나무가 생김
어떤 칸 (r, c)와 인접한 칸은 (r-1, c-1), (r-1, c), (r-1, c+1),
 (r, c-1), (r, c+1), (r+1, c-1), (r+1, c), (r+1, c+1) 이다.

 겨울 S2D2가 땅을 돌아다니면서 땅에 양분을 추가.
 */
