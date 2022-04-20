package baekjoon.solution2751

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

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val arr = ArrayList<Int>()
    for (i in 0 until n) {
        arr.add(readLine().toInt())
    }

//    val qickSort = QuickSort()
//    val result = qickSort.sort(arr)
//    qickSort.sort2(arr, 0, arr.size - 1)
//    val mergeSort = MergeSort()
//    val result = mergeSort.split(arr)

    val heap = Heap()
    val heapSortResult = heap.sort(arr)
    val str = StringBuilder()
    for (i in heapSortResult) {
        str.append("$i\n")
    }
    println(str.toString())
}

class MergeSort {
    /*
    음수일 때 안됌 .
     */
    fun split(arr: ArrayList<Int>): ArrayList<Int> {
        if (arr.size <= 1) return arr

        val mid = arr.size / 2 // 분할

        // 재귀함수를 통해 left, righ split 및 sort 하여 merge
        // 사이즈가 1일 때까지 split해버린다.
        val left = split(ArrayList(arr.subList(0, mid)))
        val right = split(ArrayList(arr.subList(mid, arr.size)))

        // 사이즈가 1일때부터 merge를 시작한다.
        return merge(left, right)
    }

    fun merge(left: ArrayList<Int>, right: ArrayList<Int>): ArrayList<Int> {
        val mergedList = arrayListOf<Int>()
        var leftIndex = 0
        var rightIndex = 0
        // Case 1 : left, right 모두 존재
        while (leftIndex < left.size && rightIndex < right.size) {

            /*예를 들어 배열이 123이였고
            left = 14, right = 23 이라고 하자.
            left[0] = 1 right[0] =2
            left[0] < right[0] 이므로
            배열에 left[0] 삽입 -> leftIndex++
            left[1] 과 right[0] 비교 4 < 2
            right[0]이 더 작으므로 right[0] 삽입  1 2 rightIndex ++
            left[1]과 right[1]을 비교 4 < 3
            right[1] 삽입 rightIndex++ 1 2 3  -> rightIndex가 right.size를 넘지않도록함.

            이 while문이 끝나게 되면, 이미 다 넣어진 배열은 Index가 size를 넘어가면서 접근이 안되게 된다.

             */

            if (left[leftIndex] < right[rightIndex]) {
                mergedList.add(left[leftIndex])
                leftIndex++
            } else {
                mergedList.add(right[rightIndex])
                rightIndex++
            }
        }
            /*
            left는 이미 다 넣어지고, right만 남은 상태
            남은 요소들을 mergedList가 전부 넣어준다.
             */
        while (rightIndex < right.size) {
            mergedList.add(right[rightIndex])
            rightIndex++
        }
            /*
            right는 이미 다 넣어지고, left만 남은 상태
            남은 요소들을 mergedList에 전부 넣음

             */
        while (leftIndex < left.size) {
            mergedList.add(left[leftIndex])
            leftIndex++
        }

        return mergedList
    }
}
class QuickSort {
    /*
    추가적인 공간을 생성해서 퀵정렬하는 방법 구현은 쉬운편인듯
    시간초과
     */
    fun sort(arr: ArrayList<Int>): ArrayList<Int> {

        if (arr.size <= 1) return arr

        val pivot = arr.removeFirst() // 리스트의 첫번째 요소를 pivot
        // pivot 보다 작은 값들을 담아둘 리스트
        val left = arrayListOf<Int>()
        // pivot 보다 큰 값들을 담아둘 리스트
        val right = arrayListOf<Int>()

        for (i in arr.indices) {
            if (arr[i] > pivot) {
                // pivot 보다 현재 값이 크다면 right 리스트에 넣어준다.
                right.add(arr[i])
            } else {
                // pivot보다 현재 값이 작다면 left 리스트에 넣어준다.
                left.add(arr[i])
            }
        }
        val mergedList = arrayListOf<Int>()

        // 재귀함수를 통해 정렬된 left, right 배열 left + pivot + right 순으로 merge
        mergedList.addAll(sort(left))
        mergedList.add(pivot)
        mergedList.addAll(sort(right))
        return mergedList
    }
    fun sort2(arr: ArrayList<Int>, start: Int, end: Int) {

        var low = start + 1 // idx
        var high = end // idx

        var left = 0
        var right = 0
        while (start < end && low <= high) {
            val pivot = arr[start]
            while (low <= end && low <= high) {
                if (pivot < arr[low]) {
                    left = low
                    break
                }
                low++
            }
            while (start + 1 <= high && low <= high) {
                if (pivot > arr[high]) {
                    right = high
                    break
                }
                high--
            }
            if (low> high) {
                // low 와 high 이 교차를 해버린 순간
                // high과 pivot을 교체한다.
                val temp = arr[high]
                arr[high] = pivot
                arr[start] = temp // arr[start] 가 pivot의 위치임.

                // 왼쪽과 오른쪽 리스트에 대해서 다시 sort를 진행한다.
                sort2(arr, start, high - 1)
                sort2(arr, high + 1, end)
            } else {
                val temp = arr[left]
                arr[left] = arr[right]
                arr[right] = temp
            }
        }
    }
}

class Heap {
    fun sort(arr: ArrayList<Int>): ArrayList<Int> {
        var result = arrayListOf<Int>()

        // 자식 노드의 위치를 구하기 위한 배열 길이
        var arrLen = arr.count()
        // 자식 노드를 가진 노드들만 순회
        for (i in arrLen / 2 - 1 downTo 0) {
            /*
            arr이 1, 2, 3, 4, 5, 6 이라면
            size/2 = 3
            index = 2 1 0 만 보게 된다는 건데
            1 2 3 이 자식 노드를 가지고 있다는 것을 알 수 있음

            더 정확한 설명으로는
            arrLen/ 2 -1  = 중간 노드다
            중간 노드로부터 루트 노드까지 Heapify를 한다
            항상 중간 노드부터 자식이 존재하기 때문에 중간 노드 부터 시작

            전체 크기가 6인 트리에서
            ( arrLne/ 2 ) = 3 , (3-1) 2번 인덱스부터 0번 인덱스 까지 자식이 존재하는 것을 알 수 있다.

                  1
              2       3
            4   5   6

             */
            heapify(arr, arrLen, i)
            // 힙 트리 구성
        }
        for (j in arrLen - 1 downTo 0) {
            /*
            루트 노드를 중심으로 Heapify 하여 힙트리를 재구성한다.
             */
            /* 3 5 4 7 1
                        3
                    5       4
             7          1
             */

            /*
                          3
                       1     4
                     7   5
             */
            /*
                        1
                   3          4
               7      5
             */

            result.add(arr[0])
            arr[0] = arr[j] // 마지막 노드를 노트노드에 올린다.
            // 힙의 크기를 줄임으로써 마지막 노드를 제외하고 트리를 재구성한다.
            heapify(arr, --arrLen, 0)
        }
        return result
    }
    /*
    특정 노드를 중심으로 그 밑의 트리들이 힙 성질을 만족하게끔 만드는 작업.
     */
    fun heapify(
        arr: ArrayList<Int>, // 힙
        heapSize: Int, // 힙 사이즈
        pIdx: Int/*자식노드를 가지는 부모 노드 인덱스*/
    ) {
        // 부모 노드, 좌측 자식 노드, 우측 자식 노드 구함
        var p = pIdx
        var l = pIdx * 2 + 1 // 왼쪽 자식 노드 인덱스
        var r = pIdx * 2 + 2 // 오른쪽 자식 노드 인덱스
        // 왼쪽 자식 노드와 비교
        if (l < heapSize && arr[l] < arr[p]) {
            // 부모노드보다 왼쪽 자식 노드가 작은 경우
            p = l
        }
        if (r <heapSize && arr[r] < arr[p]) {
            // 부모노드 보다 오른쪽 자식 노드가 작은 경우
            p = r
        }
        /*
         부모노드와 자식 노드들(left, right)들을 비교해서 셋 중 가장 큰 값을 가지고 있는
         노드로 이동한다.
         pIdx = p 인경우는 자식 노드들이 부모노드보다 작았다는 것을 의미한다.
         */
        /*
        부모 노드의 값보다 자식 노드의 값이 크다며 재귀함수
        우리가 만들려고 하는 것은 최소 힙이라는 것을 알자.
        부모가 자식보다 작아야한다.  (오름 차순)
         */
        if (pIdx != p) {
            val temp = arr[p]
            arr[p] = arr[pIdx]
            arr[pIdx] = temp
            /*

             */
            heapify(arr, heapSize, p)
        }
    }
}
