package programmers.highscorekit.dp;

import java.util.Arrays;

/*
집에서 학교까지 가는 길은 m*n 크기의 격자 모양으로 나타낼 수 있다.
가장 왼쪽 위, 즉 집이 있는 곳의 좌표는 (1,1)로 나타내고, 가장 오른쪽 아래
즉 학교가 있는 곳의 좌표는 (m,n)으로 나타낸다.

격자의 크기 m,n과 물이 잠긴 지역의 좌표를 담은 2차원 배열 puddles이
매개변수로 주어진다. 오른쪽과 아래쪽으로만 움직여 집에서 학교까지 갈 수 있는
최단 경로의 개수를 1,000,000,007로 나눈 나머지를 return하도록
solution함수를 작성해주새요

제한사항
격자의 크기 m,n은 1이상 100이하의 자연수이다
m과 n이 모든 1인 경우는 입력으로 주어지지 않는다.
물에 잠긴 지역은 0개이상 10개 이하이다
집과 학교가 물에 잠긴 경우는 입력으로 주어지지 않는다.


 */
public class dp3 {
    public static void main(String args[])
    {
//        int m = 4;
//        int n = 3;
//        int[][] puddles = {{1,0},{0,1}};
        int m = 7;
        int n =4;
        int[][] puddles = {{2,1},{2,2},{2,3},{4,2},{4,3},{4,4},{6,2},{6,3}};
        System.out.println(solution(m,n,puddles));
    }

    public static int solution(int m, int n , int[][] puddles)
    {
        int answer = 0;
        int arr[][] = new int[ n+1] [ m+ 1];


        arr[1][1] =1;
        for(int i =0; i<puddles.length; i++)
        {
            arr[puddles[i][1]][puddles[i][0]] = -1;
        }
        for(int i = 1; i<n+1; i++)
        {

            for (int j =1; j<m+1; j++)
            {

                if(arr[i][j] == -1)
                {
                    continue;
                }
                if(i>1 && arr[i-1][j] != -1)
                {
                    arr[i][j] += arr[i-1][j] % 1000000007;
                }
                if(j>1 && arr[i][j-1] != -1)
                {
                    arr[i][j] += arr[i][j-1] % 1000000007;
                }

            }
        }

        answer = (arr[n][m] % 1000000007);
        return answer;
    }
}
/*


 */