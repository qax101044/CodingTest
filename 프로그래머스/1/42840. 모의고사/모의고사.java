import java.util.*;
import java.io.*;

class Solution {
    public List<Integer> solution(int[] answers) {
        int[] student_A = {1,2,3,4,5};
        int[] student_B = {2,1,2,3,2,4,2,5};
        int[] student_C = {3,3,1,1,2,2,4,4,5,5};
        
        List<Integer> answer = new ArrayList<>();
        int cntA = 0;
        int cntB = 0;
        int cntC = 0;
        for (int i=0; i < answers.length; i++) {
            if (answers[i] == student_A[i % student_A.length]) {
                cntA += 1;
            }
            
            if (answers[i] == student_B[i % student_B.length]) {
                cntB += 1;
            }
            
            if (answers[i] == student_C[i % student_C.length]) {
                cntC += 1;
            }
        }
        
        List<Integer> list = new ArrayList<>();
        list.add(cntA);
        list.add(cntB);
        list.add(cntC);
        
        int maxValue = Collections.max(list);
        
        if (cntA == maxValue) {
            answer.add(1);
        }
        
        if (cntB == maxValue) {
            answer.add(2);
        }
        
        if (cntC == maxValue) {
            answer.add(3);
        }
        
        Collections.sort(answer);
        return answer;
    }
}