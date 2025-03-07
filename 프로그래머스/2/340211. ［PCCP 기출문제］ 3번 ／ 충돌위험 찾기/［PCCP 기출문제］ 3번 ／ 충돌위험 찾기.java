import java.util.*;
import java.io.*;

class Solution {
    static Queue<int[]>[] memo;
    static int size;
    static int answer;
    
    public int solution(int[][] points, int[][] routes) {
        size = routes.length;
        memo = new LinkedList[size];
        
        for (int i=0; i < size; i++) {
            memo[i] = new LinkedList<>();
        }
        
        function_1(points, routes);
        function_2();
        
        return answer;
    }
    
    public static void function_2() {
        int count = 0;
        
        while (count != size) {
            int[][] board = new int[101][101];
            count = 0;
            
            for (int i=0; i < size; i++) {
                if (memo[i].isEmpty()) {
                    count += 1;
                    continue;
                }
                
                int[] temp = memo[i].poll();
                board[temp[0]][temp[1]] +=  1;
            }
            
            for (int i=0; i < 101; i++) {
                for (int j=0; j < 101; j++) {
                    if (board[i][j] > 1) {
                        answer += 1;
                    }
                }
            }
        }
    }
    
    public static void function_1(int[][] points, int[][] routes) {
        for (int i=0; i < size; i++) {
            int[] point = points[routes[i][0] - 1];
            int x = point[0];
            int y = point[1];
            memo[i].add(new int[]{x,y});
            
            for (int j=1; j < routes[0].length; j++) {
                int[] next_point = points[routes[i][j] - 1];
                int nx = next_point[0];
                int ny = next_point[1];
                
                int nnx = nx - x;
                int nny = ny - y;
                
                // x 좌표 이동 먼저
                while (nnx != 0) {
                    if (nnx > 0) {
                        nnx -= 1;
                        x += 1;
                        memo[i].add(new int[]{x,y});
                    }
                    else {
                        nnx += 1;
                        x -= 1;
                        memo[i].add(new int[]{x,y});
                    }
                }
                
                while (nny != 0) {
                    if (nny > 0) {
                        nny -= 1;
                        y += 1;
                        memo[i].add(new int[]{x,y});
                    }
                    
                    else {
                        nny += 1;
                        y -= 1;
                        memo[i].add(new int[]{x,y});
                    }
                }
            }
        }
    }
}