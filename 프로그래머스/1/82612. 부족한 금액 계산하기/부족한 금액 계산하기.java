class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        
        for (long i=0; i < (long)count; i++) {
            answer += (long)price + (long)price * i;
        }
        
        answer = money - answer;
        
        if (answer >= 0) {
            answer = 0;
        }
        
        else {
            answer = Math.abs(answer);
        }
        
        return answer;
    }
}