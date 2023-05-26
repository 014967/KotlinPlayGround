package baekjoon.`흙길 보수하기`

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
/*
캠프장소에서 월드 본원까지 이어지는, 흙으로 된 비밀길 위에 폭우가 내려서 웅덩이 생김.
물웅덩이를 덮을 수 있는 길이 L짜리 널빤지 보유중.
다리로 만들어서 물웅덩이들을 모두 덮으려고함.
물웅덩이를 덮기 위한 필요한 널빤지의 최소 갯수를 구
 */
data class Vertex(
    val start: Int,
    val end: Int
)

/*
메모리 제한 128MB

 */
var maxLength = Integer.MIN_VALUE
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N, L) = br.readLine().split(" ").map { it.toInt() }
    // N : 웅덩이 갯수, L : 널빤지의 길이
    val nArray = Array(N) { Vertex(0, 0) }
    for (i in 0 until N) {
        val (start, end) = br.readLine().split(" ").map { it.toInt() }
        maxLength = maxLength.coerceAtLeast(end)
        nArray[i] = nArray[i].copy(start = start, end = end)
    }
    br.close()
    nArray.sortWith(
        comparator = Comparator<Vertex> { o1, o2 -> o1.start - o2.start }.thenComparing { o1, o2 ->
            o1.end - o2.end
        }
    )

    var start = -1
    var end = -1
    var count = 0
    for (i in nArray.indices) {
        if (start == -1 && end == -1) {
            start = nArray[i].start
            end = nArray[i].end
            val length = end - start
            count += if (length % L != 0) {
                // 안나눠지는 경우
                end += L - (length % L) - 1
                (length / L) + 1
            } else {
                // 딱 나누어 떨어지는 경우
                length / L
            }
            // 커버 가능한 범위를 찾는다.
        } else {
            //
            val nextStart = nArray[i].start
            val nextEnd = nArray[i].end
            if (end < nextStart) {
                start = nextStart
                end = nextEnd
                val length = end - start
                var temp = 0
                while (temp < length) {
                    temp += L
                    count += 1
                }
                end = start + temp - 1
            } else if (end == nextStart) {
                start = nextStart + 1
                end = nextEnd
                val length = end - start
                var temp = 0
                while (temp < length) {
                    temp += L
                    count += 1
                }
                end = start + temp - 1
            } else {
                // end > nextStart
                if (nextEnd <= end) {
                    continue
                }
                //  nextStart < end  < nextEnd
                start = end + 1
                end = nextEnd
                val length = end - start
                var temp = 0
                while (temp < length) {
                    temp += L
                    count += 1
                }
                end = start + temp - 1
            }
        }
    }
    println(count)
}

/*
4 3
1 6
3 4
3 8
13 17
 */