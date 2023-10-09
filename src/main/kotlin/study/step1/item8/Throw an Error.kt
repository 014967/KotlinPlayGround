package study.step1.item8

/*
무언가에 대해 강한 기대가 있을 때 충족되지 않을 때 에러를 던져 프로그래머에게 예기치 않은 상황을 알리는 것이 좋다.
throw를 사용할 수 있을 뿐만아니라, not-null assertion!!, requireNotNull checkNotNull
또는 기타 에러 던지기 함수를 사용할 수도 있습니다.

fun process(user: User){
 requireNotNull(user.name)
 val context = checktNotNull(context)
 val networkServie = getNetworkService(context) ?: throw NoInternetConnection()
 networkService.getData{ data, userData -> show(data!!, userData!!)}
}
*/
fun main() {

}
