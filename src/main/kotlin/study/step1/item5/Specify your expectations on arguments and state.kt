package study.step1.item5

// 인수 및 상태에 대한 기대치를 지정합니다.
/*
기대치가 있다면 가능한 빨리 선언해라?

require - 인자에 대한 기대치를 지정하는 보편적인 방법
check - 상태에 대한 기대치를 지정하는 보편적인 방법
assist - 어떤 것이 참인지 확ㅇ니하는 보편적인 방법
Elvis operator return or throw.
 */
fun main() {
    /*
// Part of Stack<T>
fun pop(num: Int = 1): List<T> {
    require(num <= size) {
       "Cannot remove more elements than current si\
   check(isOpen) { "Cannot pop from closed stack" }
    val collection = innerCollection ?: return empty\ List()
    val ret = collection.take(num) innerCollection = collection.drop(num) assert(ret.size == num)
    return ret
}
 */
}
/*
장점들이 있다
- 문서를 읽지 않은 프로그래머도 기대치를 알 수 있다.
- 기대치가 충족되지 않으면 함수는 예기지 않은 동작으로 이어지는 대신 예외를 던진다.
- 코드는 자체 점검이 가능하다.
- 모든 검사는 스마트 캐스팅과 함께 작동하므로 캐스팅이 덜 필요하다.

 */
