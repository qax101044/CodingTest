class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        
        int hp = health;
        int max_hp = health;
        int current_time = 0;
        int conti = 0;
        
        for (int i=0; i < attacks.length; i++) {
            
            // 붕대 감기
            for (int j=current_time + 1; j < attacks[i][0]; j++) {
                
                conti += 1;
                // 연속 감기 성공
                if (conti % bandage[0] == 0 && conti > 0) {
                    hp += bandage[2];
                }
                
                // 매 초 회복량
                hp += bandage[1];
                
                // 최대 체력 제한
                if (hp > max_hp) {
                    hp = max_hp;
                }
                
            }
            
            // 적 공격 받음
            current_time = attacks[i][0];
            conti = 0;
            
            hp -= attacks[i][1];
            System.out.println(hp);
            
            if (hp <= 0) {
                hp = -1;
                break;
            }
            
        }
        answer = hp;
        return answer;
    }
}