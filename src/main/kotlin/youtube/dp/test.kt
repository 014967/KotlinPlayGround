package youtube.dp

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
var count = 0
fun main() {
    val thread1 = Thread(LogThread())
    val thread2 = Thread(LogThread())
    val thread3 = Thread(LogThread())
    val thread4 = Thread(LogThread())
    val thread5 = Thread(LogThread())

    thread1.start()
    thread2.start()
    thread3.start()
    thread4.start()
    thread5.start()
}
class LogThread() : Runnable {
    override fun run() {
        count++
        println(Thread.currentThread().name + " $count")
    }
}
