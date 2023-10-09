package study.step1.item1

import kotlin.concurrent.thread
import kotlin.properties.Delegates

/*
변하는 목록을 표현해야한다고 가정해라.
이를 구현하는 방법은 2가지 있다.
변경 가능한 컬렉션을 사용하거나 읽기-쓰기 속성 var를 사용하는 것.
 */
fun main() {
    val list1: MutableList<Int> = mutableListOf()
    var list2: List<Int> = listOf()

    list1.add(1)
    list2 = list2 + 1

    list1 += 1 // list1.plusAssign(1)
    list2 += 1 // list2.plus(1) // 찾아볼 수가 없음;

    println(list1)
    println(list2)

    var list = listOf<Int>()
    val lock = Any()
    for (i in 1..1000) {
        thread {
//            synchronized(lock) {
            list = list + i
//            }
        }
    }
    Thread.sleep(1000)
    println(list.size)

    var names by Delegates.observable(listOf<String>()) { _, old, new ->
        println("Names changed from $old to $new")
    }

    names += "Fabio"
    names += "Bill"

    println(names)
}
/*
첫번째 방법은 구체적인 목록 구현에서 변환이 발생
멀티 스레딩의 경우 적절한 동기화가 있다는 사실에 의존할 수 있지만 실제로 보장되지 않기 때문에 그러한 가정도 위험

두번째 방법은 동기화를 직접 구현해야하지만,변환 지점이 단일 프로퍼티에 불과하기 때문에 전반적인 보안이 더좋다?

 */

/*
변경 가능한 list대신 변경가능한 프로퍼티를 사용하면 사용자 저으이 세터를 정의하거나 델레게이트를 사용할 때
이 프로퍼티가 어떻게 변경되는지 추적할 수있다.

변경가능한 컬렉션에서 이를 가능하게 하려면 컬렉션의 특별한 관찰 가능한 구현이 필요하다.
변경 가능한 컬렉션을 사용하는 것이 약간 더 빠른 옵션이지만, 대신 변경 가능한 프로퍼티를 사용하면 객체가 변경되는 방식을
더 잘 제어할 수 있다.
최악의 해결책은 변경 가능한 프로퍼티와 변경 가능한 컬렉션을 모두 사용하는 것이다.

var ss = mutableListOf<Int>() 이렇게 하지 말고

 */
