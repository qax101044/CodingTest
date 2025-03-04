import java.util.*;
import java.io.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String,Integer> board = new HashMap<>();
        
        for (String p : participant) {
            board.put(p, board.getOrDefault(p,0) + 1);
        }
        
        for (String c : completion) {
            board.put(c, board.get(c) - 1);
        }
        
        for (String k : board.keySet()) {
            if (board.get(k) != 0) {
                answer = k;
                break;
            }
        }
        return answer;
    }
}