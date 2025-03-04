class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        
        for (int i=0; i < ingredient.length; i++) {
            sb.append(ingredient[i]);
            
            // sb의 길이가 4 이상이고, 마지막 4개의 재료가 1-2-3-1인 경우
            if (sb.length() > 3 && sb.substring(sb.length()-4, sb.length()).equals("1231")) {
                answer += 1;
                sb.delete(sb.length() - 4, sb.length());
            }
        }
        return answer;
    }
}