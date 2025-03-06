import java.util.*;
import java.io.*;

class Solution {
    static int N,M;
    static int[] oil;
    
    // 북 / 동 / 남 / 서
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    
    static int[][] visited;
    
    public int solution(int[][] land) {
        int answer = 0;
        
        N = land.length;
        M = land[0].length;
        oil = new int[M];
        
        visited = new int[N][M];
        
        for (int i=0; i < N; i++) {
            for (int j=0; j < M; j++) {
                if(land[i][j] == 1 && visited[i][j] == 0) {
                    bfs(land, visited, i, j);
                }
            }
        }
        
        answer = Arrays.stream(oil).max().getAsInt();
        
        return answer;
    }
    
    public void bfs(int[][] land, int[][] visited, int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        visited[x][y] = 1;
        
        // 석유 덩어리 개수 세기
        int count = 1;
        Set<Integer> s = new HashSet<>();
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int sx = now[0];
            int sy = now[1];
            s.add(sy);
            
            for (int d=0; d < 4; d++) {
                int nx = sx + dx[d];
                int ny = sy + dy[d];
                
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && visited[nx][ny] == 0 && land[nx][ny] == 1) {
                    visited[nx][ny] = 1;
                    q.add(new int[]{nx,ny});
                    count += 1;
                }
            }
        }
        for (int index : s) {
                oil[index] += count;
        }
    }
}