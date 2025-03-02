class Solution {
    public String solution(String[] seoul) {
        int index = -1;
        
        for (int i=0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                index = i;
                break;
            }
        }
        
        String answer = String.format("김서방은 %d에 있다", index);
        
        return answer;
    }
}