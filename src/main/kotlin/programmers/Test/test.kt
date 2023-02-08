package programmers.Test

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

data class Test(
    val name: String = "",
    val age: Int = 0
) {
    companion object {
        val Empty = Test(
            name = "",
            age = 0
        )
    }
}

fun main() {

    val test = Test(
        "newTest",
        10
    )
    val test1 = Test.Empty.copy(
        name = "newTest1",
        age = 10
    )
    val test2 = Test.Empty.copy(
        name = "newTest2",
        age = 10
    )

    println(test1.hashCode())
    println(Test.Empty.hashCode())
    println(test2.hashCode())
    println(Test.Empty.hashCode())
}
