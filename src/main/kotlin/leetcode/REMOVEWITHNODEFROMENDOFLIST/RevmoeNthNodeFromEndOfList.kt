package leetcode.REMOVEWITHNODEFROMENDOFLIST

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
    for (i in 2..5) {
        createValue(i, listNode)
    }
    val sol = Solution()
    println(sol.removeNthFromEnd(listNode, 2))
}

fun createValue(`val`: Int, listNode: ListNode) {
    if (listNode.next == null) {
        listNode.next = ListNode(`val`)
    } else {
        createValue(`val`, listNode.next!!)
    }
}

class Solution {
    var size = 1
    var resultNode: ListNode? = null
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        if (head == null) {
            return null
        } else {
            var li = head
            var newHead = head
            recurFun(head)
            if (size == 1) {
                return null
            }
            if (size == 2) {
                if (n == 2) {
                    return li.next
                }
                if (n == 1) {
                    return ListNode(li.`val`)
                }
            }

            if (size == 3) {
                if (n == 1) {
                    li.next?.next = null
                    return li
                } else if (n == 2) {
                    li.next = li.next?.next
                    return li
                } else {
                    return li.next
                }
            }

            // 5 뒤에서 2번째라면 앞에서 4번째임 4번째를 삭제한다는거임.
            if (size == n) {
                return head.next
            }

            var targetIndex = size - n
            while (targetIndex != 0) {
                targetIndex--
                if (targetIndex == 0) {
                } else {
                    li = li?.next
                }

                newHead = newHead?.next
            }

            li?.next = newHead?.next

            return head
        }
    }

    fun recurFun(head: ListNode) {
        if (head.next != null) {
            size++
            recurFun(head.next!!)
            createValue(head.`val`, resultNode!!)
        } else {
            resultNode = ListNode(head.`val`)
        }
    }
}
