package study.step1.item1

import kotlin.concurrent.thread

/**
 * @desc
 *
 * @input
 *
 * @output
 *
 * @example
 *
 * 여러 스레드가 동일한 프로퍼티를 수정하려고 하지만 충돌로 인해 일부 작업 연산이 손실됨.
 */

// fun main() {
//    var num = 0
//    for (i in 1..1000) {
//        thread {
//            Thread.sleep(10)
//            num += 1
//        }
//    }
//    Thread.sleep(5000)
//    println(num)
// }

// kotlin 코투린을 사용하면 스레드수가 적기때문에 충돌이 덜 발생하지만 여전히 존재

// suspend fun main() {
//    var num = 0
//    coroutineScope {
//        for (i in 1..1000) {
//            launch {
//                delay(10)
//                num += 1
//            }
//        }
//    }
//    println(num)
// }

// 실제 프로젝트에서는 동기화를 구현해야하지만, 구현이 어렵고 변이지점이 많을 수록 더 많이 구현해야함.
fun main() {
    val lock = Any()
    var num = 0
    for (i in 1..1000) {
        thread {
            Thread.sleep(10)
            synchronized(lock) {
                num += 1
            }
        }
    }
    Thread.sleep(1000)
    println(num)
}

/*
    변경 가능성의 단점은 너무 많아서 상태변경을 허용하지 않는 언어도 있다. (하스칼)
    하지만 이렇나 경우는 프로그래밍을 수애하기 매우 어렵다.
    상태 변이는 실제 시스템의 상태를 표현하는데 매우 유용한 방법이다.
    변경 지점이 있어야할 곳에 신중하고 현명하게 배치하는 것을 권장한다.
    Kotlin은 가변성 제한을 잘 지원한다.
 */
