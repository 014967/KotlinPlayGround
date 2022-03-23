package programmers.highscorekit.hash;


import java.util.Arrays;

public class hash2 {
    public static void main(String args[])
    {
//        String[] str = {"119", "97674223", "1195524421"};
        String[] str = {"123","456","789"};
//        String [] str= {"12","123","1235","567","88"};
        boolean result =solution(str);
        System.out.println(result);
    }

    //같은 부분이 있을 때 false를 반환
    //모두 다른 부분일때 true를 반환

    public static boolean solution(String[] phone_book)
    {
        boolean answer = true;
        Arrays.sort(phone_book);
        for(int i= 0 ; i<phone_book.length-1; i++)
        {

                    if(phone_book[i+1].startsWith(phone_book[i]))
                    {
                        answer = false;
                        break;
                    }



        }
        return answer;
    }


}
