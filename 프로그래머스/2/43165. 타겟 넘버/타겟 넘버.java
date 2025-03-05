// BFS 풀이
import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        
        for (int i=0; i < numbers.length; i++) {
            int size = q.size();
            
            for (int j=0; j < size; j++) {
                int t = q.poll();
                q.add(t + numbers[i]);
                q.add(t - numbers[i]);
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