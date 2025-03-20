import java.util.*;
import java.io.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for (int i=0; i < s.length(); i++) {
            String n = s.substring(i,s.length()) + s.substring(0,i);
            //System.out.println(n);
            
            Stack<Character> stack = new Stack<>();
            
            for (int j=0; j < s.length(); j++) {
                char t = n.charAt(j);
                
                if (stack.size() == 0) {
                    stack.push(t);
                }
                
                else if (stack.peek() == '(' && t == ')') {
                    stack.pop();
                }
                
                else if (stack.peek() == '{' && t == '}') {
                    stack.pop();
                }
                
                else if (stack.peek() == '[' && t == ']') {
                    stack.pop();
                }
                
                else {
                    stack.push(t);
                }
            }
            if (stack.size() == 0) {
                answer += 1;
            }
        }
        return answer;
    }
}