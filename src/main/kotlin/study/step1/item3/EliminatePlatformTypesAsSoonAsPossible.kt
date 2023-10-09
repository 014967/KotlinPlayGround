package study.step1.item3

import study.JavaClass

/*
JAVA 또는 C와 같이 널 안정성이 확실하지 않은 언어와 Kotlin간의 연결은 문제가 있다.
반환유형으로 String을 선언하는 Java메서드를 사용한다고 가정했을때 Kotlin에서는 어떤 유형이여야하는가?
Nullable 어노테이션으로 지정되어있는경우 해당 메서드가 Nullable한것으로 가정하고 String을 해석해야하는가?
NotNull어노테이션이 있는 경우 이 어노테이션을 신회하고 String으로 입력한다.
하지만 이 반환 유형에 이러한 어노테이션 중 어느 것도 되어있지 않다면?

그렇다면 우리는 Nullable으로 처리해야한다. Java는 모든게 Nullable이기 떄문에

 */

fun main() {
    statedType()
//    platformType()
}

fun statedType() {
    // kotlin
    val value: String = JavaClass().value // 여기서 발생
    println(value.length)
}

fun platformType() {
    // java
    val value = JavaClass().value
    println(value.length) // 여기서 발생
    /*
    실제 이 객체를 사용할 때 발생하기 때문에 원인을 찾기가 쉽지 않을 수 있다.

    따라서 노출된 Java 생성자, 메서드 및 필드에 널 가능성을 지정하는 어노테이션을 사용하여 유형을 지정하는 것이 좋습니다.
     */
}

/*
플랫폼 유형은 유형 이름 뒤에 느낌표 하나만 붙여서 표기한다 . String!
플랫폼 유형은 부호화할 수 없으므로 언어에 명시적으로 적을 수 ㅇ없다.

Kotlin과 함께 작동해야 하는 Java 코드를 어느 정도 제어할 수 있는 경우 가능한 경우 @Nullable 및 @NotNull 어노테이션을 도입하세요.

import org.jetbrains.annotations.NotNull;
public class UserRepo{
    public @NotNull User getUser(){
    }
}
 */
