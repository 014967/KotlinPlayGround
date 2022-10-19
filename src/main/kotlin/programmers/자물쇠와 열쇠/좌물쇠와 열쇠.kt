package programmers.`자물쇠와 열쇠`

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

var keySize = 0
var lockSize = 0
fun main() {
    val key = arrayOf(intArrayOf(0, 0, 0), intArrayOf(1, 0, 0), intArrayOf(0, 1, 1))
    keySize = key.size
    val lock = arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 1, 0), intArrayOf(1, 0, 1))
    lockSize = lock.size

    require(key.size in 3..20)
    require(lock.size in 3..20)

    require(key.size <= lock.size)
    val solution = Solution()
    println(solution.solution(key, lock))
}
class Solution {
    fun solution(key: Array<IntArray>, lock: Array<IntArray>): Boolean {
        var answer = false

        val totalSize = lock.size * 3
        val arr = Array<IntArray>(totalSize) { IntArray(totalSize) }

        var vertexList = arrayListOf<Pair<Int, Int>>()
        for (i in lock.indices) {
            for (j in lock[i].indices) {
                arr[i + lockSize][j + lockSize] = lock[i][j] // 가운데에 박아
            }
        }

        for (i in key.indices) {
            for (j in key[i].indices) {
                if (key[i][j] == 1) {
                    vertexList.add(Pair(i, j)) // keylist
                }
            }
        }

        for (y in 0..totalSize - key.size) {
            if (answer) {
                break
            }
            for (x in 0..totalSize - key.size) {

                // 돌려
                if (answer) {
                    break
                }
                for (i in 0..4) {
                    val checkList = arrayListOf<Pair<Int, Int>>()
                    if (i != 0) {
                        vertexList = rotate(vertexList)
                    }
                    for (k in vertexList) { // 키르르 모두 대입해본다.
                        arr[k.first + x][k.second + y] += 1
                        checkList.add(Pair(k.first + x, k.second + y))
                    }
                    if (check(arr, lock)) {
                        answer = true
                        break
                    }
                    for (k in checkList) {
                        // 대입한거 되돌려 놓기
                        arr[k.first][k.second] -= 1
                    }
                }
            }
        }

        return answer
    }
}

fun check(arr: Array<IntArray>, lock: Array<IntArray>): Boolean {
    var flag = true
    for (i in lock.indices) {
        for (j in lock[i].indices) {
            if (arr[i + lockSize][j + lockSize] != 1) {
                flag = false
                break
            }
        }
        if (!flag) {
            break
        }
    }
    return flag
}
fun rotate(vertexList: ArrayList<Pair<Int, Int>>): ArrayList<Pair<Int, Int>> {
    val arrList = arrayListOf<Pair<Int, Int>>()
    for (i in vertexList) {
        val vertex = Pair(i.second, keySize - i.first - 1)
        arrList.add(vertex)
    }
    return arrList
}

/*
잠겨있는 좌물 쇠는 격자 한칸의 크기가 1* 1인 n * n 크기의 정사각 겨자 형태
특이한 모양의 열쇠는 m * m크기의 정사각 격자 형태
좌물솨에는 홈이 파여있고 , 열쇠 또한 홈과 돌기 부분이 있다.
열쇠는 회전과 이동이 가능하며 열쇠의 돌기 부분을 좌물쇠의 홈 부분에 딱 맞게
채우면 자물쇠가 열린다.

자물쇠 영역을 벗어난 부분에 잇는 열쇠의 홈과 골디는 자물쇠를 여는데 영향을 주지않음
열쇠의 돌기와 자물쇠의 홈 부분이 정확히 일치해야한다.
열쇠의 도기와 자물쇠의 돌기가 만나서는 안된다.
자물소의 모든 홈을 채워비어있는 곳이 없어야 좌물 쇠를 열 수 있다.

열쇠를 나타내는 2차원 배열 key와 2차원 배열 lock이 매개변수로 주어질때,
열쇠로 자물쇠를 열 수 있으면 true, 없으면 false를 return

 */
