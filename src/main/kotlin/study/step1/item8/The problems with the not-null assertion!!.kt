package study.step1.item8

/*
널러블을 처리하는 가장 간단한 방법은 !! 을 사용하는것.
무언가가 null이 아니라고 생각하고 틀린경우 npe가 발생한다.
!!은 lazy 옵션임
아무것도 설명하지 않고 일반적인 예외를 던짐
짧고 간단하기 때문에 남용이 쉬움
현재 예상되지 않더라고 미래에는 거의 항상 예상 될 수 있으며, 이 연산자는 nullable을 조용히 숨김 -> 이게 문제임

nullable에 대한 정보는 침묵되어있어 중요할 수 있는 정보를 놓치기 쉬움.


class UserControllerTest {
private var dao: UserDao? = null
private var controller: UserController? = null
@BeforeEach fun init() {
dao = mockk()
        controller = UserController(dao!!)
    }
@Test
fun test() {
        controller!!.doSomething()
    }
}
처음에 nullable로 선언하고 나중에 !!를 사용하는 것은 좋지 않음.

매번 프로퍼티의 포장을 풀어야한다는 것은 매우 성가심. 미래의 null을 가질 수 있는 가능성을 차단해버림.
lateinit 또는 Delegates.notNull을 사용해.


명시적 에러는 일반적인 NPE보다 훨씬 더 많은 것을 나타내므로 거의 항상 선호되어야함.
!!가 의미있는 경우는 다음과 같음
널 가능성이 올바르게 표현되지 않은 라이브러리와의 일반적인 상호 운용성의 결과.



 */

fun main(){

}