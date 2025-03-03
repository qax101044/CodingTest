import java.util.*;
import java.io.*;

class Solution {
    public List<Integer> solution(int[] numbers) {
        Set<Integer> setA = new HashSet<>();
        
        for (int i=0; i < numbers.length - 1; i++) {
            for (int j=i+1; j < numbers.length; j++) {
                setA.add(numbers[i] + numbers[j]);
            }
        }
        
        List<Integer> answer = new ArrayList<>(setA);
        Collections.sort(answer);
        return answer;
    }
}