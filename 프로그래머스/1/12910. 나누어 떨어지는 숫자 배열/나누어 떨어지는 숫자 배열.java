import java.util.*;
import java.io.*;

class Solution {
    public ArrayList<Integer> solution(int[] arr, int divisor) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        for (int s : arr) {
            if (s % divisor == 0) {
                answer.add(s);
            }
        }
        
        Collections.sort(answer);
        
        if (answer.size() == 0) {
            answer.add(-1);
        }
        
        return answer;
    }
}