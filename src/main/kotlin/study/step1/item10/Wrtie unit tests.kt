package study.step1.item10

/*
사용자 관점에서 애플리케이션이 올바르게 동작하는지 확인하는 것은
애플리케이션 내부가 아닌 외부에서 올바르게 작동하도록 하는 것이 주요 목표이기 때문에
경영진이 인식하는 유일한 테스트인 경우가 너무 많다.

이러한 테스트를 시스템의 구체적인 요소가 올바르게 작동한다는 적절한 확신을 주지 못한다.
개발중에 유용한 빠른 피드백을 제공하지도 않는다.
이를 위해서 개발자에게 유용한 단위테스트가 필요하다.

- 일반적인 UseCase 요소가 사용될 것으로 예상되는 일반적인방식. 소수의 인원에 대해 함수가 작동하는지 테스트
- 일반적인 오류 사례 또는 잠재적 문제 올바르게 작동하지 않을 것으로 예상되거나 과거에 문제가 있었던 사례
- Edge case 및 잘못된 인자.

테스트는 계속 누적되므로 회구를 쉽게 할 수 있다. 또한 수동으로 테스트 하기 어려운 케이스도 확인할 수 있다.
단위 테스트를 먼저 작성한 다음 이를 만족하도록 구현하는 테스트 주도 개발 TDD이라는 방식도 있다.

테스트의 이점
- 잘 테스트된 요소는 더 신뢰할 수 있는 경향 및 심리적 안정감이 있다.
- 요소가 제대로 테스트 되면 리팩터링하는 것을 두려워하지 않는다.
- 결과적으로 테스트가 잘된 프로그램은 점점 더 좋아지는 경향이 있다.
- 수동으로 확인하는 것보다 단위 테스트를 사용하여 올바르게 작동하는지 확인하는 것이 훨씬빠른 경우가 많다.
- 버그를 빨리 발견할 수록 수정하는데 드는 비용도 절감할 수 있다.

단점
- 테스트를 작성하는데 시간이 걸린다.
- 테스트가 가능하도록 코드를 조정해야한다. 개발자가 아키텍처를 사용하도록 강요하기도 한다.
- 좋은 단위 테스트를 작성하는 것은 어렵다. 득보다 실이 많을 수 있고 TDD 과정을 수강하는 것이 유용하다.


테스트가 필요한ㄷ곳
-복잡한 기능
- 시간이 지남에 따라 변경될 가능성이 높은 곳
- 비즈니스 로직
- 공개 API의 일부
- 깨지기 쉬운 부분
- 수정한 프로덕션 버그
 */

fun main() {

}
