import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        
        String[] arr = Long.toString(n).split("");
        Arrays.sort(arr, Collections.reverseOrder());
        
        String ans = "";
        
        for (String s : arr) {
            ans += s;
        }
        
        answer = Long.parseLong(ans);
        return answer;
    }
}