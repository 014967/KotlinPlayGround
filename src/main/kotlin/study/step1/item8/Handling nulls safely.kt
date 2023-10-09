package study.step1.item8

// safe 콜과 스마트 캐스팅을 사용하는 것이 가장 널리 사용됌.
/*
 - printer?.print()
 - if(printer != null) printer.print() -> 스마트 캐스팅
 프린터가 null이 아닌경우에 print함수를 호출하게된다.
- val printerName1 = printer?.name ?: "Unnamed"
- val printerName2 = printer?.name ?: return
- val printerName3 = printer?.name ?: throw Error("Printer must be named")

println("What is your name?")
val name = readLine()
if (!name.isNullOrBlank()) {
    println("Hello ${name.toUpperCase()}")
}
val news: List<News>? = getNews()
if (!news.isNullOrEmpty()) {
    news.forEach { notifyUser(it) }
}

방어 및 공격 프로그래밍
모든 가능성을 올바른 방식으로 차리하는 것이 방어적 프로그래밍의 구현.
방어 프로그래밍은 코드가 프로덕션 환경에서 실행된 후 현재 불가능한 상황을 방어하여 코드 안정성을 높이는 다양한 관행을 포괄적으로 말함.
가능한 모든 상황을 처리할 수 있는 올바른 방법이 있을 때 가장 좋은 방법.

공격적 프로그래밍의 개념은 예기치 않은 상황이 발생했을때 큰 소리로 불만을 제기하여 그러한 상황을 초래한 개발자에게 알리고 강제로 수정하도록하는것?ㅋㅋ
 */
fun main() {

}
