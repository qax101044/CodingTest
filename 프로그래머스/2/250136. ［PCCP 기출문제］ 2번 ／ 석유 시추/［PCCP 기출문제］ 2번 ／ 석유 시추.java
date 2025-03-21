import java.util.*;
import java.io.*;

class Solution {
    
    // 북 / 동 / 남 / 서
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    
    static int N,M;
    static int[][] visited;
    static int[] oil;
    
    public int solution(int[][] land) {
        int answer = 0;
        
        N = land.length;
        M = land[0].length;
        
        visited = new int[N][M];
        oil = new int[M];
        
        for (int i=0; i < N; i++) {
            for (int j=0; j < M; j++) {
                if (land[i][j] == 1 && visited[i][j] == 0) {
                    bfs(i,j,land);
                }
            }
        }
        for (int value : oil) {
            answer = Math.max(answer,value);
        }
        
        return answer;
    }
    
    public void bfs(int x, int y, int[][] land) {
        Queue<int[]> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        int cnt = 1;
        
        visited[x][y] = 1;
        q.add(new int[]{x,y});
        
        while (!q.isEmpty()) {
            int[] s = q.poll();
            int sx = s[0];
            int sy = s[1];
            set.add(sy);
            
            for (int d=0; d < 4; d++) {
                int nx = sx + dx[d];
                int ny = sy + dy[d];
                
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (visited[nx][ny] == 0 && land[nx][ny] == 1) {
                        visited[nx][ny] = 1;
                        cnt += 1;
                        q.add(new int[]{nx,ny});                        
                    }
                }
            }    
        }
        
        for (int v : set) {
            oil[v] += cnt;
        }
    }
}