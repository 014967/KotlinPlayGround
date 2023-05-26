package coroutine

import kotlinx.coroutines.Dispatchers
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
    val list = listOf(1, 2, 3, 4, 5, 6)
    launch {
        list.forEach {
            launch(Dispatchers.Default) {
                test(it)
            }
        }
    }
}
suspend fun test(x: Int) {
    println(x)
}
