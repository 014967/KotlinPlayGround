package baekjoon.solution12865

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * @desc
이 문제는 아주 평범한 배낭에 관한 문제이다.
한 달 후면 국가의 부름을 받게 되는 준서는 여행을 가려고 한다.
세상과의 단절을 슬퍼하며 최대한 즐기기 위한 여행이기 때문에,
가지고 다닐 배낭 또한 최대한 가치 있게 싸려고 한다.
준서가 여행에 필요하다고 생각하는 N개의 물건이 있다.
각 물건은 무게 W와 가치 V를 가지는데, 해당 물건을 배낭에 넣어서
가면 준서가 V만큼 즐길 수 있다. 아직 행군을 해본 적이 없는 준서는
최대 K만큼의 무게만을 넣을 수 있는 배낭만 들고 다닐 수 있다.
준서가 최대한 즐거운 여행을 하기 위해 배낭에 넣을 수 있는
물건들의 가치의 최댓값을 알려주자.
 * @input
첫 줄에 물품의 수 N(1 ≤ N ≤ 100)과 준서가 버틸 수 있는 무게
K(1 ≤ K ≤ 100,000)가 주어진다.
두 번째 줄부터 N개의 줄에 거쳐 각 물건의
무게 W(1 ≤ W ≤ 100,000)와 해당 물건의
가치 V(0 ≤ V ≤ 1,000)가 주어진다.
입력으로 주어지는 모든 수는 정수이다.
 * @output
 *
 * @example
 *
 */

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val str = readLine().split(" ").map {
        it.toInt()
    }
    val n = str[0]
    val k = str[1] // 가방의 최대치

    // 행 : 갯수, 열 : 무게로 행렬을 만든다
    val arr = Array<Array<Int>>(n + 1) { Array(k + 1) { 0 } }
    var min = 100001
    for (i in 1..n) {
        val input = readLine().split(" ").map { it.toInt() }
        val something = input[0]
        val value = input[1]
        if (min > something) {
            min = something
        }
        for (j in min..k) {
            /*
            구하고자 하는 무게 : j
            새로들어온 무게 : something
            j - something : 4의 무게
            arr[i-1(전행)][4] = 8
            새로들어온 무게의 가치 = value
             */
            if (j in min until something) {
                // 최소 들어오는 물건의 무게가 비교가 필요없고 이전의 행의 값을 그대로 쓰는 경우
                arr[i][j] = arr[i - 1][j]
            } else {
                arr[i][j] = Math.max(value, arr[i - 1][j])
                if (j > something)
                    arr[i][j] = Math.max(arr[i][j], arr[i - 1][j - something] + value)
            }
        }
    }
    var max = 0
    for (i in arr) {
        if (max <i[k]) {
            max = i[k]
        }
    }
    println(max)
}
