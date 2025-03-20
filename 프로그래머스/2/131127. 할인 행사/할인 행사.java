import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        for (int i=0; i < discount.length - 9; i++) {
            
            //System.out.println(discount[i]);
            
            Map<String,Integer> board = new HashMap<>();
            for (int j=0; j < want.length; j++) {
            board.put(want[j],number[j]);
            }
            
            for (int k=i; k < i + 10; k++) {
                if (board.containsKey(discount[k])) {
                    if (board.get(discount[k]) > 0) {
                        board.put(discount[k], board.getOrDefault(discount[k],0) - 1);
                    }
                }
            }
            int total = 0;
            for (int value : board.values()) {
                total += value;
            }
            
            if (total == 0) {
                answer += 1;
            }
        }
        return answer;
    }
}