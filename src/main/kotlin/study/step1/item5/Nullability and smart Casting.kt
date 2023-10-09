package study.step1.item5

/*
require와 check에는 모든 함수가 반환할 때 이 검사 후 해당 술어가 true임을 명시하는 Kotlin constact?가 있다.
@kotlin.internal.InlineOnly
public inline fun require(value: Boolean, lazyMessage: () -> Any): Unit {
    contract {
        returns() implies value
    }
    if (!value) {
        val message = lazyMessage()
        throw IllegalArgumentException(message.toString())
    }
}
 */
fun main() {
}

/*
해당 블록에서 체크된 모든 것은 나중에 같은 함수에서 참으로 취급된다.
 */
//
// data class Person(val outfit: Dress)
// fun changeDress(person: Person) {
//    require(person.outfit is Dress)
//    val dress: Dress = person.outfit
// }

/*
null check할 때도 사용된다.
 */

class Person(val email: String?)
fun sendEmail(person: Person, title: String, text: String) {
//    val email = requireNotNull(person.email)
    val email: String = person.email ?: return

    requireNotNull(person.email)
    validateEmail(person.email)
}

// 이러한 경우를 위해서 requireNotNull, checkNotNull도 있음. 스마트 캐스팅과 변수를 언패킹하는 표현식으로 사용가능
fun validateEmail(email: String) {}

/*
무효화를 위해 오른쪽에 throw또는 return과 함께 Elvis연산자를 사용하는 것도 인기가 있다.
이러한 구조는 가독성이 높다.
에러 대신에 반환을 사용하여 함수를 쉽게 중지할 수 있다.
 */

/*
프로퍼티가 올바르지 않은 경우 두개 이상의 액션을 수행해야하는 경우 return , throw를 run 함수에 랩핑하여 사용할 수있다.
이러한 경우는 중지된 이유를 기록하는데 사용할 수있다.

val email : String = person.email ?: run{
 log("Email not send bacuse  ~~")
 return
}
 */
