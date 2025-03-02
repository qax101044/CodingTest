import java.util.*;
import java.io.*;

class Solution {
    public List<Integer> solution(int[] arr) {
        List<Integer> answer = new ArrayList<>();
        
        for (int s : arr) {
            answer.add(s);
        }
        
        int minValue = Integer.MAX_VALUE;
        int index = -1;
        for (int i=0; i < answer.size(); i++) {
            if (minValue > answer.get(i)) {
                minValue = answer.get(i);
                index = i;
            }
        }
        
        answer.remove(index);
        
        if (answer.size() == 0) {
            answer.add(-1);
        }
        return answer;
    }
}