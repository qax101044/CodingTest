import java.util.*;
import java.io.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Map<String,Integer> m = new HashMap<>();
        
        for (String s : phone_book) {
            m.put(s,m.getOrDefault(s,0) + 1);
        }
        
        for (int i=0; i < phone_book.length; i++) {
            for (int j=0; j < phone_book[i].length(); j++) {
                if (m.containsKey(phone_book[i].substring(0,j))) {
                    answer = false;
                }
            }
        }
        return answer;
    }
}