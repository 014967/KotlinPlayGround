package coroutine

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

fun main() {
    val list = arrayListOf(1, 2, 3, 4, 5)
    list.add(0, 0)
    println(list.joinToString { it.toString() })
}
