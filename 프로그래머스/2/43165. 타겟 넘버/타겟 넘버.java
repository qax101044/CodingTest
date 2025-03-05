import java.util.*;
import java.io.*;

// BFS 풀이

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        
        // 모든 경우의 수 q에 추가
        for (int i=0; i < numbers.length; i++) {
            int size = q.size();
            
            for (int j=0; j < size; j++) {
                int s = q.poll();
                q.add(s + numbers[i]);
                q.add(s - numbers[i]);
            }
        }
        
        while (!q.isEmpty()) {
            if (q.poll() == target) {
                answer += 1;
            }
        }
        return answer;
    }
}