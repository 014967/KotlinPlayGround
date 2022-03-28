package baekjoon.solution11286

import java.util.*
import kotlin.math.abs
/**
 * @desc
 * 절댓값 힙은 다음과 같은 연산을 지원하는 자료구조이다.
 * 배열에 정수 x (x ≠ 0)를 넣는다.
 * 배열에서 절댓값이 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다. 절댓값이 가장 작은 값이 여러개일 때는, 가장 작은 수를 출력하고, 그 값을 배열에서 제거한다.
 * 프로그램은 처음에 비어있는 배열에서 시작하게 된다.
 * @input
 * 첫째 줄에 연산의 개수 N(1≤N≤100,000)이 주어진다. 다음 N개의 줄에는 연산에 대한 정보를 나타내는 정수 x가 주어진다. 만약 x가 0이 아니라면 배열에 x라는 값을 넣는(추가하는) 연산이고,
 * x가 0이라면 배열에서 절댓값이 가장 작은 값을 출력하고 그 값을 배열에서 제거하는 경우이다. 입력되는 정수는 -231보다 크고, 231보다 작다.
 * @output
 * 입력에서 0이 주어진 회수만큼 답을 출력한다. 만약 배열이 비어 있는 경우인데 절댓값이 가장 작은 값을 출력하라고 한 경우에는 0을 출력하면 된다.
 * @example
 *
 */

fun main() {
    val n = readLine()?.toInt()
    val minQueue: PriorityQueue<Int> = PriorityQueue<Int>(Comparator<Int> { o1: Int, o2: Int -> abs(o1) - abs(o2) }.thenBy { it })
    // 첫번째 정렬은 절대값이 작은 순서대로, 두번째 정렬은 절대값이 같았을 때 원래 값으로 비교를 한다.
    val list = mutableListOf<Int>()
    if (n != null) {
        for (i in 0 until n) {
            val input = readLine()?.toInt()
            if (input != null) {
                list.add(input)
            }
        }
        for (i in list) {
            if (i == 0) {
                if (minQueue.isNotEmpty()) {
                    println(minQueue.peek())
                    minQueue.poll()
                } else {
                    println(0)
                }
            } else {
                minQueue.offer(i)
            }
        }
    }
}
private fun solution() {
    // 런타임 에러
    val n = readLine()?.toInt()
    if (n != null) {
        require(n >= 1)
        require(n <= 100000)
        val minQueue = PriorityQueue<Int>()
        val map = HashMap<Int, Int>() // input , count
        val list = mutableListOf<Int>()
        for (i in 0 until n) {
            val input = readLine()?.toInt()
            if (input != null) {
                require(input >= -231)
                require(input <= 231)
                list.add(input)
            }
        }
        for (input in list) {
            if (input == 0) {
                if (minQueue.size == 0) {
                    println(0)
                } else {
                    var minusValue = "-"
                    minusValue += minQueue.peek()
                    if (map.containsKey(minusValue.toInt())) {
                        // 음수로 존재할 경우
                        println(minusValue.toInt())
                        val count = map[minusValue.toInt()]?.minus(1)
                        if (count != null) {
                            if (count >= 1) {
                                map[minusValue.toInt()] = count
                            } else {
                                map.remove(minusValue.toInt())
                            }
                        }
                    } else {
                        // 양수로 존재할 경우
                        if (map.containsKey(minQueue.peek())) {
                            println(minQueue.peek())
                            val count = map[minQueue.peek()]?.minus(1)
                            if (count != null) {
                                if (count >= 1) {
                                    map[minQueue.peek()] = count
                                } else {
                                    map.remove(minQueue.peek())
                                }
                            }
                        }
                    }
                    minQueue.poll()
                }
            } else {
                if (map.containsKey(input)) {
                    val count = map[input]?.plus(1)
                    if (count != null) {
                        map[input] = count
                    }
                } else {
                    map[input] = 1
                }
                minQueue.offer(abs(input))
            }
        }
    }
}
