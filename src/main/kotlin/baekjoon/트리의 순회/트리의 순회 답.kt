package baekjoon.`트리의 순회`

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
lateinit var inOrder: List<Int>
lateinit var postOrder: List<Int>
lateinit var inOrderIndex: IntArray
val bw = System.`out`.bufferedWriter()
val br = BufferedReader(InputStreamReader(System.`in`))
fun main(): Unit = with(br) {
    val n = readLine().toInt() // 번호 수
    inOrder = readLine().split(" ").map { it.toInt() }
    postOrder = readLine().split(" ").map { it.toInt() }

    // 후위 순회에서 마지막은 rootㅣㅁ
//    val root = postOrder.last()

//    inOrderIndex = IntArray(n) { 0 }
//
//    for (i in postOrder.indices) {
//        inOrderIndex[i] = inOrder.indexOf(postOrder[i])
//    }

    getRoot(0, n - 1, 0, n - 1)

//    println(arrList.joinToString(" ") { it.toString() })
    // 출력해야하는 것 전위순회
    // root -> left -> right

    // 중위 순회
    // left -> root -> right

    // 후위 순회
    // left -> right -> root

    // 전위 순회를 나타내 주기 위해서는
    // 중위 순회 한것을 left와 right를 나누어 루트값을 찾아가는것.

    bw.close()
}

fun getRoot(start: Int, end: Int, postStart: Int, postEnd: Int) {
    if (postStart > postEnd) return
    val rootIndexInOrder = inOrder.indexOf(postOrder[postEnd]) // 후위 순회의 마지막 값
//    arrList.add(inOrder[rootIndexInOrder])
//    print("${inOrder[rootIndexInOrder]} ")
    bw.write("${inOrder[rootIndexInOrder]} ")
    val leftSize = rootIndexInOrder - start

    getRoot(start, rootIndexInOrder - 1, postStart, postStart + leftSize - 1)

    getRoot(rootIndexInOrder + 1, end, postStart + leftSize, postEnd - 1)
}
