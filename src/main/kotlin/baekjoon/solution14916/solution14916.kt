package baekjoon.solution14916

import java.io.*
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
    val n = readLine().toInt()
    require(n in 1..100000)

    var count = -1

    if (n / 5 >= 1) { // 숫자 5 이상인가 ?
        if (n % 5 == 0) { // 5로 나누어 떨어지는가 ?
            count = n / 5
        } else {
            var min = Integer.MAX_VALUE
            var twoValue = Integer.MAX_VALUE
            if (n % 2 == 0) {
                twoValue = n / 2
            }
            for (i in 1..(n / 5)) {
                var x = 0
                x += i

                if ((n - 5 * i) % 2 == 0) { // 5의 배수를 뺀 나머지가 2로 나누어진다면
                    x += ((n - 5 * i) / 2)
                    if (min > x) { // min보다 작다면 갱신
                        min = x
                    }
                }
            }
            if (min == Integer.MAX_VALUE && twoValue == Integer.MAX_VALUE) {
                count = -1
            } else {
                if (min < twoValue)
                    count = min
                else
                    count = twoValue
            }
        }
    } else {
        if (n % 2 == 0) { // 5미만인데 2로 나누어 떨어지는가?
            count = n / 2
        }
    }
    println(count)
}

/*
 5랑 2로 만들 수 있는 모든 값은
 5+ 2 = 7
 5 + 2 + 2 = 9
 5의 배수 더하기 2의 배수인 값이어야한다.
21 -> 5 * 3 2 *3
22 -> 5 * 4 + 2 *1
23 -> 5 * 3 + 2 * 4
27 -> 5 * 5 + 1
5 *7
 */
