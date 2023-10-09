package study.step1.item2
/*
상태를 정의할 때는 변수와 프로퍼티의 범위를 다음과 같이 좁히는 것을 선호해라.
- 프로퍼티 대신 로컬 변수 사용
- 가능한 가장 좁은 범위에서 변수 사용, 에를 들어 변수가 루프 내부에서만 사용되는 경우 이 루프 내부에서 정의
 */
fun main() {
}

// Bad
/*
var user : User
for ( i in users.indices){
    user = users[i]
    println("User at $i is $user")
}
 */
//Better
/*
for( i in users.indices){
    val user = users[i]
    print("User at $i is $user")
}
 */

//
/*
for( (i,user) in users.withIndex()){
    println("User at $i is $user")
}
 */

/*
변수의 범위를 좁히면 프로그램을 추적하고 관리하기가 더 쉬어짐.

변수가 읽기 전용이든 읽기-쓰기이든, 항상 변수를 정의할 때 초기화되는 것이 좋다.
개발자가 변수가 정의된 위치를 찾도록 강요하지마라.

 */