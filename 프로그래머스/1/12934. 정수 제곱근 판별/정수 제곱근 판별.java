// Math.sqrt(n) => n의 제곱근을 구함
// Math.pow(n,2) => n의 2제곱

class Solution {
    public long solution(long n) {
        long answer = 0;
        
        double sqrt = Math.sqrt(n);
        
        if (sqrt % 1 == 0) {
            answer = (long) Math.pow(sqrt+1, 2);
        }
        else {
            answer = -1;
        }
        return answer;
    }
}