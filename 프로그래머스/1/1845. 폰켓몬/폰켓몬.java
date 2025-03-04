import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] nums) {
        int limit = nums.length / 2;
        
        // 중복 제거
        Set<Integer> numSet = new HashSet<>();
        
        for (int n : nums) {
            numSet.add(n);
        }
        
        if (numSet.size() > limit) {
            return limit;
        }
        
        else {
            return numSet.size();
        }
        
    }
}