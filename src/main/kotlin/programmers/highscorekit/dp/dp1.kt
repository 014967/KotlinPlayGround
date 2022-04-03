package programmers.highscorekit.dp

/**
 * @desc
 * 아래와 같이 5와 사칙 연산만으로 12를 표현할 수 있다.
 * 12 = 5 + 5 + (5/5) + (5/5)
 * 12 = (55+ 5 ) /5
 * 이중 가낭 작은 경우는 4ㅣㅇ다.
 * 이처럼 숫자 N과 number가 주어질 때, N과 사칙연산만 사용해서 표현할 수있는 방법 중 N 사용홧수의 최솟값을 return해라
 * 제한사항
 * N은 1이상 9이하다
 * number는 1이상 32,000이하다
 * 수식에는 괄호와 사칙연산만 가능하면 나누기 연산에서 나머지는 무시한다
 * 최솟 값이 8보다 크면 -1을 return한다.
 * @input
 *
 * @output
 *
 * @example
 *
 */

fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val number = readLine().toInt()

    println(solution(N = N, number = number))
}
fun solution(N: Int, number: Int): Int {
    var answer = -1
    var result: ArrayList<Set<Int>> = ArrayList(emptySet())

    for (i in 0 until 8) {


        val currentResult = mutableSetOf(N.toString().repeat(i + 1).toInt())
        // N이 0부터 시작이므로, i+1만큼 이어붙여라

        // 이전 단계

        for (j in 0 until i) {
            for (case1 in result.get(j)) {
                for (case2 in result.get(i - 1 - j)) {
                    currentResult.add(case1 + case2)
                    currentResult.add(case1 - case2)
                    currentResult.add(case1 * case2)
                    if (case2 != 0) {
                        currentResult.add(case1 / case2)
                    }
                }
            }
        }

        result.add(currentResult)
        if (currentResult.contains(number)) {
            answer = i + 1
        }
    }

    return answer
}
