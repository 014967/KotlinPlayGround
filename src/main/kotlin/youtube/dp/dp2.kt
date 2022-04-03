package youtube.dp

import java.lang.Integer.min

/**
 * @desc
 * 정수가 X가 주어졌을때, 정수 X에 사용할 수 있는 연산은 다음과 같이 4가지입니다.
 * 1. X가 5로 나누어 떨어지면, 5로 나눕니다.
 * 2. X가 3으로 나누어 떨어지면 ,3으로 나눕니다.
 * 3. X가 2로 나누어 떨어지면, 2로 나눕니다.
 * 4. X에서 1을 뺍니다
 *
 * 정수 X가 주어졌을 때 ,연산 4개를 적절히 사용해서 값을 1로 만들고자 합니다.
 * 연산을 사용하는 횟수의 최솟값을 출력하세요
 * 예를 들어 정수가 26이면 다음과 같이 계산해서 3번의 연산이 최솟 값입니다.
 * @input
 *
 * @output
 *
 * @example
 *
 */

fun main() {
    val N = readLine()?.toInt()
    if (N != null) {
        require(N in 1..30000)
        solution(N)
    }
}
private fun solution(N: Int): Int {
    var answer = 0
    var d = List<Int>(30000) { 0 }.toMutableList()
    for (i in 2..N) {
        // 현재의 수에서 1을 빼는 경우
        d[i] = d[i - 1] + 1
        if (i % 2 == 0) {
            d[i] = min(d[i], d[i / 2] + 1) // i로 나누었을 때의 optimal solution
        }
        if (i % 3 == 0) {
            d[i] = min(d[i], d[i / 3] + 1)
        }
        if (i % 5 == 0) {
            d[i] = min(d[i], d[i / 5] + 1)
        }
    }
    println(d[N])

    return answer
}

/*
 위의 구조를 트리 구조로 만들어 보자
 N보다 더 작은 값들이 사용된다는 점에서 최적 부분 구조가 생긴다
 N을 5로 나눈 최적의 해, N을 3으로 나눈 최적의 해, N을 2로 나눈 최적의 해
 이 문제는 단순한 그리디 문제가 아니라,
 다른 연산을 적절히 섞어서, 연산이 작은 것으로 만들 수도 있다.

 a_i = i 를 1로 만드는 기 위한 최소 연산 횟수
 a_i = min(a_(i-1), a_(i/2) , a_(i/3), a_(i/5)) + 1
   각각 1을 뺏을 때의 최적의 해, 2로 나누었을 때 최적의 해, 3으로 나누었을 때 최적의 해, 5로 나누었을 때 최적의 해

단 ,1을 빼는 연산을 제외하고는 해당 수로 나누어떨어질 대에 한해 점화식을 적용할 수 있다.
 */
/*
private fun getAnswer(N: Int, answer: Int): Int {
    var n = N
    var ans = answer
    if (n == 1)
        return ans
    else {
        if (n / 5 > 0) {
            n = (n / 5) * 5
            ans = N - n
            while (n != 1) {
                n = n / 5
                ans++
            }
        } else if (n / 3 > 0) {
            n = (n / 3) * 3
            ans = N - n
            while (n != 1) {
                n = n / 3
                ans++
            }
        } else if (n / 2 > 0) {
            n = (n / 2) * 2
            ans = N - n
            while (n != 1) {
                n = n / 2
                ans++
            }
        }
    }
    return ans
}
 */
