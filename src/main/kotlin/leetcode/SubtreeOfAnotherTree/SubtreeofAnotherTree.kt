package leetcode

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

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun main() {
    val sol = Solution2()

    println(sol.isSubtree(root = makeTree(), subRoot = makeSubTree()))
}

class Solution2 {

    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if (isSame(root, subRoot))return true

        return root != null && (isSame(root?.left, subRoot) || isSame(root?.right, subRoot))
    }

    fun isSame(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if (root == null && subRoot == null) {
            return true
        }
        if (root == null || subRoot == null) {
            return false
        }
        if (root.`val` != subRoot.`val`) {
            return false
        }
        // val이 같다면
        return isSame(root?.left, subRoot?.left) && isSame(root?.right, subRoot?.right)
    }
}

fun makeTree(): TreeNode {
    val treeNode = TreeNode(3)
    treeNode.left = TreeNode(4)
    treeNode.right = TreeNode(5)

    treeNode.left?.left = TreeNode(1)
    treeNode.right?.left = TreeNode(2)

    return treeNode
}

fun makeSubTree(): TreeNode {
    val treeNode = TreeNode(4)
    treeNode.left = TreeNode(1)
    treeNode.right = TreeNode(2)

    return treeNode
}
