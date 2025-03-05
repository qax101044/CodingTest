import java.util.*;

class Solution {
    
    int answer = Integer.MAX_VALUE;
    
    public int solution(String begin, String target, String[] words) {
        // target이 words에 없으면 변환 불가능
        if(!Arrays.asList(words).contains(target)) {
            return 0;
        }
        int[] visited = new int[words.length];
        DFS(0, begin, target, words, visited);
        
        return (answer == Integer.MAX_VALUE) ? 0 : answer;
    }
    
    public void DFS(int depth, String begin, String target, String[] words, int[] visited) {
        if(begin.equals(target)) {
            answer = Math.min(answer, depth);
            return;
        }
        
        for (int i = 0; i < words.length; i++) {
            if (visited[i] == 0) {
                // 두 단어가 한 글자만 다른지 검사
                int diff = 0;
                for (int j = 0; j < begin.length(); j++) {
                    if(begin.charAt(j) != words[i].charAt(j)) {
                        diff++;
                    }
                }
                // 한 글자만 다르면 다음 경로로 DFS 진행
                if(diff == 1) {
                    visited[i] = 1;
                    DFS(depth + 1, words[i], target, words, visited);
                    visited[i] = 0;
                }
            }
        }
    }
}