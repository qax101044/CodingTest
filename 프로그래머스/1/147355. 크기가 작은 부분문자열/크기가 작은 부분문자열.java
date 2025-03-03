class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        int k = p.length();
        
        for (int i=0; i < t.length() - k + 1; i++) {
            if (Long.parseLong(t.substring(i,i+k)) <= Long.parseLong(p)) {
                answer += 1;
            }
        }
        return answer;
    }
}