import java.util.*;
import java.io.*;

class Solution {
    int visited[];
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new int[n];
        
        for (int i=0; i < n; i++) {
            if (visited[i] == 0) {
                answer += 1;
                DFS(i, computers, n);
            }
        }
        return answer;
    }
    
    public void DFS(int i, int[][] computers, int n) {
        visited[i] = 1;
        
        for (int j=0; j < n; j++) {
            if (visited[j] == 0 && computers[i][j] == 1){
                DFS(j, computers, n);
            }
        }
    }
}