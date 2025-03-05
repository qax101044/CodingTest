import java.util.*;
import java.io.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        
        List<Integer> listA = Arrays.asList(Arrays.stream(A).boxed().toArray(Integer[]::new));
        List<Integer> listB = Arrays.asList(Arrays.stream(B).boxed().toArray(Integer[]::new));
        
        Collections.sort(listA);
        Collections.sort(listB);
        
        for (int i=0; i < listA.size(); i++) {
            answer += listA.get(i) * listB.get(listB.size() - 1 - i);
        }

        return answer;
    }
}