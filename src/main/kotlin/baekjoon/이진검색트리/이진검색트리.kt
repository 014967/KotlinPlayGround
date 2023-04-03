package baekjoon.이진검색트리

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

fun main(): Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    val nodeList = arrayListOf<String>()
    while (true) {
        val node: String = readLine() ?: break
        nodeList.add(node)
    }
    val tree = Tree()
    for (i in nodeList) {
        tree.add(i.toInt())
    }
    tree.root?.let { tree.postOrder(it) }
}

data class TreeNode<T>(
    var data: T,
    var left: TreeNode<T>? = null,
    var right: TreeNode<T>? = null
)

class Tree {
    var root: TreeNode<Int>? = null
    fun add(data: Int) {
        if (root == null) {
            root = TreeNode(data)
        } else {
            searchAndLink(root!!, data)
        }
    }
    private fun searchAndLink(root: TreeNode<Int>, data: Int) {
        if (root.data > data) {
            if (root.left == null) {
                root.left = TreeNode(data)
            } else {
                searchAndLink(root.left!!, data)
            }
        } else if (root.data < data) {
            if (root.right == null) {
                root.right = TreeNode(data)
            } else {
                searchAndLink(root.right!!, data)
            }
        }
    }

    fun postOrder(root: TreeNode<Int>) {
        if (root.left != null) postOrder(root.left!!)
        if (root.right != null) postOrder(root.right!!)
        println(root.data)
    }
}
