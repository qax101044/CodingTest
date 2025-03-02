import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        
        Integer[] dInteger = Arrays.stream(d).boxed().toArray(Integer[]::new);
        
        Arrays.sort(dInteger);
        
        for (int i=0; i < dInteger.length; i++) {
            if (budget < dInteger[i]) {
                break;
            }
            budget -= dInteger[i];
            answer += 1;
            
            if (budget == 0) {
                break;
            }
            
            else if (budget < 0) {
                answer -= 1;
                break;
            }
        }
        
        return answer;
    }
}