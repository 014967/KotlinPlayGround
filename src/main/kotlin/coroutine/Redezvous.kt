package coroutine

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.channels.Channel
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
    println("RenDezvous")
    val rendezvous = async {
        startRenDezvous()
    }
    rendezvous.await()
    println("---------------------------------------------")
    println("Conflated")

    val conflated = async { startConflated() }
    conflated.await()

    println("---------------------------------------------")
    println("Buffered")

    val buffered = async { startBuffered() }
    buffered.await()

    println("---------------------------------------------")
    println("UnLimit")
    val unLimit = async { startUnLimit() }
    unLimit.await()
}

fun CoroutineScope.startRenDezvous() {
    val channel = Channel<Int>(
        capacity = Channel.RENDEZVOUS,
        onBufferOverflow = BufferOverflow.SUSPEND
    )
    launch {
        for (i in 1..10) {
            println("send $i")
            channel.send(i)
        }
        channel.close()
    }

    launch {
        for (i in channel) {
            println("receive $i")
        }
    }
}

fun CoroutineScope.startConflated() {
    val channel = Channel<Int>(
        capacity = Channel.CONFLATED,
    )
    launch {
        for (i in 1..10) {
            println("send $i")
            channel.send(i)
        }
        channel.close()
    }

    launch {
        for (i in channel) {
            println("receive $i")
        }
    }
}

fun CoroutineScope.startBuffered() {
    val channel = Channel<Int>(
        capacity = Channel.BUFFERED,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )
    launch {
        for (i in 1..100) {
            println("send $i")
            channel.send(i)
        }
        channel.close()
    }

    launch {
        for (i in channel) {
            println("receive $i")
        }
    }
}

fun CoroutineScope.startUnLimit() {
    val channel = Channel<Int>(
        capacity = Channel.UNLIMITED
    )
    launch {
        for (i in 1..10) {
            println("send $i")
            channel.send(i)
        }
        channel.close()
    }

    launch {
        for (i in channel) {
            println("receive $i")
        }
    }
}
