class Solution {
    public String solution(String s) {
        String answer = "";
        
        int cnt = 0;
        for (int i=0; i < s.length(); i++) {
            if (Character.toString(s.charAt(i)).equals(" ")) {
                answer += " ";
                cnt = 0;
                continue;
            }
            if (cnt % 2 == 0) {
                answer += Character.toString(s.charAt(i)).toUpperCase();
            }
            
            else {
                answer += Character.toString(s.charAt(i)).toLowerCase();
            }
            cnt += 1;
        }
        return answer;
    }
}