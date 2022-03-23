package programmers.highscorekit.stackqueue;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class stackqueue4 {
    public static void main(String args[])
    {
        int[] prices = {1,2,3,2,3};
        solution(prices);
    }
    public static int[] solution(int[] prices)
    {
        int[] answer = {};

        List<Integer> result = new ArrayList<>();
        for(int i = 0 ; i< prices.length; i++)
        {

            int count = 0;
            boolean flag = false;
            for(int j =i; j< prices.length; j++)
            {
                if(prices[i] > prices[j])
                {
                    flag= true;
                    result.add(count);
                    break;
                }
                else {
                    count++;
                }
            }
            if(!flag)
                result.add(count-1);

        }
        answer = new int[result.size()];
        for(int i =0 ; i<result.size()-1; i++)
        {
            answer[i] = result.get(i);
        }
        return answer;
    }


}
