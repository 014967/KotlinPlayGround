package programmers.highscorekit.bruteforce

/**
 * @desc
 * 한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
제한사항
numbers는 길이 1 이상 7 이하인 문자열입니다.
numbers는 0~9까지 숫자만으로 이루어져 있습니다.
"013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
 * @input
 * numbers	return
"17"	3
"011"	2
 * @output
 *
 * @example
 * 예제 #1
[1, 7]으로는 소수 [7, 17, 71]를 만들 수 있습니다.
예제 #2
[0, 1, 1]으로는 소수 [11, 101]를 만들 수 있습니다.
11과 011은 같은 숫자로 취급합니다.
 */

/*
1. 아이디어
- 백트래킹 재귀함수 안에서 for loop를 돌며 숫자 선택 ( 이때 방문 여부 확인 )
- 재귀함수에서 n개를 선택할 경우 출력
2. 시간 복잡도
시간 복잡도 O(N!) -> 최대 8까지 가능
numbers의 길이가 7까지 이므로 가능
3. 자료구조
- 결과값 저장 int배열
- 방문여부 boolean 배열
 */
fun main() {
    val numbers = "011"
    solution(numbers)
}

fun solution(numbers: String): Int {
    var answer = 0
    val visited = BooleanArray(numbers.length) { false } // 첫번째는 쓰지 않고전부 0으로 초기화
    val current = 0
    val temp = CharArray(numbers.length)
    val set = mutableSetOf<Int>()
    for (i in 1..numbers.length) {
        permutation(set, numbers, i, temp, current, visited)
    }
    answer = set.size
    return answer
}
fun permutation(set: MutableSet<Int>, numbers: String, r: Int, temp: CharArray, current: Int, visited: BooleanArray) {
    if (r == current) // 현재 뽑은 갯수가 뽑고자 하는 갯수와 같을 때
        {
            val str = StringBuilder()
            for (i in temp) {
                if (i.code != 0) {
                    str.append(i)
                }
            }
            if (str.toString().toInt() != 1 && str.toString().toInt() != 0) {
                if (!checkPrimeNumber(str.toString().toInt())) {
                    set.add(str.toString().toInt())
                }
            }
        } else {
        for (i in numbers.indices) // arr 배열안에서 뽑고자 함
            {
                if (!visited[i]) { // 첫번째 요소를 거치지 않았다면
                    visited[i] = true
                    temp[current] = numbers[i] // 첫번째 요소를 선택하자. //current 0
                    permutation(set, numbers, r, temp, current + 1, visited) // 선택했으니 갯수가 증가
                    visited[i] = false
                }
            }
    }
}
private fun checkPrimeNumber(num: Int): Boolean {
    var result = false
    for (i in 2 until num) {
        if (num % i == 0) {
            result = true
            break
        }
    }
    return result
}
