package coroutine

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.launch
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

@OptIn(DelicateCoroutinesApi::class)
fun main(): Unit = runBlocking {
    val handler = CoroutineExceptionHandler { _, exception ->
        println("CoroutineExceptionHandler get $exception")
    }

    val handler2 = CoroutineExceptionHandler { _, exception ->
        println("CoroutineExceptionHandler : 2 ")
    }
//    val job = GlobalScope.launch(handler) {
//        throw AssertionError()
//    }
//
//    val deferred = GlobalScope.async(handler) {
//        throw ArithmeticException()
//    }

    val job = launch(handler) {
        launch(context = handler2) {
            println("start")
            throw AssertionError()
        }
    }
    job.cancel()

    println("done")
//    joinAll(job, deferred)
}
