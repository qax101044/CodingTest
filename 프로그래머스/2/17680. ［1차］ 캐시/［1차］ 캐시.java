import java.util.*;
import java.io.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        Queue<String> q = new LinkedList<>();
        
        // 대소문자 구분 없이 처리
        for (int i=0; i < cities.length; i++) {
            cities[i] = cities[i].toLowerCase();
        }
        
        //System.out.println(Arrays.toString(cities));
        
        for (String c : cities) {
            
            // cache hit
            if (q.contains(c)) {
                q.remove(c);
                q.add(c);
                answer += 1;
            }
            
            // cache miss
            else {
                answer += 5;
                if (q.size() >= cacheSize) {
                    q.poll();
                    q.add(c);
                    
                    if (cacheSize == 0) {
                        q.poll();
                    }
                }
                
                else {
                    q.add(c);
                }
            }
        }
        
        return answer;
    }
}