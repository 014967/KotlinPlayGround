package study.step1.item8

/*
무의미한 nullable 방지
nullable은 처리하는데 비용이 발생하니까 피하는게 좋음.

- 값을 사용하기 전에 값이 확실히 설정되었지만 클래스 생성 중보다 늦게 설정된 경우 lateinit또는 notNull Delegates를 사용해라.
- 빈 컬레션 대신 null을 반환하지 마라. 요소가 부족함을 나타내려면 빈 컬렉션을 사용해라
- Nullable Enum와 None Enum 값은 다른 구자기 메세지임.
null은 별도로 처리해야하지만, None은 아님.

lateinit property and notNull delegate

- lateinit은 매번 프로퍼티를 언팩킹 할 피룡없음
- 프로퍼티가 초기화되면 초기화되지 않은 상태로 돌아갈 수 ㅇ벗음
- 나중에 쉽게 nullable하게 만들 수있음.

lateinit은 처음 사용하기 전에 초기화할 것이 확실할때 사용하는 것이 좋음.
primitive type에서는 lateinit을 사용할 수 없음
따라서 Delegates.NotNull을 사용해야함.

class DoctorActivity: Activity(){
    private var doctorId: Int by Delegates.notNull()
    private var fromNotification: Boolean by Delegates.notNull()

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        doctorId = intent.extras.getInt(DOCTOR_ID_ARG)
        fromNotification = intent.extras.getBoolean(FROM_NOTIFICATION_ARG)
    }
}
 */
fun main() {

}
