package study.step1.item1

/*
불변과 가변 컬렉션을 분리.
코틀린이 읽기 전용 컬렉션을 제공하는 것은 컬렉션 계층 구조가 설계된 방식 덕분에 가능.
읽기 전용 컬렉션이 반드시 불변인것은 아니다. 변경 가능한 경우가 많지만 읽기전용 인터페이스 뒤에
숨겨져 있기 때문에 변경할 수 없는 경우가 많다.

이러한 컬렉션 인터페이스를 진정한 불변이 아닌 읽기 전용으로 만드는 디자인 선택은 매우 중요하다.
내부적으로는 인터페이스를 충족하기만 하면 실제 컬렉션을 반환할 수 있다.
inline fun <T,R> Iterable<T>.map(
    transformation: (T) -> R
    ) : List<R>{
        val list = ArrayList<R>()
        for(elem in this){
            list.add(transformation(elem))
        }
    }

이 접근 방식의 안정성은 변경 불가능한 컬렉션을 사용하는 보안과 거의 비슷하다.
유일한 윟머은 개발자가 시스템 해킹을 시도하여 다운 캐스팅을 수행하는 경우
목록을 읽기전용으로 반환하면 해당 목록이 읽기 전용으로만 사용된다는 것을 신뢰할 수 있어야한다.

컬렉션을 다운 캐스팅하는 것은 계약을 위반하고 추상화 대신 구현에 의존하는 것일 뿐만아니라 안전하지도
않고 예상치 못한 결과를 초래할 수있다.


 */

fun main() {
    val list = listOf(1, 2, 3) // 이게 실제로는 Arrays의 instance로 반환?
    /*
    1,2,3 ->
    new Integer[]{1, 2, 3} 으로 변환되기 때문에
    listOf( Array ) 가 됨.
    실제 코드는
    CollectionsKt.listOf(new Integer[]{1,2,3})
    public fun <T> listOf(vararg elements: T): List<T> = if (elements.size > 0) elements.asList() else emptyList()
    elements는 Array
    Array.asList()가 됨.


    (Java)List list = (Kotlin)CollectionsKt.listOf(new Integer[]{1, 2, 3});
    정리하자면 listOf()는 Collections.kt의 List를 interface를 반환하는데 여기는 add나 set이 없어.
    이것은 Java List로 캐스팅을 하는데. Java의 list에는 add나 set이 있다.

    Java List를 반환해야하는데 CollectionsKt.listOf()에서는 내부에 add,set이 없어서
    if문안에 add를 실행할 수 없는 것.
    Java List는 add, set이 있어서 MutableList로 변환됨.
    하지만 정작안에는 add가 없는 것.


     */

    if (list is MutableList) {
        list.add(4)
    }
    println(list)
}
/*
위의 코드는 플랫폼에 따라 다르다.
JVM에서는 listOf는 Arrays의 인스턴스를 반환한다.

이 Java List 인터페이스에는 add 또는 set 과 같은 메서드가 있어서
Kotlin MutableList 인터페이스로 변환된다.
그러나 Arrays.ArrayList는 이러한 연산 중 일부를 구현하지 않느다.
그래서 Exception이 발생함.

Exception in thread "main" java.lang.UnsupportedOperationException
	at java.base/java.util.AbstractList.add(AbstractList.java:153)
	at java.base/java.util.AbstractList.add(AbstractList.java:111)
	at study.step1.item1.Separation_between_mutable_and_read_only_collectionsKt.main(Separation between mutable and read-only collections.kt:31)
	at study.step1.item1.Separation_between_mutable_and_read_only_collectionsKt.main(Separation between mutable and read-only collections.kt)


읽기 전용에서 변경 가능으로 변경해야 하는 경우 수정할 수 있는 복사본을 생성하는 List.toMutableList 함수를 사용해야 합니다


 */
