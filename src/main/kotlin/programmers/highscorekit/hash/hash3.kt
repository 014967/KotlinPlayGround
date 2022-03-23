package programmers.highscorekit.hash

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

fun main() {
//    val arr: Array<Array<String>> = arrayOf(arrayOf("yellowhat", "headgear"), arrayOf("bluesunglasses", "eyewear"), arrayOf("green_turban", "headgear"), arrayOf("crowmask", "face"), arrayOf("bluesunglasses", "face"), arrayOf("smoky_makeup", "face"))
    val arr: Array<Array<String>> = arrayOf(arrayOf("crowmask", "face"), arrayOf("bluesunglasses", "face"), arrayOf("smoky_makeup", "face"))
    print(solution(arr))
}

fun solution(clothes: Array<Array<String>>): Int {
    var answer = 1
    val map = HashMap<String, Int>()

    for (i in clothes) {
        val type = i[1]
        if (map.containsKey(type)) {
            if (map[type] != null) {
                var count = map[type]?.plus(1)
                if (count != null) {
                    map[type] = count
                }
            }
        } else {
            map[type] = 1
        }
    }
    for (i in map) {
        answer *= i.value + 1 // 각각 선택을 하지 않았을 경우도 포함
    }
    answer -= 1 // 모두 선택을 하지 않았을 경우를 삭제

    return answer
}
