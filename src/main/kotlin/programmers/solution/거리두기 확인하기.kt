package programmers.solution

import kotlin.math.abs

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
        arrayOf("PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP")
    )
    val solution12 = Solution12()
    println(solution12.solution(places))
}

class Solution12 {
    fun solution(places: Array<Array<String>>): IntArray {
        var answer: IntArray = IntArray(5) { 1 }

        for (i in places.indices) {
            var arr = Array(5) { CharArray(5) { '0' } }
            val pArr = arrayListOf<Pair<Int, Int>>()
            for (j in places[i].indices) {

                for (k in places[i][j].indices) {

                    arr[j][k] = places[i][j][k]

                    // p의 좌표만 따로 관리
                    if (places[i][j][k] == 'P') {
                        pArr.add(Pair(j, k))
                    }
                }
                // 거리두기확인
            }
            var check = true
            for (q in pArr.indices) {
                for (w in q + 1 until pArr.size) {
                    if (
                        (abs(pArr[q].first - pArr[w].first) + abs(pArr[q].second - pArr[w].second))
                        == 2
                        // 만약 맨해튼 거리가 2일 경우
                    ) {
                        // 1열
                        if (pArr[q].second == pArr[w].second) {
                            // 사이에 파티션이 있는지 확인
                            if (arr[pArr[q].first + 1][pArr[q].second] == 'O') {
                                check = false
                                break
                            }
                        }
                        // 1행
                        else if (pArr[q].first == pArr[w].first) {
                            // 사이에 파티션 확인
                            if (arr[pArr[q].first][pArr[q].second + 1] == 'O') {
                                check = false
                                break
                            }
                        } else {

                            // 대각
                            if (pArr[q].second == pArr[w].second + 1) {
                                // 왼쪽 대각
                                if (!(arr[pArr[q].first][pArr[w].second] == 'X' && arr[pArr[w].first][pArr[w].second + 1] == 'X')) {
                                    // 위 확인 오른쪽 확인
                                    check = false
                                    break
                                }
                            } else if (pArr[q].second == pArr[w].second - 1) {
                                // 오른쪽 대각
                                if (!(arr[pArr[w].first-1][pArr[w].second] == 'X' && arr[pArr[w].first][pArr[w].second - 1] == 'X')) {
                                    // 왼쪽 위 확인
                                    check = false
                                    break
                                }
                            }
                        }
                    } else if ((abs(pArr[q].first - pArr[w].first) + abs(pArr[q].second - pArr[w].second))
                        == 1
                        // 맨해튼 거리가 1일 경우
                    ) {
                        check = false
                        break
                    }
                }
                if (check == false)
                    break
            }
            if (check == false) {
                answer[i] = 0
            }
            // answer 입력
        }

        return answer
    }
}
