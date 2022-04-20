package baekjoon.solution10989

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

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
    val arr = Array(10001) { 0 }
    for (i in 1..n) {
        arr[readLine().toInt()]++
    }
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    for (i in 1..10000) {
        bw.write("$i\n".repeat(arr[i]))
    }
    bw.flush()
    bw.close()

//    for (i in 1..n) {
//        val input = readLine().toInt()
//        arr.add(input)
//    }
//
//    val counting = Counting()
//    counting.sort(arr)
}

class Counting {
//    fun sort(
//        arr: ArrayList<Int>,
//    ) {
//        /*
//        주어진 문제에서 자연수의 범위가 주어졌다.
//        input을 들어올 수 있는 최대의 자연수가 10000이니까 10000까지만 카운트 해준다.
//        가장 큰 값으로 초기화를 하게 된다면 천만 크기의 배열이 생성된다.
//         */
//        val countingArr = Array<Int>(100001) { 0 }
//        for (i in arr) {
//            countingArr[i] += 1
//        }
//
//        // 누적합
//        val mergeCountingArr = Array(countingArr.size) { 0 }
//        mergeCountingArr[0] = countingArr[0] // 첫번째 요소 초기화
//        for (i in 1 until mergeCountingArr.size) {
//            mergeCountingArr[i] = countingArr[i] + mergeCountingArr[i - 1]
//        }
//
//        // 입력배열과 크기가 같은 결과값 배열을 선언
//        val resultArr = Array<Int>(arr.size) { 0 }
//        for (i in arr) {
//            // 입력받은 값들을 조회한다.
//            // i번째의 값을 확인한다.
//            val index = mergeCountingArr[i]
//            // 자리를 1부터 세기 떄문에
//            // resultArr의 0번째 index부터 넣어주기 위해
//            // index -1 인 곳에 값을 넣어준다.
//            resultArr[index - 1] = i
//            mergeCountingArr[i] = index - 1
//        }
//
//        val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
//
//        for (i in resultArr) {
//            bufferedWriter.write("$i\n")
//        }
//        println(bufferedWriter.flush())
//        bufferedWriter.close()
//    }
}
