package leetcode.`Reorder-list`

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

fun main() {
    val head = ListNode(1)
    val sol = Solution()
    for (i in listOf(2, 3, 4,5,6,7)) {
        sol.createValue(i, head)
    }

    println(sol.reorderList(head))
}

class Solution {

    fun createValue(`val`: Int, listNode: ListNode) {
        if (listNode.next == null) {
            listNode.next = ListNode(`val`)
        } else {
            createValue(`val`, listNode.next!!)
        }
    }

    var reverseHead: ListNode? = null
    var size = 0
    fun reorderList(head: ListNode?) {
        if (head == null) {
            return
        }

        recurFun(head)

        if (size == 1) {
            return
        }

        if (size == 2) {
            return
        }

        if (size == 3) {
            val temp = head.next // 2 ,nextNode !=null
            val tempNext = temp?.next // 3 , null
            head.next = tempNext
            temp?.next = null
            head.next?.next = temp

            return
        }

        var originHead = head
        var swipeCount = size-1

        while (swipeCount != 0) {
            val temp = originHead?.next

            swipeCount--
            if (swipeCount == 0) {
                temp?.next = null
                break
            }
            originHead?.next = reverseHead
            reverseHead = temp
            originHead = originHead?.next
        }
    }
    private fun recurFun(head: ListNode) {
        if (head.next != null) {
            recurFun(head.next!!)
            size++
            createValue(head.`val`, reverseHead!!)
        } else {
            size++
            reverseHead = ListNode(head.`val`)
        }
    }
}
