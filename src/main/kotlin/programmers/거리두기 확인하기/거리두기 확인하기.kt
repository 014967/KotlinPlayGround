package programmers.`거리두기 확인하기`

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
    val places = arrayOf(
        arrayOf("POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"),
        arrayOf("POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"),
        arrayOf("PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"),
        arrayOf("OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"),
        arrayOf("PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"),
        arrayOf("POOOP", "OXXOX", "OXXPX", "OPXOX", "PXXXP")
    )
    val solution = Solution()
    println(solution.solution(places).joinToString { it.toString() })
}

val dx = listOf(-1, 1, 0, 0)
val dy = listOf(0, 0, 1, -1)

var arr: Array<List<Char>> = Array(1) { emptyList<Char>() }

data class Person(
    val x: Int,
    val y: Int
)
class Solution {

    fun solution(places: Array<Array<String>>): IntArray {
        val answer = IntArray(places.size) { 0 }
        arr = Array(5) { List(5) { ' ' } }

        for (i in places.indices) {
            val pList = arrayListOf<Person>()
            for (j in places[i].indices) {
                val arrList = arrayListOf<Char>()
                for (k in places[i][j].indices) {
                    if (places[i][j][k] == 'P') {
                        pList.add(Person(j, k))
                    }
                    arrList.add(places[i][j][k])
                }
                arr[j] = arrList
            }
            if (pList.size == 0) {
                answer[i] = 1
            } else {
                // 각 p좌표별로 거리두기 조건을 만족하는지 판단
                for (j in pList) {
                    if (check1(j) && check2(j) && check3(j)) {
                        answer[i] = 1
                    } else {
                        answer[i] = 0
                        break
                    }
                }
            }
        }
        return answer
    }

    fun check1(person: Person): Boolean {
        var flag = true

        for (i in 0..3) {
            val x = person.x + dx[i]
            val y = person.y + dy[i]
            // 4방항중 P가 존재할경우 false
            if (x in 0..4 && y in 0..4 && arr[x][y] == 'P') {
                flag = false
                break
            }
        }
        return flag
    }
    val ax = listOf(-1, -1, 1, 1)
    val ay = listOf(-1, 1, 1, -1)
    fun check2(person: Person): Boolean {
        // 대각 체크 로직
        var flag = true
        for (i in 0..3) {
            val x = person.x + ax[i]
            val y = person.y + ay[i]
            if (x in 0..4 && y in 0..4 && arr[x][y] == 'P') {
                when (i) {
                    // 새로운 좌표 기준
                    0 -> {
                        // 새로운 좌표 기준 아래나 오른쪽 확인
                        var flag1 = true
                        var flag2 = true
                        if (x + 1 <= 4 && arr[x + 1][y] != 'X') {
                            flag1 = false
                        }
                        if (y + 1 <= 4 && arr[x][y + 1] != 'X') {
                            flag2 = false
                        }
                        if (!flag1 || !flag2) {
                            flag = false
                            break
                        }
//                        if ((x + 1 <= 4 && arr[x + 1][y] != 'X') || (y + 1 <= 4 && arr[x][y + 1] != 'X')) {
//                            // 둘중 하나라도 파티션이 없는경우
//                            flag = false
//                            break
//                        }
                    }
                    1 -> {
                        // 새로운 좌표 기준 왼쪽, 아래
                        var flag1 = true
                        var flag2 = true

                        if (y - 1 >= 0 && arr[x][y - 1] != 'X') { // 왼쪽
                            flag1 = false
                        }
                        if (x + 1 <= 4 && arr[x + 1][y] != 'X') { // 아래
                            flag2 = false
                        }
                        if (!flag1 || !flag2) {
                            flag = false
                            break
                        }
//                        if ((x - 1 >= 0 && arr[x - 1][y] != 'X') || (y + 1 <= 4 && arr[x][y + 1] != 'X')) {
//                            flag = false
//                            break
//                        }
                    }
                    2 -> {
                        // 새로운 좌표 기준 왼쪽, 위에 확인
                        var flag1 = true
                        var flag2 = true

                        if (y - 1 >= 0 && arr[x][y - 1] != 'X') {
                            flag1 = false
                        }

                        if (x - 1 >=0 && arr[x - 1][y] != 'X') {
                            flag2 = false
                        }
//                        if ((y - 1 >= 0 && arr[x][y - 1] != 'X') || (x + 1 <= 4 && arr[x + 1][y] != 'X')) {
//                            flag = false
//                            break
//                        }
                        if (!flag1 || !flag2) {
                            flag = false
                            break
                        }
                    }
                    else -> {
                        // 새로운 좌표 기준 위, 오른쪽에 확인
                        var flag1 = true
                        var flag2 = true
                        if (x-1 >= 0 && arr[x-1][y] != 'X') {
                            flag1 = false
                        }
                        if (y + 1 <= 4 && arr[x][y+1] != 'X') {
                            flag2 = false
                        }
                        if (!flag1 || !flag2) {
                            flag = false
                            break
                        }
//                        if ((y - 1 >= 0 && arr[x][y - 1] != 'X') || (x - 1 >= 0 && arr[x - 1][y] != 'X')) {
//                            flag = false
//                            break
//                        }
                    }
                }
            }
        }
        return flag
    }

    val tx = listOf(2, -2, 0, 0)
    val ty = listOf(0, 0, 2, -2)
    fun check3(person: Person): Boolean {
        var flag = true
        for (i in 0..3) {
            val x = person.x + tx[i]
            val y = person.y + ty[i]
            // 새로운 좌표가 테이블의 범위를 넘어가지는 않는지
            if (x in 0..4 && y in 0..4 && arr[x][y] == 'P') {
                when (i) {
                    // 이전좌표와 현재 좌표 사이에 파티션이 존재하는지
                    0 -> {
                        // 새로운 좌표 기준 위쪽 확인이네
                        if (x - 1 >= 0 && arr[x - 1][y] != 'X') {
                            flag = false
                            break
                        }
                    }
                    1 -> {
                        // 새로운 좌표 기준 아래 확인
                        if (x + 1 <= 4 && arr[x + 1][y] != 'X') {
                            flag = false
                            break
                        }
                    }
                    2 -> {
                        // 새로운 좌표 기준 왼쪽 확인
                        if (y - 1 >= 0 && arr[x][y - 1] != 'X') {
                            flag = false
                            break
                        }
                    }
                    else -> {
                        // 새로운 좌표 기준 오른쪽 확인
                        if (y + 1 <= 4 && arr[x][y + 1] != 'X') {
                            flag = false
                            break
                        }
                    }
                }
            }
        }
        return flag
    }
}
