package baekjoon.solution2828

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * @desc
 * 바구니를 옮기는 오래된 게임을 하는데 스크린은 N칸으로 나뉘어져 잇음.
 * 스크린의 아래쪽에는 M칸을 차지하는 바구니가 있음.(  m < n)
 * 플레이어는 게임을 하는 중에 바구니를 왼쪽이나 오른쪽으로 이동할 수 있음.
 * 하지만 바구니는 스크린의 경게를 넘어가서는안됨. 가장 처음에 바구니는 왼쪽 M칸을 차지하고 있음
 *
 * 스크린 위에서 사과 여러개가 떨어짐. 각 사과는 N칸중 한 칸의 상단에서 떨어지기 시작하며,
 * 스크린의 바닥에 닿을때까지 직선으로 떨어진다.
 * 한 사과가 바닥에 닿는 즉시, 다른 사과가 떨어지기 시작한다.
 *
 * 바구니가 사과가 떨어지는 칸을 차지하고 있다면, 바구니는 그 사과가 바닥에 닿을때, 사과를 담을 수 있다
 * 상근이는 사과를 모두 담으려고 한다. 이 때 바구니의 이동거리의 최솟값을 구하는 프로램을 짜라
 *
 * @input
 * 첫째 줄에  n과 m이 주어지고, 둘째 줄에는 떨어지는 사과의 개수가 j가 주어진다.(1<= j <=20)
 * 다음 j개 줄에는 사과가 떨어지는 위치가 순서대로 주어진다.
 * @output
 * 모든 사과를 담기 위해서 바구니가 이동해야 하는 거리의 최솟값을 출력한다.
 * @example
 *
 */

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    var n = 0 // 스크린 크기
    var m = 0 // 바구니 크기
    readLine().split(" ").mapIndexed { index, value ->
        if (index == 0) {
            n = value.toInt()
        } else {
            m = value.toInt()
        }
    }
    val j = readLine().toInt()

    var screen = Array(n) { 0 }
    var beg = MutableList(2) { index: Int ->
        if (index == 0) {
            0
        } else {
            m - 1
        }
    }

    var count = 0 // 이동범위

    for (i in 1..j) {
        var appleIndex = readLine().toInt() - 1
        // 순서를 보장해야함.
        var begStart = beg[0]
        var begEnd = beg[1]
        if (begStart in screen.indices && begEnd in screen.indices) { // Screen의 범위 안에 있도록
            if (appleIndex in begStart..begEnd) { // 바로 케어가 가능하다면
            } else {
                // 바구니의 범위 안에 없다면
                if (appleIndex > begEnd) {
                    var endClose = Math.abs(begEnd - appleIndex)
                    beg[0] = beg[0] + endClose
                    beg[1] = beg[1] + endClose
                    count += endClose
                } else if (appleIndex < begStart) {
                    var startClose = Math.abs(begStart - appleIndex)
                    beg[0] = beg[0] - startClose
                    beg[1] = beg[1] - startClose
                    count += startClose
                }
            }
        }
    }
    println(count)
}

