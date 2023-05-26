package leetcode.MergeTwoSortedLists

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

fun createValue(`val`: Int, listNode: ListNode) {
    if (listNode.next == null) {
        listNode.next = ListNode(`val`)
    } else {
        createValue(`val`, listNode.next!!)
    }
}

val list1 = ListNode(1)
val list2 = ListNode(1)
fun main() {
    createValue(2, list1)
    createValue(4, list1)

    createValue(3, list2)
    createValue(4, list2)

    val sol = Solution()
    println(sol.mergeTwoLists(list1, list2))
}
class Solution {

    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        val li = ListNode(0)
        if (list1 == null && list2 == null) {
            return null
        } else if (list1 == null && list2 != null) {
            return list2
        } else if (list1 != null && list2 == null) {
            return list1
        } else {
            var currentList1 = list1
            var currentList2 = list2

            var currentNode = li

            while (currentList1 != null || currentList2 != null) {
                if (currentNode.next == null) {
                    if (currentList1 == null && currentList2 != null) {
                        currentNode.next = currentList2
                        break
                    }

                    if (currentList1 != null && currentList2 == null) {
                        currentNode.next = currentList1
                        break
                    }

                    if (currentList1 != null && currentList2 != null) {
                        if (currentList1.`val` < currentList2.`val`) {
                            currentNode.next = ListNode(currentList1.`val`)
                            currentList1 = currentList1.next
                        } else {
                            currentNode.next = ListNode(currentList2.`val`)
                            currentList2 = currentList2.next
                        }
                        currentNode = currentNode.next!!
                    }
                }
            }
        }
        return li.next
    }
}
