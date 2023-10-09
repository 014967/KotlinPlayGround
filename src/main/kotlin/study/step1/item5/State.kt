package study.step1.item5

/*
특정 조건에서 일부 기능만 사용할 수 있도록 허용하는 경우가 종종있다.
- 일부 함수는 먼저 초기화할 객체가 필요할 수있다.
- 사용자가 로그인한 경우에만 작업이 허용될 수 있다.
- 함수를 사용하려면 객체가 열려있어야할 수 있다.

 */

fun main() {
}

//fun speak(text: String) {
//    check(isInitialized)
//}
//fun getUserInfo(): UserInfo {
//    checkNotNull(token)
//}
//fun next(): T {
//    check(isOpen)
//}


/*
check함수는 require와 유사하게 작동하지만 명시된 기대치가 충족되지 않으면 IllgalStateException을 던진다.
이 함수는 상태가 올바른지 확인한다.
전체함수에 대한 기대치가 있는 경우, 일반적으로 require 블록 뒤의 처음에 배치한다.

 */