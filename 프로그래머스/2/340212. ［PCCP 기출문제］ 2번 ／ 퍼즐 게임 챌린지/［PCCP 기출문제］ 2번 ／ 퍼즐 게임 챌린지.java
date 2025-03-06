import java.util.*;
import java.io.*;

// 난이도, 소요시간, 숙련도 = 양의 정수
// 이진 탐색
class Solution {
    public long solution(int[] diffs, int[] times, long limit) {
        long answer = 0;
        
        long left = 1;
        long right = limit;
        
        while (left < right) {
            long mid = (left + right) / 2;
            
            // 
            if (isImpossible(diffs, times, mid, limit)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
    public boolean isImpossible(int[] diffs, int[] times, long level, long limit) {
        long t = (long)times[0];
        
        for (int i=1; i < times.length; i++) {
            if (diffs[i] > level) {
                t += ((long)diffs[i] - level) * ((long)times[i-1] + (long)times[i]);
            }
            t += (long)times[i];
        }
        
        return limit < t;
    }
}