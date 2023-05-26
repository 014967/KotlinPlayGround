package coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

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

fun main() = runBlocking<Unit> {
//    val nums = (1..3).asFlow().onEach { delay(300) }
//    val strs = flowOf("one", "two", "three").onEach { delay(400) }
//    nums.combine(strs) { a, b -> "$a -> $b" }
//        .collect {
//            println(it)
//        }
    (1..3).asFlow().map { requestFlow(it) }.collect {
        it.collect {
            println(it)
        }
    }
}

fun requestFlow(i: Int): Flow<String> = flow {
    emit("$i : First")
    delay(500)
    emit("$i : Second")
}
