package baekjoon.나무자르기

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

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val line1 = readLine().split(" ").map { it.toInt() }

    val n = line1[0]
    val m = line1[1]
    require(n in 1..1000000) // n 나무의 수
    require(m in 1..2000000000) // m 가져가져라는 나무의 길이

    val arrList = arrayListOf<Int>()
    readLine().split(" ").forEach { s ->
        arrList.add(s.toInt())
    }
    arrList.sort()

    var low = 0
    var high = arrList.last()

    while (low <= high) {
        val mid = (low + high) / 2
        var sum = 0.0
        for (i in 0 until n) {
            if (arrList[i] > mid) {
                sum += arrList[i] - mid
            }
        }
        if (sum >= m) {
            low = mid + 1
        } else {
            high = mid - 1
        }
    }
    println(high)

    // 자르니까 오른쪽 배열만 확인하면 될꺼같은데?
    // 별도로 가지고 있어야한다.
}
/*
나무 M미터가 필요하다.

1. 절단디에 높이 H를 지정해야한다.
2. 높이를 지정하면 톱날이 땅으로부터 H미터 위로 올라간다.
3. 한줄에 연속해 있는 나무를 모두 절단한다.
4. 높이가 H보다 큰 나무는 H위의 부분이 잘릴것이고, 낮은 나무는 잘리지 않는다.
5. 20, 15, 10, 17 애서 H가 15라면 15 ,15 ,10, 15 로써 5 + 2  = 7을 가져간다.
6. 나무를 필요한 만큼만 가져가려곻마, M미터의 나무를 가져가고싶다면 절단기에 설정할 수 있는 높이의 최댓값을 구해.

 */
