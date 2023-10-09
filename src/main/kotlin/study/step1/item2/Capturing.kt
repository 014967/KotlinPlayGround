package study.step1.item2

fun main() {
    val primes: Sequence<Int> = sequence {
        var numbers = generateSequence(2) { it + 1 }
        var prime: Int
        while (true) {
            prime = numbers.first()
            yield(prime)
            numbers = numbers.drop(1).filter { it % prime != 0 }
        }
    }

    print(primes.take(10).toList())
}
/*
시퀸스를 사용하기 떄문에 필터링이 느리게 수행된다.
모든 단계에서 점점 더 많은 필터를 추가한다.
최적화된 필터에서는 항상 가변 속성 소수를 참조하는 필터랄 추가한다.

따라서 항상 소수의 마지막 값을 필터링한다.
삭제만 작동하기 때문에 연속된 숫자가 나오게 된다?


 */