package study.step1.item7

// null과 FailureResult를 선호?
/*
함수가 원하는 결과를 생성하지 못하는 경우가 있다.
- 서버에서 데이터를 가져올때 인터넷 연결문제가 있는 경우
- 일부 크리테리아와 일치하는 첫번째 요소를 가져오려고 하지만 목록에 그러한 요소가 없다
- 텍스트에서 객체를 구문 분석하려고하지만 텍스트의 형식이 잘못되었다.

이러한 상황을 처리하는 두가지 주요 메커니즘이 있다.
- 실패를 나타내는 널또는 봉인된 클래스를 반환한다.
- 예외를 던진다.


이 둘사이에는 중요한 차이점이 있다.
예외를 정보 전달의 표준 방법으로는 사용해서는 안된다.
모든 예외는 잘못된 특수한 상황을 나타내므로 이러한 방식으로 처리해야한다.
예외는 예외적인 상황에서만 사용해야한다.
- 예외가 전파되는 방식은 대부분의 프로그래머에게 가독성이 떨어지고 코드에서 쉽게 놓칠 수 있다.
- Kotlin에서는 모든 예외가 선택 취소된다. 사용자가 예외를 처리하도록 강요하거나 권장하지도 않는다. 예외는 잘 문서화되어있지 않은 겨우가 많다.
- 예외는 예외적인 상황을 위해 설계되었기 때문에 JVM구현자가 예외를 명시적으로 테스트만큼 빠르게 만들 유인이 거의 업삳?
- try-catch블록안에 코드를 배치하면 컴파일러가 수행할 수 있는 특정 최적화가 억제됩니다.

반면에 null또는 Failure는 모두 예상 오류를 나타내는데 적합합니다.
명시적이고 효율적이며 관용적인 방식으로 처리할 수 있다.
그렇게 때문에 오류가 예상되는 경우 null또는 Failure를 반환하고 오류가 예상되지 않는 경우 예외를 던지는 것을 선호해야한다는 규칙?

 */
fun main() {
}

// inline fun <reified T>String.readOjbectOrNull(): T? {
//    if (false) {
//        return null
//    }
//    return result
// }
//
// inline fun <reified T> String.readObject(): Result<T> {
//    if (false) {
//        return Failure(JsonParsingException)
//    }
//    return Success(result)
// }

sealed class Result<out T>
class Success<out T> (val result: T) : Result<T>()
class Failure(val throwable: Throwable) : Result<Nothing>()
class JsonParsingException : Exception()

/*
이러한 방식으로 표시된 오류는 처리하기 쉽고 놓치기 어렵습니다.
null을 사용하도록 선택하면 해당 값을 처리하는 클라이언트는 세이프 콜이나 Elvis연산자와 같은
다양한 null안전 지원 기능중에서 선택할 수 있다.

val age = userText.readObjectOrNull<Person>()?.age \ ?:-1

Result와 같은 유니온 유형을 반환하도록 선택하면 사용자는 when을 통해서 처리할 수 ㅣㅆ다.
val age = when(val persion = userText.readOjbectOrNull<Person>()){
    is Successs -> person.age
    is Failure -> -1
}
 */

/*
이러한 오류 처리를 사용하면 트라이 캐치 블록보다 더 효율적이고 사용하기 더 쉽다. 또한 명시적임.
예외를 놓치면 전체 애플리케이션이 중단될 수 있다.
반면 널값이나 봉인된 결과 클래스는 명시적으로 처리해야하지만 애플리케이션의 흐름이 중단되지는 않는다.

nullable result와 sealed Result  class를 비교하면 실패시 추가 정보를 전달해야하는 경우 후자를 선호하고
그렇지 않은 경우 무효화를 선호해야한다.
실패는 필요한 모든 데이터를 보유할 수 있다는 점을 기억해라.

실패가 발생할 수 있다고 예상하는 함수와 예상치 못한 상황으로 처리하는 함수의 두가지 변형 함수를 사용하는 것이 일반적이다.
좋은 예가 List에 두가지가 모두 있다는 것.
- get은 element가 주어진 위치에 있을 것이라고 예상 IndexOutOfBoundsException을 던진다.
- getOrNull은 범위를 벗어난 엘리먼트를 요청한다고 가정할 때 사용하며, 그럴 경우 null을 반환한다.

getOrDefault로 지원함.

 */