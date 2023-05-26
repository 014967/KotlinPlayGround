package coroutine

import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
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
    val producer = produce { // this: ProducerScope
        for (x in 1..5) {
            send(x)
        }
        println("Done")
    }
//    val producer = Channel<Int>()

//    launch {
//        for (x in 1..5) {
//            producer.send(x)
//        }
//    }

    launch {
        for (x in producer) {
            println(producer.receive().toString())
        }

        producer.consumeEach { println(it.toString()) }

//        for (x in producer) {
//            println(x.toString())
//        }
    }
}
