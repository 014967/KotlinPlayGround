package baekjoon.solution1018

import kotlin.math.min

/**
 * @desc
 * 지민이는 자신의 저택에서 MN개의 단위 정사각형으로 나누어져 있는 M×N 크기의 보드를 찾았다.
 * 어떤 정사각형은 검은색으로 칠해져 있고, 나머지는 흰색으로 칠해져 있다.
 * 지민이는 이 보드를 잘라서 8×8 크기의 체스판으로 만들려고 한다.
 * 체스판은 검은색과 흰색이 번갈아서 칠해져 있어야 한다.
 * 구체적으로, 각 칸이 검은색과 흰색 중 하나로 색칠되어 있고, 변을 공유하는 두 개의 사각형은 다른 색으로 칠해져 있어야 한다.
 * 따라서 이 정의를 따르면 체스판을 색칠하는 경우는 두 가지뿐이다. 하나는 맨 왼쪽 위 칸이 흰색인 경우, 하나는 검은색인 경우이다.
 * 보드가 체스판처럼 칠해져 있다는 보장이 없어서, 지민이는 8×8 크기의 체스판으로 잘라낸 후에 몇 개의 정사각형을 다시 칠해야겠다고 생각했다.
 * 당연히 8*8 크기는 아무데서나 골라도 된다. 지민이가 다시 칠해야 하는 정사각형의 최소 개수를 구하는 프로그램을 작성하시오.
 * @input
 * 첫째 줄에 N과 M이 주어진다. N과 M은 8보다 크거나 같고, 50보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에는 보드의 각 행의 상태가 주어진다. B는 검은색이며, W는 흰색이다.
 * @output
 * 첫째 줄에 지민이가 다시 칠해야 하는 정사각형 개수의 최솟값을 출력한다.
 * @example
8 8
WBWBWBWB
BWBWBWBW
WBWBWBWB
BWBBBWBW
WBWBWBWB
BWBWBWBW
WBWBWBWB
BWBWBWBW
 ->>
1
10 13
BBBBBBBBWBWBW
BBBBBBBBBWBWB
BBBBBBBBWBWBW
BBBBBBBBBWBWB
BBBBBBBBWBWBW
BBBBBBBBBWBWB
BBBBBBBBWBWBW
BBBBBBBBBWBWB
WWWWWWWWWWBWB
WWWWWWWWWWBWB
->
12
 */

val array1 = Array(8) {
        i ->
    Array(8) {
        if (i % 2 == 0) {
            if (it % 2 == 0) {
                'B'
            } else {
                'W'
            }
        } else {
            if (it % 2 == 0) {
                'W'
            } else {
                'B'
            }
        }
    }
}
val array2 = Array(8) {
        i ->
    Array(8) {
        if (i % 2 == 0) {
            if (it % 2 == 0) {
                'W'
            } else {
                'B'
            }
        } else {
            if (it % 2 == 0) {
                'B'
            } else {
                'W'
            }
        }
    }
}
fun main() {
    val s = readLine()?.split(" ")?.toList()?.map {
        it.toInt()
    }
    if (s!!.isNotEmpty()) {
        val n = s[0]
        val m = s[1]
        solution(n, m)
    }
}
fun solution(n: Int, m: Int) {
    val table = Array(n) { i -> Array(m) { ' ' } }
    var result = Int.MAX_VALUE
    for (i in 0 until n) {
        val line = readLine()?.take(m)?.toList()
        if (line != null) {
            for (j in line.indices) {
                table[i][j] = line[j]
            }
        }
    }
    for (i in 0..table.size - 8) {
        for (j in 0..table[i].size - 8) {
            var count1 = 0
            var count2 = 0
            for (k in 0 until 8) {
                for (s in 0 until 8) {
                    if (table[i + k][j + s] != array1[k][s]) {
                        count1++
                    }
                    if (table[i + k][j + s] != array2[k][s]) {
                        count2 ++
                    }
                }
            }
            result = min(result, count1)
            result = min(result, count2)
        }
    }
    println(result)
}
