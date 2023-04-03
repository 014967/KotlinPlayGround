package coroutine

import kotlinx.coroutines.Job
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

fun main(): Unit = runBlocking { // #3 A
    val job = Job()
    launch(job) {
        repeat(1000) { i ->
            delay(50)
            println("$i")
        }
    }
    job.cancel()
}
// Will be printed
// Exception in thread "main" java.lang.Error: Some error...
