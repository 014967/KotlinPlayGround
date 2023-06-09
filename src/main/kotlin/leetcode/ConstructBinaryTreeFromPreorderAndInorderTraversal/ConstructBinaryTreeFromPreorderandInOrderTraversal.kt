package leetcode.ConstructBinaryTreeFromPreorderAndInorderTraversal

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

fun makeTree(): TreeNode {
    val treeNode = TreeNode(3)
    treeNode.left = TreeNode(1)
    treeNode.right = TreeNode(4)

    treeNode.left?.right = TreeNode(2)

    return treeNode
}

fun main() {
    val solution = Solution()

    val preOrder = intArrayOf(1, 2, 3)
    val inOrder = intArrayOf(3, 2, 1)
    println(solution.buildTree(preOrder, inOrder))
}

class Solution {
    var preIndex = 0
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        /*
        전위 순회의 경우 root -> left -> right순임
        중위 순회의 경우 left -> root -> right순임

        어떻게 하면 충별 순회로 변경할 수 있나요?
         */

        val tree = buildTreeWithIndex(preorder, inorder, 0, inorder.size)
        return tree
    }

    fun buildTreeWithIndex(
        preorder: IntArray,
        inorder: IntArray,
        leftIndex: Int,
        rightIndex: Int
    ): TreeNode? {
        if (preorder.isEmpty() && inorder.isEmpty()) {
            return null
        }

        if (leftIndex > rightIndex) {
            return null
        }

        if (preIndex >= preorder.size) {
            return null
        }

        val tree = TreeNode(preorder[preIndex++])

        val rootIndex = inorder.indexOf(tree.`val`)

        tree.left = buildTreeWithIndex(preorder, inorder, leftIndex, rootIndex - 1)

        tree.right = buildTreeWithIndex(preorder, inorder, rootIndex + 1, rightIndex)

        return tree
    }
}
