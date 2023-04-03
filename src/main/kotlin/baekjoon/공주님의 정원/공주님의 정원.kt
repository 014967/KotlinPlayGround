package baekjoon.`공주님의 정원`

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

data class MonthDate(
    val start: Int,
    val end: Int
)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    require(n in 1..100_000)

    var array = Array(n) { MonthDate(0, 0) }
    for (i in 0 until n) {
        val (startMM, startDD, endMM, endDD) = readLine().split(" ").map { it.toInt() }
        val startDate = startMM * 100 + startDD // * 100이 필수
        val endDate = endMM * 100 + endDD
        array[i] = MonthDate(startDate, endDate)
    }
    // date를 쓰지안혹, 3월 1일 301 , 11월 30일이다 1130

    array.sortWith(comparator = kotlin.Comparator<MonthDate> { o1, o2 -> o1.start - o2.start }.thenComparing { o1, o2 -> o2.end - o1.end })
    // 모든 입력 받고 정렬해줘야하는데

    var start = 301 //공주님 원하닌 날짜 3월1일부터 11월 30일까지 모둔 펴이었어야함.
    var end = 1130
    var index = 0
    var max = 0
    var count = 0
    while (start <= end) { // end -> 11월 30일 우리 start 1210
        // 나는 꽃을 하나씩만 찾을꺼여
        // start 630
        var flag = false // 꽃을 찾았는가?
        for (i in index until array.size) { // 0 -> 1 -> 2 ->3
            if (array[i].start > start) { // 630 , 610 start
                // 1월 1일 101
                // 처음 start는 301, 301보다 이후라면 301를 포함을 안하니까 break
                // 그 다음부터는 start를 이동 시킬 것.

                // 이코드의 의미는 꽃의 생명주기를 서로 이어지게 해준다.
                // 515가 못들어오는건, 301을 포함하고 있지 않기 떄문에
                break
            }
            if (max < array[i].end) { // max 630, start 831 , 1210

                // 끝나는 날짜를 찾아봐요 . max 0 아 630
                // 첫 max는 0 , max를 현재 end로 초기화 처음은 630일꺼임
                flag = true // 꽃찾음 . 이것은 start를 포함하는 꽃이여
                max = array[i].end // max를 1210
                // max보다 작은 것은 무시하게 된다.
                index++

                /*
                두번째 꽃을 찾을 때, 515시작이랑 610시작이 둘다 해당하고,
                둘중에 더 생명이 긴것을 선택을 하게 된다.
                 */
            }
        }

        if (flag) {
            // 난 꽃을 찾았기 떄문에 , start갱신 -> start와 이어지는 꽃을 찾기 위해서
            // 우리가 다음으로 확인해야하는 것은 꽃의 생명주기가 이어져야하기때문ㅇ
            // max로 지정했던 630 을 포함하는 꽃을 찾아되요
            start = max // start를 630  // start = 1210
            count++ //  2
        } else {
            break
        }
    }
    if (max <= end) { // 11월 30일이라면 11월 29일까지 꽃이 살아있기 때문에
        println(0)
    } else {

        println(count)
    }
}

/*
4
1 1 5 31
1 1 6 30
5 15 8 31
6 10 12 10
 */
/*
총 N네의 꽃이 있다.
꽃은 모든 같은 해에 피고, 같은 해에 진다.
하나의 꽃은 피는 날과 지는 날이 정해져 있다.
지는 날 - 1일까지 꽃이 살아있고, 지는날에는 ㄴ볼 수 없다.

1. 공주가 가장 좋아하는 계절인 3월 1일부터,
11월 30일까지 매일 꽃이 한가지 이상 피어있어야함.

2. 정원이 넓지 않으므로 정원에 심는 꽃들의 수는 가능한 적게 한다.

N개의 꽃들 중에서 위의 두 조건을 만족하는
3월 1일부터 11월 30일까지 매일 꽃이 한가지 이상 피어있도록 꽃을 선택
선택한 꽃들의 갯수의 출력해라.



 */
