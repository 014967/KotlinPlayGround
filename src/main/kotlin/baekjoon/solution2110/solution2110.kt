package baekjoon.solution2110

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * @desc
도현이의 집 N개가 수직선 위에 있다.
각각의 집의 좌표는 x1, ..., xN이고, 집 여러개가 같은 좌표를 가지는 일은 없다.
도현이는 언제 어디서나 와이파이를 즐기기 위해서 집에 공유기 C개를 설치하려고 한다.
최대한 많은 곳에서 와이파이를 사용하려고 하기 때문에, 한 집에는 공유기를 하나만 설치할 수 있고,
가장 인접한 두 공유기 사이의 거리를 가능한 크게 하여 설치하려고 한다.
C개의 공유기를 N개의 집에 적당히 설치해서, 가장 인접한 두 공유기 사이의 거리를 최대로 하는 프로그램을 작성하시오.
 * @input
첫째 줄에 집의 개수 N (2 ≤ N ≤ 200,000)과 공유기의 개수 C (2 ≤ C ≤ N)이 하나 이상의 빈 칸을 사이에 두고 주어진다.
둘째 줄부터 N개의 줄에는 집의 좌표를 나타내는 xi (0 ≤ xi ≤ 1,000,000,000)가 한 줄에 하나씩 주어진다.
 * @output
첫째 줄에 가장 인접한 두 공유기 사이의 최대 거리를 출력한다.
 * @example
 *
 */

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val str = readLine().split(" ")
    val n = str[0].toInt()
    val c = str[1].toInt()
    val vertexArr = arrayListOf<Int>()
    for (i in 1..n) {
        val vertex = readLine().toInt()
        vertexArr.add(vertex)
    }
    vertexArr.sort()

    var start = 1 // 최소 거리
    var end = vertexArr[vertexArr.size - 1] - vertexArr[0] + 1 // 최대 거리
    while (start < end) {
        val mid = (start + end) / 2 // 적당한 거리 대입

        if (install(mid, vertexArr) <c) {
            //
            // 공유기의 갯수가 부족하다면
            // 최대거리를 줄인다
            end = mid
        } else {
            // 설치 가능한 공유기가 c보다 크거나 같다면 거리를 벌린다
            start = mid + 1
            // 최소거리를 늘린다
        }
    }
    /*
    Upper bound 이기 떄문에 탐색 값을 초과하는 첫 번째 값을 가리키므로,
    1을 빼준다 !
     */
    println(start - 1)
}
fun install(distance: Int, vertexArr: ArrayList<Int>): Int { // 공유기의 갯수를 반환
    var count = 1 // 첫번째 집은 무조건 설치한다
    var prev = vertexArr[0]
    for (i in 1 until vertexArr.size) {
        var current = vertexArr[i]
        if (current - prev >= distance) {
            count++
            prev = current
        }
    }
    return count
}

/*
val check = BooleanArray(vertexArr.size) { false }
    // 이분 탐색을 하기 위해서는 정렬된 배열이라고 들었음
    check[0] = true
    check[vertexArr.size - 1] = true
    var start = vertexArr[0] // 첫번째 집
    var end = vertexArr [ n - 1] // 마지막 집
    var count = 2
    var index = 0
    while (start <= end) {
        if (count == c)
            break
        var mid = (start + end) / 2

        for (i in index..vertexArr.indexOf(end)) {
            if (vertexArr[i] > mid) {
                val left = vertexArr[i ] - mid
                val right = mid - vertexArr[i - 1]

                var close = 0

                if (left < right) {
                    close = vertexArr[i ]
                    index = i
                } else {
                    close = vertexArr[i - 1]
                    index = i - 1
                }
                check[index] = true
                count++
                mid = close
                break
            }
        }
        if (mid - start < end - mid) {
            start = mid + 1
        } else {
            end = mid - 1
        }
        /*
         end 와 start 수정
         오른쪽이 길면 start를 늘리고 start = mid + 1
         왼쪽이 길면 end을 줄여 end  = mid -1
         */
    }
    var max = 100000000
    var prevIndex = 0
    for (i in 1 until check.size) {
        if (check[i] == true) {
            max = max.coerceAtMost(vertexArr[i] - vertexArr[prevIndex])
            prevIndex = i
            /*
            i == 2 prev ==0

             */
        }
    }
    println(max)
 */
