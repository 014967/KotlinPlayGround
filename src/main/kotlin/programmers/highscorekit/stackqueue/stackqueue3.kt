package programmers.highscorekit.stackqueue

import java.util.*

/**
 * @desc
 * 트럭 여러 대가 강을 가로지르는 일차선 다리를 정해진 순으로 건녀려합니다. 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아야합니다.
 * 다리에는 트럭이 최대 bridge_length대 올라갈 수 있으며, 다리는 weight 이하까지의 무게를 견딜 수 있습니다.
 * 단, 다리에 완전히 오르지 않은 트럭의 무게는 무시합니다.
 *
 * 예를 들어, 트럭 2대가 올라갈 수 있고 무게를 10kg까지 견디는 다리가 있습니다. 무게가 [7,4,5,6]kg인 트럭이 순서대로 최단 시간안에 다리를 건너려면 다음과 같이 건너야합니다.
 *
 * solution 함수의 매개변수로 다리에 올라갈 수 있는 트럭 수 bridge_length, 다리가 견딜 수 있는 weight
 * 트럭 별 무게 truck_weights가 주어집니다. 이때 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 return하도록
 *
 * 제한 조건
 * 1. bridge_length 는 1이상 10,000이하입니다.
 * 2. weight는 1이상 10,000이하입니다.
 * 3. truck_weights 의 길이는 1이상 10,000이하입니다.
 * 4. 모든 트럭의 무게는 1이상 weight 이하입니다.
 * @input
 *
 * @output
 *
 * @example
 *
 */

fun main() {
    val bridge_length = 100
    val weight = 100
    val truck_weights = intArrayOf(10)
    solution(bridge_length, weight, truck_weights)
}
fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
    var answer = 0
    var queue = LinkedList<Int>()
    var inBridge = LinkedList<Pair<Int, Int>>()
    for (i in truck_weights) {
        queue.offer(i)
    }
    println(queue)

    var count = 0
    do {

        if (inBridge.size != 0) {

            for (i in 0 until inBridge.size) {
                var time = inBridge[i].second
                inBridge[i] = inBridge[i].copy(second = time + 1)
            }
            if (inBridge.first().second == bridge_length+1) {
                inBridge.poll()
            }
        }
        var k = 0
        for (i in inBridge) {
            k += i.first
        }
        if (queue.size != 0) {
            if (k + queue.first() <= weight) {
                var pair = Pair<Int, Int>(queue.first(), 1)
                inBridge.offer(pair)
                queue.poll()
            }
        }

        count++
    } while (inBridge.size != 0)

    answer = count
    println(answer)
    return answer
}
