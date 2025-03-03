class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for (int i=1; i <= number; i++) {
            
            // 약수 개수 확인
            int cnt = 0;
            int chk = 1;
            for (int j=1; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    if (j*j == i) {
                        cnt += 1;
                    }
                    
                    else {
                        cnt += 2;
                    }
                }
                
                if (cnt > limit) {
                    chk = 0;
                    break;
                }
            }
            
            if (chk == 0) {
                answer += power;
            }
            
            else {
                answer += cnt;
            }
        }
        return answer;
    }
}