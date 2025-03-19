import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String,Integer> m = new HashMap<>();
        
        for (String[] s : clothes) {
            m.put(s[1],m.getOrDefault(s[1],0) + 1);
        }
        
        for (Integer value : m.values()) {
            answer *= value + 1;
        }
        return answer - 1;
    }
}