import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(long n) {
        
        String s = String.valueOf(n);
        
        int[] answer = new int[s.length()];
        
        for (int i=0; i < s.length(); i++) {
            answer[s.length() - 1 - i] = Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        
        return answer;
    }
}