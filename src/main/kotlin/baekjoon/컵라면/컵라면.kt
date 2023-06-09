package baekjoon.컵라면

import java.io.BufferedReader
import java.io.InputStreamReader

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

data class Problem(
    val deadLine: Int,
    val ramen: Int
)


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()

    val checker = Array(n + 1) { 0L }

    var arr = Array(n + 1) { Problem(0, 0) }
    for (i in 1..n) {
        val (deadLine, ramen) = readLine().split(" ").map { it.toInt() }
        arr[i - 1] = arr[i - 1].copy(deadLine = deadLine, ramen = ramen)
    }
    arr.sortWith(comparator = Comparator<Problem> { o1, o2 -> o1.deadLine - o2.deadLine }.thenComparing { o1, o2 -> o1.ramen - o2.ramen })

    for (index in arr.size - 1 downTo 0) {
        val currentProblem = arr[index]
        if (checker[currentProblem.deadLine] == 0L) {
            checker[currentProblem.deadLine] = currentProblem.ramen.toLong()
        } else {
            for (deadLine in currentProblem.deadLine downTo 1) {
                if (checker[deadLine] == 0L) {
                    checker[deadLine] = currentProblem.ramen.toLong()
                    break
                } else {
                    if (checker[deadLine] < currentProblem.ramen) {
                        checker[deadLine] = currentProblem.ramen.toLong()
                        break
                    }
                }
            }
        }
    }
    println(checker.sum())
}

/*

데드라인 오름차순
만약 같다면 컵라면 오름 차순

1 1 2 2 3 3 6
6 7 4 5 1 2 1

뒤에서 부터 for문 돌려

deadLine이 6인 곳에 만약 값이 0이다 (초기화 0 )
array [6] = 1

array [3] = 0 이니까 2

array[3] != 0 그래서 이때는 여기서부터 다시 for문 1까지 돌림
그래서 빈 곳 0인곳에 넣어줌
array[2] = 1

array[2] 를 봤는데 이미 1이 들어가있네? 근데 ramen이 더큼
교체함
array[2] = 5

for ramen 4인값에는 array[2] = 5가 있으니까
1에 넣어줌
array[1] = 4

array[6] = 1
array[3] = 2
array[2] = 5
array[1] = 7

= 15 이게 4%에서 통과를 못해






 */