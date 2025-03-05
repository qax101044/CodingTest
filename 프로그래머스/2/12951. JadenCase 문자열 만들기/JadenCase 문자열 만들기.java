class Solution {
    public String solution(String s) {
        String answer = "";
        int chk = 1;
        for (int i=0; i < s.length(); i++) {
            if (chk > 0 && !Character.toString(s.charAt(i)).equals(" ")) {
                answer += Character.toString(Character.toUpperCase(s.charAt(i)));
                chk = 0;
            }
            
            else if (Character.toString(s.charAt(i)).equals(" ")) {
                chk = 1;
                answer += " ";
            }
            
            else {
                answer += Character.toString(Character.toLowerCase(s.charAt(i)));
            }
        }
        return answer;
    }
}