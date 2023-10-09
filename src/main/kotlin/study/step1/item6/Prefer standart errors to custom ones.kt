package study.step1.item6

// 사용자 지정 오류보다 표준 오류 선호
/*
require, check, assert는 가장 일반적인 Kotlin 오류를 다루지만, 표시해야하는 다른 종류의 예상치 못한 오류가 있을 수있 다.
예를 들어 Json 파일의 형식이 올바르지 않은 경우 JsonParsingException을 throw하는것이 합리적.
 */
fun main() {

}

//inline fun <reified T> String.readObject() : T{
//    if(){
//        throw JsonParsingException()
//    }
//    return result
//}

/*
여기서는 표준 라이브러리에 해당 상황을 나타내는 적절한 오류가 없기 때문에 사용자 정의 오류를 사용했다.
가능하면 자체적으로 정의하는 대신에 표준 라이브러리의 예외를 사용해야한다.
잘 정립된 컨트랙트로 알려진 요소로 재사용하면 API를 더 쉽게 배우고 이해할 수 있다.

- IllgalArgumentException and IllegalStateException은 require, check에서 사용된다.
- IndexOutOfBoundsException index매개변수 값이 범위를 벗어낫었을때 컬렉션과 배열에서 사용
- ConcurrentModificationException 동시 숩정이 금지되어있음에도 불구하고 동시 수정이 감지 되었음.
- UnsupportedOperationException 선언된 메서드가 객체에서 지원되지 않음을 나타낸다.
- NoSuchElementException 요청된 엘리먼트가 존재핮 ㅣ않음을.
 */