package programmers.solution

/**
 * @desc
 *rows x columns 크기인 행렬이 있습니다.
 * 행렬에는 1부터 rows x columns까지의 숫자가 한 줄씩 순서대로 적혀있습니다.
 * 이 행렬에서 직사각형 모양의 범위를 여러 번 선택해, 테두리 부분에 있는 숫자들을 시계방향으로
 * 회전시키려 합니다. 각 회전은 (x1, y1, x2, y2)인 정수 4개로 표현하며,
 * 그 의미는 다음과 같습니다.
x1 행 y1 열부터 x2 행 y2 열까지의 영역에 해당하는 직사각형에서 테두ㅒ리에 있는 숫자들을
한 칸씩 시계방향으로 회전합니다.
다음은 6 x 6 크기 행렬의 예시입니다.
 * @input
 *
 * @output
 *
 * @example
 *
 */

/*
제한사항 :
2 <= rows <= 100
2 <= columns <= 100

아무 회전도 하지 않았을 때, i행 j열에 있는 숫자는 ((i-1) * columns + j) 라고한다.

회전의 갯수 1<= queries <= 10000
queries 4개의 정수 [x1, y1, x2, y2]
x1행 y1 열부터 x2행 y2열까지의 영역의 테두리를 시계바향으로 회전한다는 뜻이였다.


3	3	[[1,1,2,2],[1,2,2,3],[2,1,3,2],[2,2,3,3]]	[1, 1, 5, 3]
 */

fun main() {
    val rows = 3
    val columns = 3
    val queries = arrayOf(intArrayOf(1, 1, 2, 2), intArrayOf(1, 2, 2, 3), intArrayOf(2, 1, 3, 2), intArrayOf(2,2,3,3))
    val solution = Solution10()
    println(
        solution.solution(rows, columns, queries).forEach {
            println(it)
        }
    )
}

class Solution10 {
    fun solution(rows: Int, columns: Int, queries: Array<IntArray>): IntArray {
        var answer = intArrayOf()
        val table = Array<Array<Int>>(rows + 1) {
            Array<Int>(columns + 1) { 0 }
        }
        var arr = arrayListOf<Int>()
        for (i in table.indices) {
            for (j in table[i].indices) {
                table[i][j] = ((i - 1) * columns + j)
            }
        }
        for (i in queries) {
            transform(i, table, arr)
        }
        answer = arr.toIntArray()
        return answer
    }

    fun transform(query: IntArray, table: Array<Array<Int>>, arr: ArrayList<Int>) {
        val x1 = query[0]
        val y1 = query[1]
        val x2 = query[2]
        val y2 = query[3]
        var temp = table[x1][y2]
        var temp2 = table[x2][y2]
        var min = Integer.MAX_VALUE
        for (i in y2 downTo y1) {
            if (i >= y1 + 1) {
                table[x1][i] = table[x1][i - 1]
                if (min > table[x1][i - 1]) {
                    min = table[x1][i - 1]
                }
            }
        }
        for (i in x2 downTo x1) {
            if (i > x1 + 1) {
                table[i][y2] = table[i - 1][y2]
                if (min > table[i - 1][y2]) {
                    min = table[i - 1][y2]
                }
            }

            if (i == x1 + 1) {
                table[i][y2] = temp
                if (min > temp) {
                    min = temp
                }
            }
        }
        temp = table[x2][y1] // temp 썻으니까 수정
        for (i in y1..y2) {
            if (i < y2 - 1) {
                table[x2][i] = table[x2][i + 1]
                if (min > table[x2][i + 1]) {
                    min = table[x2][i + 1]
                }
            }

            if (i == y2 - 1) {
                table[x2][i] = temp2
                if (min > temp2) {
                    min = temp2
                }
            }
        }
        for (i in x1..x2) {
            if (i < x2 - 1) {
                table[i][y1] = table[i + 1][y1]
                if (min > table[i + 1][y1]) {
                    min = table[i + 1][y1]
                }
            }

            if (i == x2 - 1) {
                table[i][y1] = temp
                if (min > temp) {
                    min = temp
                }
            }
        }
        arr.add(min)
    }
}
