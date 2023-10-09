package study.step1.item1

/*
상태를 구성하는 변경 가능한 객체를 노출하는 것은 특히 위험한 것?


 */

data class User2(val name: String)
class UserRepository(
    private val storedUser: MutableMap<Int, String> = mutableMapOf()
) {
    fun loadAll(): MutableMap<Int, String> {
        return storedUser
    }
}

fun main() {
    val userRepository = UserRepository()
    val storedUsers = userRepository.loadAll()
    storedUsers[4] = "Kirill"
    println(userRepository.loadAll())
}
