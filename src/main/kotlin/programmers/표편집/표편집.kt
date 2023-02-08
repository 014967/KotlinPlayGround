package programmers.표편집

import java.util.*

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
    val n = 8
    val k = 2
    val cmd = arrayOf("D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z") //arrayOf("D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C")
    val solution = Solution()
    println(solution.solution(n, k, cmd))
}

class Solution {
    fun solution(n: Int, k: Int, cmd: Array<String>): String {
        val stack = Stack<Int>()
        var current = k
        var size = n
        //
        for (query in cmd) {
            val key = query[0]

            when (key) {
                'U' -> { current -= query.substring(2).toInt() }
                'D' -> { current += query.substring(2).toInt() }
                'C' -> {
                    stack.push(current)
                    size--
                    if (current == size) current--
                }
                'Z' -> {
                    if (stack.pop() <= current) current++
                    size++
                }
            }
        }

        val sb = StringBuilder()
        for (i in 0 until size) {
            sb.append('O')
        }
        while (!stack.isEmpty()) {
            sb.insert(stack.pop().toInt(), 'X')
        }
        return sb.toString()
    }
}

data class DeletedRow(
    val rowNum: Int,
    val rowName: Int
)
//class Solution {
//    fun solution(n: Int, k: Int, cmd: Array<String>): String {
//        val answer = StringBuilder()
//
//        val currentStack = LinkedList<Int>()
//        val deleteStack = Stack<DeletedRow>()
//        val deleteArrList = arrayListOf<Int>()
//        var currentCursor = k
//        for (i in 0 until n) {
//            currentStack.addLast(i)
//        }
//
//        for (i in cmd) {
//            if (i == "C") {
//                val target = currentStack[currentCursor]
//                currentStack.removeAt(currentCursor)
//                deleteStack.add(DeletedRow(currentCursor, target))
//                deleteArrList.add(target)
//
//                if (currentCursor == currentStack.size) {
//                    currentCursor -= 1
//                }
//            } else if (i == "Z") {
//                val lastestTarget = deleteStack.pop()
//                deleteArrList.removeLast()
//                currentStack.add(lastestTarget.rowNum, lastestTarget.rowName)
//                if (lastestTarget.rowNum <= currentCursor) {
//                    currentCursor += 1
//                }
//
//                // 원래 인덱스에 넣는다?
//            } else {
//                val (c, x) = i.split(" ")
//
//                if (c == "U") {
//                    currentCursor -= x.toInt()
//                } else {
//                    currentCursor += x.toInt()
//                }
//            }
//        }
//
//        for (i in 0 until n) {
//            if (deleteArrList.indexOf(i) != -1) {
//                answer.append("X")
//            } else {
//                answer.append("O")
//            }
//        }
//        return answer.toString()
//    }
//}
/*
문제를 푸는 과정에서, 삽입이나 삭제를 실제로 진행하면 무조건 효율성에서 탈락하게 설정하신 것 같습니다


 */

