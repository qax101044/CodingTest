import java.util.*;
import java.io.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int s = 0;
        Map<Integer, Integer> m = new HashMap<>();
        
        for (int num : tangerine) {
            m.put(num, m.getOrDefault(num,0) + 1);
        }
        
        ArrayList<Integer> valueList = new ArrayList<>(m.values());
        Collections.sort(valueList, Collections.reverseOrder());
        
        for (int v : valueList) {
            if (s + v >= k) {
                answer += 1;
                break;
            }
            
            else {
                s += v;
                answer += 1;
            }
            
        }
        
        
        return answer;
    }
}