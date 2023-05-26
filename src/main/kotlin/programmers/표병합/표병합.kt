package programmers.표병합

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
    val solution = Solution()
    solution.solution(
        commands = arrayOf(
//                "UPDATE 1 1 menu", "UPDATE 1 2 category", "UPDATE 2 1 bibimbap", "UPDATE 2 2 korean", "UPDATE 2 3 rice", "UPDATE 3 1 ramyeon", "UPDATE 3 2 korean", "UPDATE 3 3 noodle", "UPDATE 3 4 instant", "UPDATE 4 1 pasta", "UPDATE 4 2 italian", "UPDATE 4 3 noodle", "MERGE 1 2 1 3", "MERGE 1 3 1 4", "UPDATE korean hansik", "UPDATE 1 3 group", "UNMERGE 1 4", "PRINT 1 3", "PRINT 1 4"
//            "UPDATE 1 1 a", "UPDATE 1 2 b", "UPDATE 2 1 c", "UPDATE 2 2 d", "MERGE 1 1 1 2", "MERGE 2 2 2 1", "MERGE 2 1 1 1", "PRINT 1 1", "UNMERGE 2 2", "PRINT 1 1"
//            "UPDATE 1 1 A", "UPDATE 2 2 B", "UPDATE 3 3 C", "UPDATE 4 4 D", "MERGE 1 1 2 2", "MERGE 3 3 4 4", "MERGE 1 1 4 4", "UNMERGE 3 3", "PRINT 1 1", "PRINT 2 2", "PRINT 3 3", "PRINT 4 4"
            "UPDATE 1 1 menu", "MERGE 1 1 1 2", "MERGE 1 1 1 3", "MERGE 1 1 1 4", "MERGE 1 2 1 3", "UPDATE 1 1 hansik", "PRINT 1 1", "PRINT 1 2", "PRINT 1 3", "PRINT 1 4"
        )
    ).forEach {
        println(it)
    }
}

data class Vertex(
    val r: Int,
    val c: Int
)

data class Item(
    val value: String,
    val parent: Vertex
)
class Solution {
    lateinit var table: Array<Array<Item>>
    fun solution(commands: Array<String>): Array<String> {
        var answer = arrayListOf<String>()
        table = Array(51) { r ->
            Array(51) { c ->
                Item(
                    "",
                    Vertex(r, c)
                )
            }
        }

        var count = 0
        for (i in commands) {
            val str = i.split(" ")
            when (str.size) {
                4 -> {
                    // r, c , value
                    val r = str[1].toInt()
                    val c = str[2].toInt()
                    val value = str[3]
                    // 참조가 있는가?
                    if (table[r][c].parent.r == r && table[r][c].parent.c == c) {
                        // 참조가 없는경우
                        table[r][c] = table[r][c].copy(value = value)
                    } else {
                        // 참조가 있는 경우 루트의 값을 변경한다.
                        val parent = findParent(r, c)
                        table[parent.r][parent.c] = table[parent.r][parent.c].copy(
                            value = value
                        )
                    }
                }
                3 -> { // UPDATE value1 value2 or PRINT or UnMerge
                    val type = str[0]

                    when (type) {
                        "PRINT" -> {
                            count++
                            val r = str[1].toInt()
                            val c = str[2].toInt()
                            val parent = table[r][c].parent
                            if (parent.r == r && parent.c == c) {
                                if (table[r][c].value == "") {
                                    answer.add("EMPTY")
                                } else {
                                    answer.add(table[r][c].value)
                                }
                            } else {
                                val parent = findParent(r, c)
                                if (table[parent.r][parent.c].value == "") {
                                    answer.add("EMPTY")
                                } else {
                                    answer.add(table[parent.r][parent.c].value)
                                }
                            }
                        }
                        "UNMERGE" -> {
                            val r = str[1].toInt()
                            val c = str[2].toInt()
                            val parent = findParent(r, c)
                            val value = table[parent.r][parent.c].value

                            for (u in table.indices) {
                                for (j in table[u].indices) {
                                    if (table[u][j].parent == parent) {
                                        table[u][j] = table[u][j].copy(
                                            value = "",
                                            parent = Vertex(u, j)
                                        )
                                    }
                                }
                            }

                            table[r][c] = table[r][c].copy(value = value)
                        }
                        "UPDATE" -> {
                            val value1 = str[1]
                            val value2 = str[2]
                            for (i in table.indices) {
                                for (j in table[i].indices) {
                                    if (table[i][j].value == value1) {
                                        table[i][j] = table[i][j].copy(
                                            value = value2
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
                5 -> { // MERGE 1 2 1 3
                    val r = str[1].toInt()
                    val c = str[2].toInt()

                    val targetR = str[3].toInt()
                    val targetC = str[4].toInt()

                    if (r == targetR && c == targetC) {
                        // 같다면 무시
                        continue
                    }

                    val rcParent = findParent(r, c)
                    val targetParent = findParent(targetR, targetC)

                    if (table[rcParent.r][rcParent.c].value == "" && table[targetParent.r][targetParent.c].value != "") {
                        table[rcParent.r][rcParent.c] = table[rcParent.r][rcParent.c].copy(
                            parent = Vertex(targetParent.r, targetParent.c)
                        )
                    } else if (table[rcParent.r][rcParent.c].value != "" && table[targetParent.r][targetParent.c].value == "") {
                        table[targetParent.r][targetParent.c] = table[targetParent.r][targetParent.c].copy(
                            parent = Vertex(rcParent.r, rcParent.c)
                        )
                    }

                    if (table[rcParent.r][rcParent.c].value != "" && table[targetParent.r][targetParent.c].value != "") {
//                        table[r][c] = table[r][c].copy(parent = Vertex(rcParent.r, rcParent.c))
                        findParentCopy(r, c, rcParent.r, rcParent.c)
                        table[targetParent.r][targetParent.c] = table[targetParent.r][targetParent.c].copy(
                            parent = Vertex(rcParent.r, rcParent.c)
                        )
                    }
                }
            }
        }

        return answer.toTypedArray()
    }
    fun findParent(r: Int, c: Int): Vertex {
        var result = Vertex(r, c)
        val parent = table[r][c].parent
        if (parent.r == r && parent.c == c) {
            // 자기자신인 경우
        } else {
            result = findParent(parent.r, parent.c)
        }
        return result
    }

    fun findParentCopy(r: Int, c: Int, changeR: Int, changeC: Int) {
        val parent = table[r][c].parent
        if (parent.r == r && parent.c == c) {
            // 자기자신인 경우
        } else {
            table[r][c] = table[r][c].copy(parent = Vertex(changeR, changeC))
            findParent(parent.r, parent.c)
        }
    }
}

/*
50 * 50
각 셀은 문자열 값을 가질 수 있고, 다른 셀과 병합할 수 있다.
1. "UPDATE r c value"
r,c위치를 선택 후 그 값을 value로 변경


2. "UPDATE value1 value2
value1을 값으로 가지고 있는 모든 셀을 value2로 변경

3. "MERGE r1 c1 r2 c2
r1, c1 위치의 셀과 r2,c2 위츼의 셀을 선택하여 병합한다.
두개의 셀이 같은 셀일 경우 무시.
두 셀중 한 셀이 값을 가지고 있을 경우 병합된 셀은 그 값을 가진다.
두 셀 모두 같은 값을 가지고 있을 경우 셀은 r1, c1 위치의 셀 값을 가진다.
이후 r1, c1와 r2,c2 중 어느 위치를 선택해도 병합된 셀로 접근한다.


 */
