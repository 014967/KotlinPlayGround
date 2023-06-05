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
    val treeNode = TreeNode(3)
    treeNode.left = TreeNode(1)
    treeNode.right = TreeNode(5)

    treeNode.left?.left = TreeNode(0)
    treeNode.left?.right=  TreeNode(2)
    treeNode.left?.right?.right = TreeNode(3)

    treeNode.right?.left= TreeNode(4)
    treeNode.right?.right = TreeNode(6)

    return treeNode
}

fun main() {
    val tree = makeTree()

    val solution = Solution()

    println(solution.isValidBST(tree))
}

class Solution {
    fun isValidBST(root: TreeNode?): Boolean {
        if (root == null) {
            return false
        }
        return isValidBstWithRoot(root.left, null, root.`val`) && isValidBstWithRoot(root.right, root.`val`, null)
    }

    private fun isValidBstWithRoot(root: TreeNode?, min: Int?, max: Int?): Boolean {
        if (root == null) {
            return true
        }
        if (min != null) {
            if (root.`val` <= min) {
                return false
            }
        }
        if (max != null) {
            if (max <= root.`val`) {
                return false
            }
        }
        // 이진트리인지아닌지를 판단하다.
        if (isLeafNode(root)) {
            return true
        } else {
            // 리프노드가 아니라면
            return isBinaryTree(root, min, max)
        }
    }

    private fun isLeafNode(root: TreeNode): Boolean {
        return root.left == null && root.right == null
    }

    private fun isBinaryTree(root: TreeNode, min: Int?, max: Int?): Boolean {
        if (min != null) {
            if (root.`val` <= min) {
                return false
            }
        }
        if (max != null) {
            if (root.`val` >= max) {
                return false
            }
        }
        if (root.left == null && root.right == null) {
            return true
        }

        if (root.left == null) {
            // 오른쪽만 확인하면돼
            if (min != null) {
                // 최소가 정해져있는경우
                if (min > root.`val`) {
                    // 최소가 더 크면 false
                    return false
                }
            }
            if (root.`val` > root.right!!.`val`) {
                // root보다 오른쪽이 더크면
                return false
            }
            // 다시 이진트리인지 검증
            return isBinaryTree(root.right!!, root.`val`, max)
        }
        if (root.right == null) {
            // 왼쪽만 확인하자.
            if (max != null) {
                if (max < root.`val`) {
                    return false
                }
            }
            if (root.`val` < root.left!!.`val`) {
                return false
            }
            return isBinaryTree(root.left!!, min, root.`val`)
        }

        // root.left와 root.right 둘다 null이 아닌경우
        if (max == null && min == null) {
            // max 와 min이 둘다 안정해져 있는 경우
            if (root.`val` < root.left!!.`val` || root.`val` > root.right!!.`val`) {
                return false
            }
        } else if (max != null && min != null) {
            // max와 min이 둘다 정해져 있는 경우
            if (root.left!!.`val` < min || root.right!!.`val` > max || root.`val` < root.left!!.`val` || root.`val` > root.right!!.`val`) {
                return false
            }
        } else if (min != null) {
            if (root.left!!.`val` < min || root.`val` < root.left!!.`val` || root.`val` > root.right!!.`val`) {
                return false
            }
        } else {
            if (root.right!!.`val` > max!! || root.`val` < root.left!!.`val` || root.`val` > root.right!!.`val`) {
                return false
            }
        }
        return isBinaryTree(root.left!!, min, root.`val`) && isBinaryTree(root.right!!, root.`val`, max)
    }
}
