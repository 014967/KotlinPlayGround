package coroutine

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
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
    val s = listOf(1, 2, 3, 4, 5, 6)

    launch {
        s.forEach {
            launch(Dispatchers.Default) {
                p(it)
            }
        }
    }
}
suspend fun p(x: Int) {
    println("${Thread.currentThread().name} $x")
}
