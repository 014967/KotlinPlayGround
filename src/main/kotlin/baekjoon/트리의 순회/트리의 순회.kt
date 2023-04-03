//package baekjoon.`트리의 순회`
//
//import java.io.BufferedReader
//import java.io.InputStreamReader
//
///**
// * @desc
// *
// * @input
// *
// * @output
// *
// * @example
// *
// */
//
//data class TreeNode<T>(
//    val data: T,
//    var leftNode: TreeNode<T>? = null,
//    var rightNode: TreeNode<T>? = null
//)
//
//lateinit var inOrder: List<Int>
//lateinit var postOrder: List<Int>
//lateinit var nodeList: ArrayList<Int>
//var leftCount = 0
//fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
//    val n = readLine().toInt()
//
//    inOrder = readLine().split(" ").map { it.toInt() }
//    postOrder = readLine().split(" ").map { it.toInt() }
//    nodeList = arrayListOf<Int>()
//
//    val last = postOrder.last()
//    val root = TreeNode(last)
//    val tree = Tree()
//    tree.root = root
//
//    val leftTree = Tree()
//
//    val rightTree = Tree()
//
//    val rootIndex = inOrder.indexOf(last)
//
//    // leftTree
//
//    for (i in rootIndex - 1 downTo 0) {
//        leftTree.addData(postOrder[i], rootIndex)
//
//        if (i != rootIndex - 1) {
//            val inOrderIndex = inOrder.indexOf(postOrder[i + 1])
//            if (inOrderIndex - 1 >= 0) {
//                leftTree.addData(inOrder[inOrderIndex - 1], rootIndex)
//            }
//        }
//    }
//    for (i in n - 2 downTo rootIndex) {
//        rightTree.addData(postOrder[i], rootIndex)
//
//        if (i != n - 2) {
//            val inOrderIndex = inOrder.indexOf(postOrder[i + 1])
//            if (inOrderIndex - 1 >= rootIndex) {
//                leftTree.addData(inOrder[inOrderIndex - 1], rootIndex)
//            }
//        }
//    }
//    tree.root?.leftNode = leftTree.root
//    tree.root?.rightNode = rightTree.root
//
//    nodeList.add(tree.root?.data!!)
//    tree.preOrder(tree.root!!)
//
//    println(nodeList.joinToString(" ") { it.toString() })
//}
//
//class Tree {
//
//    var root: TreeNode<Int>? = null
//
//    fun addData(data: Int, rootIndex: Int) {
//        if (root == null) {
//            root = TreeNode(data)
//        } else {
//            searchAndLink(data, root!!)
//        }
//    }
//
//    fun searchAndLink(data: Int, root: TreeNode<Int>) {
//        if (root.data == data) {
//            return
//        }
//        if (root.rightNode == null) {
//            root.rightNode = TreeNode(data)
//        } else {
//            if (root.leftNode == null) {
//                root.leftNode = TreeNode(data)
//            } else {
//                if (data == root.leftNode!!.data) {
//                    return
//                }
//                if (data == root.rightNode!!.data) {
//                    return
//                }
//                searchAndLink(data, root.rightNode!!)
//            }
//        }
//    }
//
//    fun preOrder(root: TreeNode<Int>) {
//        if (root.leftNode != null) {
////            println(root.leftNode!!.data)
//            nodeList.add(root.leftNode!!.data)
//            preOrder(root.leftNode!!)
//        }
//        if (root.rightNode != null) {
////            println(root.rightNode!!.data)
//            nodeList.add(root.rightNode!!.data)
//            preOrder(root.rightNode!!)
//        }
//    }
//}
//
///*
//In-Order 중위 순회
//left Node -> root Node -> rightNode
//
//Post-Order 후위 순회
//left Node -> rightNode -> root Node
//
//Pre-Order 전위 순회
//root Node -> left Node -> right Node
// */
