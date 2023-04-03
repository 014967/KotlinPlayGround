package coroutine

import kotlinx.coroutines.*
import java.io.IOException

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

fun main(): Unit = runBlocking {
    val handler = CoroutineExceptionHandler { _, exception ->
        println(
            "CoroutineExceptionHandler got $exception with suppressed " +
                exception.suppressed.contentToString()
        )
    }
    val job = GlobalScope.launch(handler) {
        launch {
            try {
                println("#child1")
                delay(Long.MAX_VALUE)
            } finally {
                throw ArithmeticException()
            }
        }
        launch {
            println("#child2")
            delay(100)
            throw IOException()
        }
        println("#?")
        delay(Long.MAX_VALUE)
    }
    job.join()
}
