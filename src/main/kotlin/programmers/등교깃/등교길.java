package programmers.등교깃;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 등교길 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] puddles = {{2,2}};
        System.out.println(solution.solution(4, 3, puddles ));
    }
}


class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] arr = new int[n+1][m+1]; // 행이 n 열이 m

        if(puddles.length != 0 ){
            for(int i = 0; i< puddles.length; i++){
                    arr[puddles[i][1]][puddles[i][0]] = -1;
            }
        }

        arr[1][1] =1;
        for( int i = 1; i<arr.length; i++){
            for( int j = 1; j<arr[i].length; j++){
                if(arr[i][j] == -1){
                    continue;
                }
                if(arr[i-1][j] > 0){
                    arr[i][j] += arr[i-1][j] % 1000000007;
                }
                if(arr[i][j-1]>0){
                    arr[i][j] += arr[i][j-1] % 1000000007;
                }
            }
        }
        answer = arr[n][m]% 1000000007;
        return answer;
    }



//    public int bfs( int startX, int startY, int endX, int endY, int[][] arr){
//        Vertex vertex = new Vertex(startX, startY);
//        Queue<Vertex> queue = new LinkedList<>();
//
//        queue.offer(vertex);
//        int count = 0 ;
//        while(!queue.isEmpty()){
//            Vertex currentVertex = queue.poll();
//            Vertex rightVertexFromCurrentVertex = new Vertex(currentVertex.x, currentVertex.y+ 1);
//            Vertex bottomVertexFromCurrentVertex = new Vertex(currentVertex.x+1 ,currentVertex.y);
//
//            if(currentVertex.x == endX && currentVertex.y == endY){
//              count = (count + 1) % 1000000007;
//            }
//
//            if(
//                      rightVertexFromCurrentVertex.y < arr[endX].length && rightVertexFromCurrentVertex.x < arr.length &&
//                    arr[rightVertexFromCurrentVertex.x][rightVertexFromCurrentVertex.y]!=1
//            ){
//                queue.offer(rightVertexFromCurrentVertex);
//            }
//
//            if(
//                    bottomVertexFromCurrentVertex.x < arr.length && bottomVertexFromCurrentVertex.y < arr[endX].length &&
//                    arr[bottomVertexFromCurrentVertex.x][bottomVertexFromCurrentVertex.y] !=1){
//                queue.offer(bottomVertexFromCurrentVertex);
//            }
//
//        }
//        return count;
//
//    }
//
//
//    class Vertex {
//        int x;
//        int y;
//
//        public Vertex(int x, int y) {
//            this.x= x;
//            this.y = y;
//        }
//    }


}
/*
단순 bfs를 돌렸을 경우에 테스트 8에서 걸리게 된다.
효율성은 전부 탈락₩ */