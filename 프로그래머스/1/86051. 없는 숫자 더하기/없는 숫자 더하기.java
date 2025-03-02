import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        List<Integer> numList = new ArrayList<>();
        
        for (int s : numbers) {
            numList.add(s);
        }
        
        for (int i=1; i < 10; i++) {
            if (!numList.contains(i)) {
                answer += i;
            }
        }
        return answer;
    }
}