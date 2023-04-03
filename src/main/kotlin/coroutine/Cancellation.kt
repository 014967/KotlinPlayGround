package coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
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

fun main(): Unit = runBlocking {
    val js = GlobalScope.launch {
        val job = launch {
            delay(1000)
            throw RuntimeException()
        }
        try {
            job.join()
        } catch (e: Throwable) {
            println(e.message)
        }
    }
    js.join()
}
