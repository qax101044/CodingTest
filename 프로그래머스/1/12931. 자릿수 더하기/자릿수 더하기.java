import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        String k = Integer.toString(n);
        
        for (int i=0; i < k.length(); i++) {
            answer += Integer.parseInt(String.valueOf(k.charAt(i)));
        }

        return answer;
    }
}