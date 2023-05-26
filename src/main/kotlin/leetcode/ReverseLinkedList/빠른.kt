package leetcode.validStack

import leetcode.ListNode

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

val listNode = ListNode(1)
fun main() {
    val sol = Solution2()

    for (i in 2..5) {
        createValue(i, listNode)
    }
    println(sol.reverseList(listNode))
}
fun createValue(`val`: Int, listNode: ListNode) {
    if (listNode.next == null) {
        listNode.next = ListNode(`val`)
    } else {
        createValue(`val`, listNode.next!!)
    }
}

class Solution2 {
     fun reverseList(head: ListNode?): ListNode? {
        if (head == null) return null

        var currentNode = head
        var previousNode: ListNode? = null
        var reversedNode: ListNode? = null

        while (currentNode != null) {
            val next = currentNode.next
            if (next == null) {
                reversedNode = currentNode
            }

            currentNode.next = previousNode
            previousNode = currentNode
            currentNode = next
        }
        return reversedNode
    }
}