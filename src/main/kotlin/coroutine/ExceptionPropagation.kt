package coroutine

import kotlinx.coroutines.*

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
fun main() = runBlocking {
    val handler = CoroutineExceptionHandler {
            contenxt, e ->
        println("uncaught exception $e")
    }
    launch(handler) { // 1
        delay(1000)
        println("launch 1 done")
        throw IndexOutOfBoundsException()
    }
    launch { // 2
        delay(500)
        println("launch 2 done")
    }
    launch { // 3
        delay(1500)
        println("launch 3 done")
    }
 println("main end")
}
