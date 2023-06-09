package leetcode.KthSmallestElementInBst

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

fun main() {
    val sol = Solution()
    val tree = sol.makeTree()
    println(sol.kthSmallest(tree, 1))
}
class Solution {

    var count = 0
    var answer = -1
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun makeTree(): TreeNode {
        val treeNode = TreeNode(3)
        treeNode.left = TreeNode(1)
        treeNode.right = TreeNode(4)

        treeNode.left?.right = TreeNode(2)

        return treeNode
    }
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        inOrder(root, k)
        return answer
    }
    fun inOrder(root: TreeNode?, k: Int) {
        if (root?.left != null) inOrder(root.left, k)
        count++
        if (count == k && root != null) {
            answer = root.`val`
        }
        if (root?.right != null) inOrder(root.right, k)
    }
}
