package study.step1

class BackAccount {
    /*
    BackAccount에는 해당 계좌에 얼마나 많은 금액이 있는지 나타내는 금액을 나타내는 상태를 갖는다.
    보유 상태는 양날의 검이다. 한편으로는 유용하다.
    시간이 지남에 따라 변화하는 요소를 표현할 수 있기 때문에 매우 유용하다.
    다른 한편으로는 상태관리가 어렵다.


    1. 변경 지점이 많은 프로그램을 이해하고 디버깅하는 것은 프로그램을 이해하고 디버깅하기가 더 어렵다.
    이러한 돌연변이 사이의 관계를 이해해야하며,
    mutations들이 많을 수록 변경이 많을 때 어떻게 변했는지
    추적하기가 어렵다.
    시로 의존하는 많은 변경 지점이 있는 클래스는 이해하고 수정하기가 어렵다.ㅒ

    2. 변경 가능성은 코드를 추론하기 어렵게 만든다.
    한편에 불변 요소의 상태는 명확하다.
    우리가 어느 순간에 확인했다고해서 여전히 동일하다는 의미는 아니다.

    3. 또한 멀티스레드 프로그램에서 적절한 동기화가 필요하다. 모든 돌연변이는 잠재적인 충돌이다.

    4. 변경가능성이 있는 요소들은 테스트를 힘들게 한다. 가능한 모든 상태를 테스트해야하고, 가변성이 많을 수록 테스트할 상태가 많아진다.

    5. 상태가 변경되면 종종 다른 클래스에 이 변경 사항에 대해 변경에 대한 알림을 받아야하는 경우가 많다.

    ----


     */

    var balance = 0.0
        private set
    // 내부에서만 사용하는 프로퍼티에서 setter만 막고 getter만 지원
    // 외부에 setter를 허용하지 않을 수 있다.

    /*
       var로 선언된  프로퍼티에 대해서는 private set 기능을 제공하지 않음. ( 생성자에 넘기는 것을 말하는듯 )

     */

    fun deposit(depositAmount: Double) {
        balance += depositAmount
    }

    @Throws(InsufficientFunds::class)
    fun withdraw(withdrawAmount: Double) {
        if (balance < withdrawAmount) {
            throw InsufficientFunds()
        }
        balance -= withdrawAmount
    }
}

class InsufficientFunds : Exception()

fun main() {
    val account = BackAccount()
    println(account.balance)
    account.deposit(100.0)
    println(account.balance)
    account.withdraw(50.0)
    println(account.balance)
}
