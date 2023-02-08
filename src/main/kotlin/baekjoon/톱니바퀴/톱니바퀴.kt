package baekjoon.톱니바퀴

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
    val arr = Array(4) { MutableList<Pair<Char, Int>>(8) { Pair('0', 0) } }
    var result = 0
    for (i in 0..3) {
        val readArr = readLine().toCharArray().mapIndexed { index: Int, c: Char ->
            Pair(c, index)
        }
        arr[i] = readArr.toMutableList()
    }
    val k = readLine().toInt()
    for (i in 1..k) {
        val (type, count) = readLine().split(" ").map { it.toInt() }
        val t = arr[type - 1]

        val arr0Right = get3(arr[0])
        val arr1Left = get9(arr[1])
        val arr1Right = get3(arr[1])
        val arr2Left = get9(arr[2])
        val arr2Right = get3(arr[2])
        val arr3Left = get9(arr[3])

        // type 은 -1 해야 index가 된다.
        var nextCount = count
        if (type == 1) {
            // t== 0
            // 현재 1번 오른쪽 세개 이동

            var flag = false // 이동했는지
            if (arr0Right != arr1Left) {
                if (nextCount == 1) {
                    rotate(arr[1], -1)
                    nextCount = -1
                } else {
                    rotate(arr[1], 1)
                    nextCount = 1
                }
                flag = true
            }
            var flag2 = false
            if (arr1Right != arr2Left && flag) {
                if (nextCount == 1) {
                    rotate(arr[2], -1)
                    nextCount = -1
                } else {
                    rotate(arr[2], 1)
                    nextCount = 1
                }
                flag2 = true
            }
            if (arr2Right != arr3Left && flag2) {
                if (nextCount == 1) {
                    rotate(arr[3], -1)
                } else {
                    rotate(arr[3], 1)
                }
            }
            rotate(arr[0], count)
        } else if (type == 2) {
            // 현재 2번, 1번과 3,4번 이동

            if (arr0Right != arr1Left) {
                if (nextCount == 1) {
                    rotate(arr[0], -1)
                    nextCount = -1
                } else {
                    rotate(arr[0], 1)
                    nextCount = 1
                }
            }

            var flag = false
            if (arr1Right != arr2Left) {
                if (nextCount == 1) {
                    rotate(arr[2], -1)
                    nextCount = -1
                } else {
                    rotate(arr[2], 1)
                    nextCount = 1
                }
                flag = true
            }
            if (arr2Right != arr3Left && flag) {
                if (nextCount == 1) {
                    rotate(arr[3], -1)
                } else {
                    rotate(arr[3], 1)
                }
            }
            rotate(arr[1], count)
        } else if (type == 3) {
            // 왼쪽 두개, 오른쪽 하나 이동

            var flag = false
            if (arr1Right != arr2Left) {
                if (nextCount == 1) {
                    rotate(arr[1], -1)
                    nextCount = -1
                } else {
                    rotate(arr[1], 1)
                    nextCount = 1
                }
                flag = true
            }
            if (arr0Right != arr1Left && flag) {
                if (nextCount == 1) {
                    rotate(arr[0], -1)
                    nextCount = -1
                } else {
                    rotate(arr[0], 1)
                    nextCount = 1
                }
            }
            if (arr2Right != arr3Left) {
                if (nextCount == 1) {
                    rotate(arr[3], -1)
                } else {
                    rotate(arr[3], 1)
                }
            }
            rotate(arr[2], count)
        } else {
            // 왼쪽 3개 이동
            var flag = false
            if (arr2Right != arr3Left) {
                if (nextCount == 1) {
                    rotate(arr[2], -1)
                    nextCount = -1
                } else {
                    rotate(arr[2], 1)
                    nextCount = 1
                }
                flag = true
            }

            var flag2 = false
            if (arr1Right != arr2Left && flag) {
                if (nextCount == 1) {
                    rotate(arr[1], -1)
                    nextCount = -1
                } else {
                    rotate(arr[1], 1)
                    nextCount = 1
                }
                flag2 = true
            }
            if (arr0Right != arr1Left && flag2) {
                if (nextCount == 1) {
                    rotate(arr[0], -1)
                } else {
                    rotate(arr[0], 1)
                }
            }

            rotate(arr[3], count)
        }
    }
    for (i in arr.indices) {
        for (j in arr[i].indices) {
            if (arr[i][j].second == 0) {
                if (arr[i][j].first == '0') {
                    result += 0
                } else {
                    if (i == 0) {
                        result += 1
                    } else if (i == 1) {
                        result += 2
                    } else if (i == 2) {
                        result += 4
                    } else {
                        result += 8
                    }
                }
            }
        }
    }
    println(result)
}
fun get3(t: MutableList<Pair<Char, Int>>): Char {
    var c = '0'
    for (i in t.indices) {
        if (t[i].second == 2) {
            c = t[i].first
            break
        }
    }
    return c
}
fun get9(t: MutableList<Pair<Char, Int>>): Char {
    var c = '0'
    for (i in t.indices) {
        if (t[i].second == 6) {
            c = t[i].first
            break
        }
    }
    return c
}

fun rotate(t: MutableList<Pair<Char, Int>>, count: Int) {
    if (count == 1) {
        for (b in t.indices) {
            if (t[b].second == 7) {
                t[b] = t[b].copy(second = 0)
            } else {
                t[b] = t[b].copy(second = t[b].second + 1)
            }
        }
        // 오른쪽 회전
    } else {
        // 왼쪽회전
        for (b in t.indices) {
            if (t[b].second == 0) {
                t[b] = t[b].copy(second = 7)
            } else {
                t[b] = t[b].copy(second = t[b].second - 1)
            }
        }
    }
}
