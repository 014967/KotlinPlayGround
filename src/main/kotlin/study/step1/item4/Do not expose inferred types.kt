package study.step1.item4

// 추론된 유형 노출 금지?
/*
코틀린에서 타입 추론은 가장 인기 있는 기능
Java 10에서도 타입 추론을 도입했다.

추론된 유형은 슈퍼클래스나 인터페이스가 아니라 오른쪽의 정확한 유형( ex :String )이라는 점을 기억해라.
 */
fun main() {
//    var animal = Zebra()
//    animal = Animal() // Type miss match
    /*
    대부분의 경우 문제가 되지않지만, 너무 제한적인 유형이 유추된 경우 이를 지정하기만 하면 문제가 해결됨
     */

    var animal: Animal = Zebra()
    animal = Animal() // Correct

    /*
    하지만 라이브러리나 다른 모듈을 제어할 수 없을 떄는 위험할 수있다.
    자동자 공장을 재현하는데 사용되는 인터페이스가 다음과 같다고 가정해라.
     */
}

open class Animal
class Zebra : Animal()
