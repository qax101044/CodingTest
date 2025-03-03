import java.util.*;
import java.io.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        List<Integer> list = Arrays.asList(Arrays.stream(score).boxed().toArray(Integer[]::new));
        
        Collections.sort(list, Comparator.reverseOrder());
        int cnt = 0;
        
        for (int i=0; i < list.size(); i++) {
            cnt += 1;
            
            if (cnt == m) {
                cnt = 0;
                answer += list.get(i) * m;
            }
        }
        
        return answer;
    }
}