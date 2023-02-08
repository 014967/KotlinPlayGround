package programmers.정수삼각형;

import java.util.*;

public class 정수삼각형 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] triangle= { {7}, {3,8}, {8,1,0}, {2,7,4,4}, { 4,5,2,6,5}};
        System.out.println(solution.solution(triangle));
    }
}

;
class Solution{
    public int solution(int[][] triangle){
        int answer = 0;
        int[][] maxTriangle = new int[triangle.length][];
        for( int i = 0 ; i < maxTriangle.length; i++){
            maxTriangle[i] = new int[triangle[i].length];
        }
        maxTriangle[0][0] = triangle[0][0];
        for( int i = 1; i< maxTriangle.length; i++){
            for( int j = 0; j <maxTriangle[i].length; j++){
                if( j ==0){
                    maxTriangle[i][j] = triangle[i][j] + maxTriangle[i-1][j];
                }else if(j == maxTriangle[i].length -1){
                    maxTriangle[i][j] = triangle[i][j] + maxTriangle[i-1][maxTriangle[i-1].length -1];
                }else{
                    maxTriangle[i][j]= Math.max(triangle[i][j] + maxTriangle[i-1][j-1], triangle[i][j] + maxTriangle[i-1][j]);
                }
            }
        }
        for( int i =0 ; i < maxTriangle[maxTriangle.length-1].length; i++){
            answer = Math.max(answer,  maxTriangle[maxTriangle.length-1][i]);
        }

        return answer;
    }

}

