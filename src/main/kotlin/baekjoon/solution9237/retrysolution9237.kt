package baekjoon.solution9237

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

/**
 * @desc
 *
농부 상근이는 마당에 심기 위한 나무 묘목 n개를 구입했다.
묘목 하나를 심는데 걸리는 시간은 1일이고,
상근이는 각 묘목이 다 자라는데 며칠이 걸리는지 정확하게 알고 있다.
상근이는 마을 이장님을 초대해 자신이 심은 나무를 자랑하려고 한다.
이장님을 실망시키면 안되기 때문에, 모든 나무가 완전히 자란 이후에 이장님을 초대하려고 한다.
즉, 마지막 나무가 다 자란 다음날 이장님을 초대할 것이다.
상근이는 나무를 심는 순서를 신중하게 골라 이장님을 최대한 빨리 초대하려고 한다.
이장님을 며칠에 초대할 수 있을까?
 * @input
입력은 두 줄로 이루어져 있다. 첫째 줄에는 묘목의 수 N (1 ≤ N ≤ 100,000)이 주어진다.
둘째 줄에는 각 나무가 다 자라는데 며칠이 걸리는지를 나타낸 ti가 주어진다.
(1 ≤ ti ≤ 1,000,000)
 * @output
첫째 줄에 며칠에 이장님을 초대할 수 있는지 출력한다.
답이 여러 가지인 경우에는 가장 작은 값을 출력한다. 묘목을 구입한 날이 1일이다.
 * @example
4
2 3 4 3
7
 */

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt() // 묘목 갯수
    val treeList = Array<Int>(N) { 0 }
    readLine().split(" ").mapIndexed { index, tree ->
        treeList[index] = tree.toInt()
    }
    Arrays.sort(treeList, Comparator.reverseOrder())

    var result = 0
    for (i in treeList.indices) {
        result = Math.max(result, i + treeList[i] + 1) // 0일부터 시작이지만
    }
    println(result + 1)
}

/*
1 2 3 4 5 6
- - - - -
  - - - -
    - - - -
      - - -
 */
