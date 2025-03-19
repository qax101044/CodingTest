import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        char[] carr = s.toCharArray();
        Stack<Character> stack = new Stack<>();   
    
        for (int i=0;i<carr.length;i++) {
            char c = carr[i];
            
            if (stack.isEmpty()) {
                stack.push(c);
            }
            
            else {
                if (stack.peek() == c) {
                    stack.pop();
                    
                } else {
                    stack.push(c);
                }
            }
        }        
        // 스택에 남아있는 값들은 반복되지 않는 값들임 즉, 비어있어다면 모두 짝지어 반복된 것
        return stack.isEmpty() ? 1 : 0;
    }
}