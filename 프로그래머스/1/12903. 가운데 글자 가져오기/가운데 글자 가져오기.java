import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        int type = 0;
        
        if (s.length() % 2 == 0) {
            answer += Character.toString(s.charAt(s.length() / 2 - 1));
            answer += Character.toString(s.charAt(s.length() / 2 ));
        }
        
        else {
            answer += Character.toString(s.charAt(s.length() / 2));
        }
        return answer;
    }
}