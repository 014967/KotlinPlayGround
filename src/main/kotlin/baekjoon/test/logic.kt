package baekjoon.test

data class Notification(
    val id: String = "",
    val drawable: String? = null,
    val appTitle: String = "",
    val notiTime: String = "",
    val title: String = "",
    val content: String = "",
    val intent: String? = null
) {
    companion object {
        val dummy = listOf(
//            subText -> 그룹채팅방이름

            Notification(id = "0|com.kakao.talk|2|18341494911013553|10744", drawable = "android.graphics.drawable.AdaptiveIconDrawable@3f70c9c", appTitle = "성빈랜드 안드로이드 놀이터", notiTime = "오후 15:28", title = "에이치아이", content = "androidx.compose.ui.viewinterop.AndroidViewBinding\n사용해보신 분 계실까요?\n일부 뷰가 영역을 제대로 잡지 못하는 문제를 겪고있습니다 ㅠㅠ", intent = null),
            Notification(id = "0|com.kakao.talk|2|18341494911013553|10744", drawable = "android.graphics.drawable.AdaptiveIconDrawable@3f70c9c", appTitle = "성빈랜드 안드로이드 놀이터", notiTime = "오후 15:44", title = "에이치아이", content = "androidx.compose.ui.viewinterop.AndroidViewBinding\n사용해보신 분 계실까요?\n일부 뷰가 영역을 제대로 잡지 못하는 문제를 겪고있습니다 ㅠㅠ", intent = null),
            Notification(id = "0|com.kakao.talk|2|4645249337024757|10744", drawable = "android.graphics.drawable.AdaptiveIconDrawable@2b016a5", appTitle = "카카오톡", notiTime = "오전 09:43", title = "카카오톡 선물하기", content = "(광고)소중한 분에게 마음이 전해질 수 있도록💖\n설 무드를 담은 패키지로 감동을 전하세요.", intent = null),
            Notification(id = "0|com.kakao.talk|2|4817811595882745|10744", drawable = "android.graphics.drawable.AdaptiveIconDrawable@47e1a7a", appTitle = "카카오톡", notiTime = "오전 09:34", title = "카카오웹툰", content = "(광고)글로벌 143억뷰🌏\nALL TIME LEGEND🏆\n<나 혼자만 레벨업> 외전 공개!\n딱 3일 동안 진행되는 총 1억 캐시 선물을 놓치지 마세요.", intent = null),
            Notification(id = "0|com.samsung.android.messaging|123|com.samsung.android.messaging:MESSAGE_RECEIVED:6|10127", drawable = "android.graphics.drawable.AdaptiveIconDrawable@a1ea22b", appTitle = "메시지", notiTime = "오후 13:11", title = "⁨IBK 기업은행⁩", content = "[Web발신]\n2023/01/21 13:11\n출금 4,500원\n잔액 2,699원\n할리스커피 무악재역\n087***30701034\n기업", intent = null),
            Notification(id = "0|com.zoyi.channel.desk.android|0|null|10408", drawable = "android.graphics.drawable.BitmapDrawable@cb65688", appTitle = "채널톡", notiTime = "오후 14:54", title = "💬조던 128", content = "새로운 유저챗: 안녕하세요!\n혹시 제출하는 포트폴리오 형식이 노션으로 된것도 괜찮을까요?🥹", intent = null),
            Notification(id = "0|com.zoyi.channel.desk.android|276|null|10408", drawable = "android.graphics.drawable.BitmapDrawable@d307821", appTitle = "채널톡", notiTime = "오후 14:54", title = "💬조던 128", content = "새로운 유저챗: 안녕하세요!\n혹시 제출하는 포트폴리오 형식이 노션으로 된것도 괜찮을까요?🥹", intent = null),
            Notification(id = "0|com.zoyi.channel.desk.android|274|null|10408", drawable = "android.graphics.drawable.BitmapDrawable@cc36446", appTitle = "채널톡", notiTime = "오후 12:56", title = "💬체리 728", content = "새로운 유저챗: 노드팀 스터디는 무슨요일에 진행되나요?", intent = null),
            Notification(id = "0|com.zoyi.channel.desk.android|272|null|10408", drawable = "android.graphics.drawable.BitmapDrawable@be33607", appTitle = "채널톡", notiTime = "오전 11:58", title = "💬아보카도 882", content = "새로운 유저챗: 스프링팀은 총 몇 명 선발할 계획인가요?", intent = null),
            Notification(id = "0|com.zoyi.channel.desk.android|270|null|10408", drawable = "android.graphics.drawable.BitmapDrawable@a9e5334", appTitle = "채널톡", notiTime = "오전 11:50", title = "💬리본 349", content = "새로운 유저챗: iOS파트 모집인원이 얼마나 되나요?", intent = null),
            Notification(id = "0|com.nexon.fo4m|462|null|10789", drawable = "android.graphics.drawable.BitmapDrawable@bc17ed2", appTitle = "Fifa online 4 m", notiTime = "오후 14:00", title = "[FIFA 온라인 4 M 참여 가능] 설날 버닝 이벤트 1일차", content = "(광고) 1/21(토) 설날 버닝 이벤트에 참여하세요. ①접속만 해도 보상 지급! ②누적 2판, 5판, 8판 플레이 시 보상 지급! ③PC방에서 접속하면 접속 시간에 따라 추가 보상 지급! ④ 강화 시도 시 강화 부스트 효과 게이지 25% 증가! 수신거부>게임 내 설정", intent = null),
            Notification(id = "0|com.nexon.fo4m|461|null|10789", drawable = "android.graphics.drawable.BitmapDrawable@e732ba3", appTitle = "Fifa online 4 m", notiTime = "오후 13:00", title = "감독모드 티어 상승 방법", content = "(광고) 현다노비치 구단주님, 공격수 투자비율을 늘려보세요. 티어 상승에 도움이 될 거예요! 수신거부>게임 내 설정", intent = null),
            Notification(id = "0|com.nexon.fo4m|460|null|10789", drawable = "android.graphics.drawable.BitmapDrawable@1676ea0", appTitle = "Fifa online 4 m", notiTime = "오전 04:20", title = "이적시장", content = "3강 정성룡선수 114,000,000BP 판매완료", intent = null),
            Notification(id = "0|com.samsung.android.app.updatecenter|20201400|null|10419", drawable = "android.graphics.drawable.AdaptiveIconDrawable@c7f0a59", appTitle = "앱 업데이트", notiTime = "오전 11:05", title = "앱 업데이트 중지됨", content = "Wi-Fi 연결을 기다리는 중… (643MB)\n[Samsung Notes Add-ons, Galaxy Wearable, Samsung Kids, Samsung Notes, 삼성 인터넷, Samsung Health, Smart​Things, Samsung Members, Samsung Pay, Smart Switch, 음성 녹음]", intent = null),
            Notification(id = "0|com.sec.android.app.shealth|105|null|10296", drawable = "android.graphics.drawable.AdaptiveIconDrawable@114b61e", appTitle = "Samsung Health", notiTime = "오후 14:48", title = "1,376걸음", content = "목표 걸음 수는 6,000입니다.", intent = null),
            Notification(id = "0|com.nhn.android.webtoon|-766790973|null|10387", drawable = "android.graphics.drawable.AdaptiveIconDrawable@e82deff", appTitle = "네이버 웹툰", notiTime = "오후 12:07", title = "<월간 네웹 어워즈> 핫이슈", content = "(광고) 머리부터 발끝까지 핫이슈! 커뮤니티를 뜨겁게 달군 바로 그 웹툰! (수신거부:설정)", intent = null),
            Notification(id = "0|com.nhn.android.webtoon|-769927746|null|10387", drawable = "android.graphics.drawable.AdaptiveIconDrawable@5e4d4cc", appTitle = "네이버 웹툰", notiTime = "오전 11:15", title = "[쿠키자동충전] 자동충전이 진행되지 않았습니다.", content = "결제 정보를 확인하시거나 네이버페이 고객센터로 문의해 주세요.", intent = null),
            Notification(id = "0|com.google.android.gm|0|gig:1844822892:^sq_ig_i_personal|10259", drawable = "android.graphics.drawable.AdaptiveIconDrawable@d0cf315", appTitle = "boris08156@gmail.com", notiTime = "오전 08:49", title = "Medium Daily Digest", content = "What is new in Android Studio Electric Eel ? 🔥 | Rey | AndroidGeek.co", intent = null),
            Notification(id = "0|com.google.android.gm|188546320|gig:1844822892:^sq_ig_i_personal|10259", drawable = "android.graphics.drawable.AdaptiveIconDrawable@7d2162a", appTitle = "boris08156@gmail.com", notiTime = "오전 08:49", title = "Medium Daily Digest", content = "What is new in Android Studio Electric Eel ? 🔥 | Rey | AndroidGeek.co", intent = null),
            Notification(id = "0|com.nexon.fo4|-791122104|null|10031", drawable = "android.graphics.drawable.BitmapDrawable@4f071b8", appTitle = "Fifa 공식 도우미", notiTime = "오전 05:22", title = "Fifa 공식 도우미", content = "[노인목꺾기] 프리뷰 도착! 상대방의 프로필을 확인해보세요.", intent = null),
            Notification(id = "0|com.nexon.fo4|-791122156|null|10031", drawable = "android.graphics.drawable.BitmapDrawable@956ab91", appTitle = "Fifa 공식 도우미", notiTime = "오전 05:22", title = "Fifa 공식 도우미", content = "[노인목꺾기] 프리뷰 도착! 상대방의 프로필을 확인해보세요.", intent = null),
            Notification(id = "0|com.nexon.fo4|-792088012|null|10031", drawable = "android.graphics.drawable.BitmapDrawable@5536af6", appTitle = "Fifa 공식 도우미", notiTime = "오전 05:05", title = "Fifa 공식 도우미", content = "[노인목꺾기] 프리뷰 도착! 상대방의 프로필을 확인해보세요.", intent = null),
            Notification(id = "0|com.nexon.fo4|-792088047|null|10031", drawable = "android.graphics.drawable.BitmapDrawable@f5faef7", appTitle = "Fifa 공식 도우미", notiTime = "오전 05:05", title = "Fifa 공식 도우미", content = "[노인목꺾기] 프리뷰 도착! 상대방의 프로필을 확인해보세요.", intent = null),
            Notification(id = "0|com.nexon.fo4|-794042297|null|10031", drawable = "android.graphics.drawable.BitmapDrawable@d16f164", appTitle = "Fifa 공식 도우미", notiTime = "오전 04:33", title = "Fifa 공식 도우미", content = "[하드리구] 프리뷰 도착! 상대방의 프로필을 확인해보세요.", intent = null),
            Notification(id = "0|com.nexon.fo4|-794455911|null|10031", drawable = "android.graphics.drawable.BitmapDrawable@7a96fcd", appTitle = "Fifa 공식 도우미", notiTime = "오전 04:26", title = "Fifa 공식 도우미", content = "[하드리구] 프리뷰 도착! 상대방의 프로필을 확인해보세요.", intent = null),
            Notification(id = "0|com.nexon.fo4|-794841076|null|10031", drawable = "android.graphics.drawable.BitmapDrawable@8c34082", appTitle = "Fifa 공식 도우미", notiTime = "오전 04:20", title = "Fifa 공식 도우미", content = "[하드리구] 프리뷰 도착! 상대방의 프로필을 확인해보세요.", intent = null),
            Notification(id = "0|com.nexon.fo4|-794841972|null|10031", drawable = "android.graphics.drawable.BitmapDrawable@f564393", appTitle = "Fifa 공식 도우미", notiTime = "오전 04:20", title = "Fifa 공식 도우미", content = "[하드리구] 프리뷰 도착! 상대방의 프로필을 확인해보세요.", intent = null),
            Notification(id = "0|com.nhn.android.webtoon|-824020643|null|10387", drawable = "android.graphics.drawable.AdaptiveIconDrawable@703bfd0", appTitle = "네이버 웹툰", notiTime = "오후 20:13", title = "드디어 설 연휴, 새 해엔 새 웹툰!", content = "(광고) 새 해 맞이 새 웹툰보고, 쿠키 복도 많이 받아가세요! (수신거부:설정)", intent = null)

        )
    }
}
/*
GroupNotification(notifications=(GroupKey(packageName=com.kakaopay.app, appTitle=카카오페이, title=(광고) 2월 대출 한도 달라졌을까🧐), [Notification(id=0|com.kakaopay.app|95876|null|10791, drawable=android.graphics.drawable.AdaptiveIconDrawable@bac03e5, appTitle=카카오페이, notiTime=오후 13:16, title=(광고) 2월 대출 한도 달라졌을까🧐, content=이번 달 내 대출 한도 얼마인지 확인해 봐요!
GroupNotification(notifications=(GroupKey(packageName=com.nexon.fo4m, appTitle=FIFA Online 4 M, title=1/26(목) ~ 2/1(수) 2차 윈터 스페셜 보상 수령 마지막날!), [Notification(id=0|com.nexon.fo4m|587|null|10789, drawable=android.graphics.drawable.BitmapDrawable@98b9eba, appTitle=FIFA Online 4 M, notiTime=오후 14:01, title=1/26(목) ~ 2/1(수) 2차 윈터 스페셜 보상 수령 마지막날!, content=(광고) 아직 2차 윈터 스페셜 보상을 수령하지 않았다면, 지금 바로 FIFA 온라인 4에 접속하고 2차 윈터 스페셜 보상 [BWC 4~5강 포함] 윈터 캠프 스페셜팩 (4~8강), 행운의 BP 카드 (4억 ~ 40억)를 수령하세요~ 수신거부>게임 내 설정, intent=null)]))
GroupNotification(notifications=(GroupKey(packageName=com.osp.app.signin, appTitle=삼성 계정, title=삼성 계정 법률 정보 업데이트됨), [Notification(id=0|com.osp.app.signin|20111242|null|10115, drawable=android.graphics.drawable.AdaptiveIconDrawable@8ab716b, appTitle=삼성 계정, notiTime=오후 13:46, title=삼성 계정 법률 정보 업데이트됨, content=새로 업데이트된 정책에 동의하려면 여기를 누르세요., intent=null)]))
GroupNotification(notifications=(GroupKey(packageName=com.samsung.android.app.updatecenter, appTitle=앱 업데이트, title=앱 업데이트 중지됨), [Notification(id=0|com.samsung.android.app.updatecenter|20201400|null|10419, drawable=android.graphics.drawable.AdaptiveIconDrawable@15014c8, appTitle=앱 업데이트, notiTime=오후 16:11, title=앱 업데이트 중지됨, content=Wi-Fi 연결을 기다리는 중… (643MB)
[Samsung Notes Add-ons, Galaxy Wearable, Samsung Kids, Samsung Notes, 삼성 인터넷, Samsung Health, Smart​Things, Samsung Members, Samsung Pay, Smart Switch, 음성 녹음], intent=null)]))
GroupNotification(notifications=(GroupKey(packageName=com.sec.android.app.shealth, appTitle=Samsung Health, title=795걸음), [Notification(id=0|com.sec.android.app.shealth|105|null|10296, drawable=android.graphics.drawable.AdaptiveIconDrawable@1df961, appTitle=Samsung Health, notiTime=오후 13:32, title=795걸음, content=목표 걸음 수는 6,000입니다., intent=null)]))
GroupNotification(notifications=(GroupKey(packageName=com.instagram.android, appTitle=Instagram, title=kim_da_q), [Notification(id=0|com.instagram.android|64278|newstab|4156554640_close_friend_story|10382, drawable=android.graphics.drawable.AdaptiveIconDrawable@c4ec86, appTitle=Instagram, notiTime=오후 14:00, title=kim_da_q, content=crane_for_kim님이 스토리를 추가했습니다. 👋, intent=null)]))
GroupNotification(notifications=(GroupKey(packageName=kr.goodchoice.abouthere, appTitle=여기어때, title=[선착순] 매일 ✌️ 두 번 쿠폰 받아요!), [Notification(id=0|kr.goodchoice.abouthere|1519679059|appboy_notification|10000, drawable=android.graphics.drawable.AdaptiveIconDrawable@98db947, appTitle=여기어때, notiTime=오후 12:56, title=[선착순] 매일 ✌️ 두 번 쿠폰 받아요!, content=(광고) 더하기 쿠폰으로 ~1O% 추가 할인 👉 [수신거부: 내 정보 > 설정], intent=null)]))
GroupNotification(notifications=(GroupKey(packageName=com.nhn.android.webtoon, appTitle=네이버 웹툰, title=벌써 2월! 이번 달은 매일+ 어때요?), [Notification(id=0|com.nhn.android.webtoon|185192384|null|10387, drawable=android.graphics.drawable.AdaptiveIconDrawable@3b5b574, appTitle=네이버 웹툰, notiTime=오후 12:33, title=벌써 2월! 이번 달은 매일+ 어때요?, content=(광고) 따끈따끈 지금 업데이트된 매일+ 작품 살펴보기! (수신거부:설정), intent=null)]))
GroupNotification(notifications=(GroupKey(packageName=com.kakao.talk, appTitle=성빈랜드 안드로이드 놀이터, title=안드안드), [Notification(id=0|com.kakao.talk|2|18341494911013553|10744, drawable=android.graphics.drawable.AdaptiveIconDrawable@d5fca9d, appTitle=성빈랜드 안드로이드 놀이터, notiTime=오후 14:22, title=안드안드, content=맞는 말씀입니다..........., intent=null)]))




 */

fun main() {

//    val s = Notification.dummy.groupBy {
//        val parse = it.id.split("|")
//        val firstKey = parse[1]
//        var secondKey = if (parse[3] == "null") {
//            parse[2]
//        } else parse[3]
//
//        Pair(firstKey, secondKey)
//    }

    val s = Notification.dummy.groupBy {
        val parse = it.id.split("|")
        if (parse[3] == "null") {
            parse[2]
        } else {
            parse[3]
        }
        Triple(it.id.split("|")[1], it.appTitle, it.title)
    }
    println(s)
}
enum class Menu{
    Setting,
    Home,
    Nav
}