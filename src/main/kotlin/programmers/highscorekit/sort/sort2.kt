package programmers.highscorekit.sort

/**
 * @desc
 * 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
 * 예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.
 * 0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때,
 * 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.
 * 제한 사항
 * numbers의 길이는 1 이상 100,000 이하입니다.
 * numbers의 원소는 0 이상 1,000 이하입니다.
 * 정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
 * @input
 * numbers = [6, 10, 2]	return = "6210"
 * @output
 *
 * @example
 *
 */

fun main() {
    val numbers = intArrayOf(0, 0, 0, 0, 0)
    println(solution(numbers))
    println(solution2(numbers))
}

private fun solution(numbers: IntArray): String {
    var answer = ""

    val sortedArray = numbers.map {
        it.toString()
    }.sortedWith(
        Comparator { o1, o2 ->
            if (o1.length == o2.length) { // 길이가 같다면 큰게 첫번째로 오게 한다. > o2.compareTo(o1) == o2 - o1
                o2.compareTo(o1)
            } else {
                // 길이가 다르다면, 앞에 있는 문자와 뒤의 있는 문자의 조합을 비교한다.
                (o2 + o1).compareTo(o1 + o2)
                // 3 , 30 -> 330  compare 303
            }
        }
    )
    if (sortedArray[0] == "0") {
        answer += "0"
    } else {
        for (i in sortedArray) {
            answer += i
        }
    }

    return answer
}

private fun solution2(numbers: IntArray): String {
    var answer = ""
    numbers.sortedWith(
        Comparator { num1: Int, num2: Int ->
            "$num2$num1".compareTo("$num1$num2")
        }
    ).forEach { answer += it }
    if (answer[0] == '0') {
        answer = "0"
        return answer
    }
    return answer
}
