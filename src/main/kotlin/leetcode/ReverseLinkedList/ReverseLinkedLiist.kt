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

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

val listNode = ListNode(1)
fun main() {
    val sol = Solution()

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

class Solution {
    lateinit var resultNode: ListNode
    fun reverseList(head: ListNode?): ListNode? {
        if (head == null) {
            return null
        } else {
            val li = head
            recurFun(li)
        }
        return resultNode
    }
    fun recurFun(head: ListNode) {
        if (head.next != null) {
            recurFun(head.next!!)
            createValue(head.`val`, resultNode)
            println(resultNode)
        } else {
            resultNode = ListNode(head.`val`)
        }
    }
}
