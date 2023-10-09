package study.step1.item1

/*
불변 객체 ( 원시 객체)를 선호하는데에는 여러가지 이유가 있다.
1. 생성된 후에는 동일하기 유지됨.
2. 불변성은 공유 객체 간에 충돌이 없기 때문에 프로그램 병렬화하기가 쉬움.
3. 불변 객체에 대한 참조는 변경되지 않으므로 캐시할 수 있음.
4, 불변 객체에 대해 방어적인 복사본을 만들 필요가 없다.
5. 불변 객체는 다른 객체를 구성하기에 완벽한 재료다. 가변성이 발생하는 위치를 결정할 수 있고, 불변 객체에서 작업하는 것이 더 쉽다.
 */

class User(
    var name: String,
    val surname: String
) {
    fun withSurname(surname: String) = User(name, surname)
}

data class UserClass(
    val name: String,
    val surname: String
)
fun main() {
//    var user = User("Maja", "Markiewicz")
//    user = user.withSurname("Moskała")
//    print(user) // User(name=Maja, surname=Moskała)
    var user = UserClass("Maja", "Markiewicz")
    user = user.copy(surname = " Moskala")
    println(user)
}
