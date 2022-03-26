package programmers.highscorekit.heap;

import java.util.*;
/*
매운 것을 좋아하는 Leo는 모든 음식의 스코빌 지수를 K 이상으로 만들고 싶습니다.
모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 Leo는 스코빌 지수가 가장 낮은 두개의
음식을 아래와 같티 특별한 방법으로 섞어 새로운 음식을 만듭니다.

섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)

Leo는 몯ㄴ 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞습니다.
Leo가 가진 음식의 스코빌 지수를 담은 배열 scovile과 원하는 스코빌 지수 K가 주어질 때,
모든 음식의 스코빌 지수를 K이상으로 만들기 위해 섞어야하는 최소 횟수를 return 하도록
solution 함수를 작성해주세요

제한사항
- scovile의 길이는 2이상 1,000,000 이하합니다.
- K는 0 이상 1,000,000,000 이하힙니다.
- scovile의 원소는 각각 0이상 1,000,000이하입니다.
- 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1 return 합니다.

 */
public class heap1 {
    public static void main(String args[])
    {
        int[] scovile = {1,2,3,9,10,12};
        int result = solution(scovile, 7);
        System.out.println((result));
    }
    public static int solution(int[] scoville, int K)
    {
        int answer = 0;
        PriorityQueue<Integer> priQueue = new PriorityQueue<>();
        for (int i =0; i< scoville.length; i++)
        {
            priQueue.offer(scoville[i]);
        }

        while(priQueue.size() != 1)
        {
            if(priQueue.peek() >= K)
            {
                break;
            }
            else
            {

                int first = priQueue.poll();
                int second = priQueue.poll();
                int mixScovile = first + (second * 2);
                priQueue.offer(mixScovile);
                answer++;
            }


        }
        if(priQueue.poll() < K)
        {
            answer = -1;
        }
        return answer;
    }

}
