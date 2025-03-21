import java.util.*;
import java.io.*;

class Solution {
    public long solution(int n) {
        long answer = 0;
        
        long[] dp = new long[100001];
        dp[0] = 0;
        dp[1] = 1;
        
        for (int i=2; i < dp.length; i++) {
            dp[i] = dp[i-2] % 1234567 + dp[i-1] % 1234567;
        }
        
        answer = dp[n] % 1234567;
        return answer;
    }
}