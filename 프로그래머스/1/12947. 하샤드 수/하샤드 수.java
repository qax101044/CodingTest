import java.util.*;
import java.io.*;

class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        String[] arr = Integer.toString(x).split("");
        //System.out.println(Arrays.toString(arr));
        
        int temp = 0;
        for (String s : arr) {
            temp += Integer.parseInt(s);
        }
        
        if (x % temp != 0) {
            answer = false;
        }
        return answer;
    }
}