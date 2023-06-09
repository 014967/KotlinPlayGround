package leetcode.ValidateBinarySearchTree

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
    val treeNode = TreeNode(5)
    treeNode.left = TreeNode(4)
    treeNode.right = TreeNode(6)

    treeNode.right?.left = TreeNode(3)
    treeNode.right?.right = TreeNode(7)

    return treeNode
}

fun main() {
    val tree = makeTree()

    val solution = Solution()

    println(solution.isValidBST(tree))
}

class Solution {

    var flag = true
    fun isValidBST(root: TreeNode?): Boolean {
        inOrder(root, null, null)
        return flag
    }
    fun inOrder(root: TreeNode?, min: Int?, max: Int?) {
        if (!flag) {
            return
        }
        if (root == null) {
            return
        }

        if (root.left != null) {
            if (max != null) {
                if( min != null){
                    if (root.`val` > root.left!!.`val` && root.`val` < max  && min < root.`val`) {
                        inOrder(root, min, root.`val`)
                    } else {
                        flag = false
                    }
                }else{
                    if (root.`val` > root.left!!.`val` && root.`val` < max ) {
                        inOrder(root, min, root.`val`)
                    } else {
                        flag = false
                    }
                }
            } else {
                if (root.`val` > root.left!!.`val`) {
                    inOrder(root.left, min, root.`val`)
                } else {
                    flag = false
                }
            }
        }

        if (!flag) {
            return
        }
        if (root.right != null) {
            if (min != null) {
                if (root.`val` < root.right!!.`val` && min < root.`val`) {
                    inOrder(root.right, root.`val`, max)
                } else {
                    flag = false
                }
            } else {
                if (root.`val` < root.right!!.`val`) {
                    inOrder(root.right, root.`val`, max)
                } else {
                    flag = false
                }
            }
        }
    }
}
