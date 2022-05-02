package programmers.solution

import kotlin.system.measureTimeMillis

/**
 * @desc
가로 길이가 Wcm, 세로 길이가 Hcm인 직사각형 종이가 있습니다.
종이에는 가로, 세로 방향과 평행하게 격자 형태로 선이 그어져 있으며,
모든 격자칸은 1cm x 1cm 크기입니다. 이 종이를 격자 선을 따라 1cm × 1cm의
정사각형으로 잘라 사용할 예정이었는데, 누군가가 이 종이를 대각선 꼭지점 2개를 잇는 방향으로
잘라 놓았습니다. 그러므로 현재 직사각형 종이는 크기가 같은 직각삼각형 2개로 나누어진 상태입니다.
새로운 종이를 구할 수 없는 상태이기 때문에, 이 종이에서 원래 종이의 가로,
세로 방향과 평행하게 1cm × 1cm로 잘라 사용할 수 있는 만큼만 사용하기로 하였습니다.
가로의 길이 W와 세로의 길이 H가 주어질 때, 사용할 수 있는 정사각형의 개수를 구하는 solution
함수를 완성해 주세요.
 * @input
 *
 * @output
 *
 * @example
 * w= 8 , h =12 , result = 80
 * 8과 세로를 최대공약수로 나누었을 때 (2,3)을 얻을 수 있다.
 * (0,0) 부터 (2,3)까지 좌표를 보면 사용못하는 갯수는 4개를 얻을 수 있다
 * 2(가로) + 3(세로) -1(최대공약수) = 4개
 * (0,0) 부터 (4,6)을 확인해봤을 때
 * 4(가로) + 6(세로) - 2(최대공약수) = 8개
 * 그렇다면
 * 8(가로) + 12(세로) - 4(최대공약수)  = 16 답은 96- 16 = 80이 된다.
 */

fun main() {
    val w = 8
    val h = 12
    val solution = Solution9()
    val result = measureTimeMillis {
        println(solution.solution(w, h))
    }
    println(result)
}

class Solution9 {
    fun solution(w: Int, h: Int): Long {

        var answer = 0L
        var greatestDivisor = 0L
        if (w < h) {
            greatestDivisor = gcd(h.toLong(), w.toLong())
        } else {
            greatestDivisor = gcd(w.toLong(), h.toLong())
        }

        answer = (w.toLong() * h.toLong()) - (w.toLong() + h.toLong() - greatestDivisor)

        return answer
    }

    // 최대 공약수
    fun gcd(a: Long, b: Long): Long = if (b != 0L) gcd(b, a % b) else a
}
