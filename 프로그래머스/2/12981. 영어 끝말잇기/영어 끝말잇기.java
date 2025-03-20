import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Set<String> board = new HashSet<>();
        
        char init = words[0].charAt(words[0].length() - 1);
        int player = 1;
        int check = 0;
        int count = 1;
        board.add(words[0]);
        
        for (int i=1; i < words.length; i++) {
            char temp = words[i].charAt(0);
            player = (player % n) + 1;
            count = (i / n) + 1;
            
            
            if (init != temp || board.contains(words[i])) {
                check = 1;
                answer[0] = player;
                answer[1] = count;
                break;
            }
            
            else {
                init = words[i].charAt(words[i].length() - 1);
                board.add(words[i]);
            }
        }
        
        if (check == 0) {
            answer = new int[] {0,0};
        }

        return answer;
    }
}