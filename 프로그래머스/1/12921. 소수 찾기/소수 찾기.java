class Solution {
    public int solution(int n) {
        int answer = 1;
        
        for (int i=3; i <= n; i++) {
            if (isPrime(i)) {
                answer += 1;
            }
        }
        return answer;
    }
    
    public boolean isPrime(int num) {
        for (int i=2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}