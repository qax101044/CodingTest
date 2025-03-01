import java.util.*;
import java.io.*;

class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        
        long x = Math.min(a,b);
        long y = Math.max(a,b);
        
        for (long i=x; i <= y; i++) {
            answer += i;
        }
        return answer;
    }
}