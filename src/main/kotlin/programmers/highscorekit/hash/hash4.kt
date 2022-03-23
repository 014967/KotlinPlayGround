package programmers.highscorekit.hash

/**
 * @desc
 *
 * @input
 *
 * @output
 *
 * @example
 *
 */

// genres : 노래의 장르를 나타내는 문자열 배열
// plays : 노래별 재생 횟수를 나타내는 정수배열
// 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 리턴 해라.

// genres[i]는 고유 번호가 i인 노래의 자을다

fun main() {
    // val genres = arrayOf("classic", "pop", "classic", "classic", "pop")
    val genres = arrayOf("a", "b", "c", "d", "a", "d", "d", "d", "a", "a", "c", "c")
//    val plays = intArrayOf(500, 600, 150, 800, 2500)
    val plays = intArrayOf(100, 300, 400, 150, 100, 300, 200, 600, 700, 110, 900, 9000)
    println(solution(genres, plays))
}
fun solution(genres: Array<String>, plays: IntArray): IntArray {

    val mapWithIndex = HashMap<String, HashMap<Int, Int>>()
    val mostGenres = HashMap<String, Int>()
    for (i in genres.indices) {

        if (mapWithIndex.containsKey(genres[i])) {
            val indexMap = mapWithIndex[genres[i]]
            indexMap?.put(i, plays[i])
            if (indexMap != null) {
                mapWithIndex.put(genres[i], indexMap)
            }
        } else {
            val indexMap = HashMap<Int, Int>()
            indexMap.put(i, plays[i])
            mapWithIndex.put(genres[i], indexMap)
        }

        if (mostGenres.containsKey(genres[i])) {
            val count = mostGenres[genres[i]]?.plus(plays[i])
            if (count != null) {
                mostGenres[genres[i]] = count
            }
        } else {
            mostGenres[genres[i]] = plays[i]
        }
    }
    val map = mostGenres.toList().sortedWith(compareBy<Pair<String, Int>> { it.second }.reversed()).toMap()

    for (i in mapWithIndex) {
        val s = i.value.toList().sortedWith(
            compareBy<Pair<Int, Int>> { it.second }.reversed()
        ).toMap()
        val hash = LinkedHashMap(s)
        mapWithIndex.put(i.key, hash)
    }
    val arr = mutableListOf<Int>()
    for (i in map) {
        // 가장 많이 플레이 된 장르부터
        if (mapWithIndex.containsKey(i.key)) {
            var count = 0
            for (i in mapWithIndex[i.key]!!) {
                if (count >= 2)
                    continue
                arr.add(i.key)
                count++
            }
        }
    }
    val answer = arr.toIntArray()
    println(answer.toList())
    return answer
}
/*

class Solution {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        return genres.indices.groupBy { genres[it] }
            .toList()
            .sortedByDescending { it.second.sumBy { plays[it] } }
            .map { it.second.sortedByDescending { plays[it] }.take(2) }
            .flatten()
            .toIntArray()
    }
}

 */
