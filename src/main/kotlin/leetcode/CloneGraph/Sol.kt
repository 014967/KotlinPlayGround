package leetcode.CloneGraph

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

class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList<Node?>()
}

data class k(
    val x: Int,
    val y: Int
)

fun Node.copy(): Node {
    val neighbors = this.neighbors
    val newNode = Node(this.`val`).apply {
        this.neighbors = neighbors
    }
    return newNode
}

fun main() {
    val node = createNode()
    val sol = Solution()
    val result = sol.cloneGraph(node[0])
    println(result)
}

fun createNode(): List<Node> {
    val node1 = Node(1).apply {
        neighbors = arrayListOf(
            Node(2),
            Node(4)
        )
    }

    val node2 = Node(2).apply {
        neighbors = arrayListOf(
            Node(1),
            Node(3)
        )
    }
    val node3 = Node(3).apply {
        neighbors = arrayListOf(
            Node(2),
            Node(4)
        )
    }
    val node4 = Node(4).apply {
        neighbors = arrayListOf(
            Node(1),
            Node(3)
        )
    }

    node1.neighbors[0] = node2
    node1.neighbors[1] = node4

    node2.neighbors[0] = node1
    node2.neighbors[1] = node3

    node3.neighbors[0] = node2
    node3.neighbors[1] = node4

    node4.neighbors[0] = node1
    node4.neighbors[1] = node3

    return listOf(node1, node2, node3, node4)
}

/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var neighbors: ArrayList<Node?> = ArrayList<Node?>()
 * }
 */

/*
 node 1 의 이웃은 2,4
 node 2 의 이웃은 1,3
 node 3 의 이웃은 2,4
 node 4 의 이웃은 1,3
 */
class Solution {

    val checker = BooleanArray(101) { false }
    fun cloneGraph(node: Node?): Node? {
        if (node == null) {
            return null
        }
        if (checker[node.`val`]) {
            return null
        }

       val copyNode = Node(node.`val`)


        for (i in 0 until node.neighbors.size) {
            if (!checker[node.neighbors[i]!!.`val`]) {
                copyNode.neighbors.add(cloneGraph(node.neighbors[i]))
            }
        }
        return copyNode
    }
}
