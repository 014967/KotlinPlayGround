package study.step1.item1

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

// var name: String = "Kim"
// var surname: String = "HyunKuk"
// val fullName: String
//    get() = "$name $surname" // 이거 왜 main에서는 사용할 수 없음?
//
// val fizz = calculate()
// val buzz get() = calculate()
//
// fun main() {
//    // 읽기 전용 프로퍼티가 반드시 불변하거나 최종적인것은 아니라는 것을 유의해라.
//    // 읽기 전용 프로퍼티는 변경 가능한 객체를 보유할 수 있다.
//    val list = mutableListOf(1, 2, 3)
//    list.add(4)
//    println(list)
//
//    println(fullName)
//    surname = "fff"
//    println(fullName)
//    println()
//
//    println(fizz) // 42
//    println(fizz) // 42
//    // custom getter가 없는 경우는 calculate의 println문을 무시하는듯.
//    println(buzz)
//    println(buzz)
// }
//
// fun calculate(): Int {
//    println("Calculating ...")
//    return 42
// }
/*
    프로퍼티가 기본적으로 캡슐화되고 사용자 지정 접근자 (getter, setter)를 가질 수 있다는 특성은
    API를 변경하거나 정의할 때 유연성을 제공하기 때문에 Kotlin에서 매우 중요하다.

    읽기 전용 속성 val의 값은 변경할 수 있지만, 변이지점을 제공하지 않는다.

    val은 불변을 의미하지않는다. 게터나 델리게이트에 의해 정의될 수 있다.
    이 사실은 우리에게 더 많은 변경의 자유를 준다.
    하지만 그럴 필요 없을 때는 최종 프로퍼티를 선호해야한다.
    초기화 옆에 상태가 명시되어있기 때문에 추론하기가 더 쉽다.
    또한 kotlin에서 더 잘지원된다. -> 스마트 캐스팅이 가능하다?
    하단 코드를 보면 custom getter를 쓰지 않으면 스마트 케스팅을 사용할 수 있음.

 */

val name: String? = "Marton"
val surname: String? = "Barun"
val fullName: String?
    get() = name?.let { "$it $surname" }
val fullName2: String? = name?.let { "$it $surname" }

fun main() {
    if (fullName != null) {
//        println(fullName.length) // smart casting error
    }
    if (fullName2 != null) {
        println(fullName2.length)
    }
}


/*
smart casting?
프로그래머가 원하는 타입으로 캐스팅하지 않아도, 컴파일러가 알아서 캐스팅해주는 것을 말한다.
 */