package baekjoon.달력놀이

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

lateinit var calArray: Array<Array<Array<Int>>>

var targetYear: Int = 2001
var targetMonth: Int = 11
var targetDate: Int = 4
val dateOf31 = listOf<Int>(1, 3, 5, 7, 8, 10, 12)
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val t = readLine().toInt()

    for (i in 1..t) {
        calArray = Array(102) { Array(13) { Array(32) { Integer.MAX_VALUE } } }
        val (yyyy, mm, dd) = readLine().split(" ").map { it.toInt() }
        search(yyyy, mm, dd, 0)
        if (calArray[101][11][4] % 2 == 0) {
            println("NO")
        } else {
            println("YES")
        }
    }
}

/*

 */
fun search(yyyy: Int, mm: Int, dd: Int, count: Int) {
    if (Date(yyyy, mm, dd) > Date(targetYear, targetMonth, targetDate)) {
        return
    }
    if (calArray[yyyy - 1900][mm][dd] == Integer.MAX_VALUE) {
        calArray[yyyy - 1900][mm][dd] = count
    }

    if (calArray[yyyy - 1900][mm][dd] != Integer.MAX_VALUE) {
        // 이미 누군가는 지나갔다.
        if (calArray[yyyy - 1900][mm][dd] <= count) {
            return
        } else {
            calArray[yyyy - 1900][mm][dd] = count
        }
    }

    // 1. 현재 날짜의 다음날로 이동하기
    val currentMaxDate = getCurrentMaxDate(yyyy, mm)
    if (dd + 1 <= currentMaxDate) {
        search(yyyy, mm, dd + 1, count + 1)
    } else {
        // 달이 넘어가는지 아닌지 판단해야한다.
        // 위의 조건문이 넘어간다는 것은 달이 다음 달로 넘어간다는 의미다.
        if (mm == 12) {
            // 1월달로 넘어가는 경우의 수를 채여
            search(yyyy, 1, 1, count + 1)
        } else {
            search(yyyy, mm + 1, 1, count + 1)
        }
    }
    val newMM = if (mm == 12) {
        1
    } else {
        mm + 1
    }
    val nextMaxDate = getCurrentMaxDate(yyyy + 1, newMM)
    if (dd <= nextMaxDate) {
        // 같은 날짜로 이동하기 때문에
        search(yyyy + 1, newMM, dd, count + 1)
    }
}

fun getCurrentMaxDate(yyyy: Int, mm: Int): Int {
    return if (mm == 2) {
        // 2월달인 경우 윤년을 계산해야한다.
        if (yyyy % 4 == 0 && (yyyy % 100 != 0 || yyyy % 400 == 0)) {
            // 이 안에 해당하면 윤년입니다.
            29
        } else {
            // 아니면 윤년이 아닙니다.
            28
        }
    } else {
        // 아닌경우
        if (mm in dateOf31) {
            // 31 = 1,3,5,7,8,10,12
            31
        } else {
            30
        }
    }
}

/*
랜덤한 날짜에서 게임을 시작한다.
1900/01/01 부터 2001/11/04까지

게임의 시작은 상범이부터 시작해서 상범-민균-상범 순으로 돌아간다.
현재 날짜의 다음 날짜로 이동하거나,
다음 달의 현재날짜와 동일한 날짜로 이동하는 것 둘중 하나를 선택한다.

다음 달 같은 날짜로 이동하는 경우는, 그런 날이 존재하는 경우만 가능하다.

2001/11/04 에 먼저 도착하는 사람이 승리하고, 이 날짜 이후로 이동하면
그 플레이어는 패배하게 된다.
선 플레이어인 상범이에게 필승법이 존재하는지 알아내라.
윤년 존재.
윤년은 연도가 4의 배수이면서, 100의 배수가 아닐때 또는 400의 배수 일때이다.
if( yyyy % 4 == 0 && ( yyyy % 100 != 0 || yyyy % 400 ==0 ) )
 */
