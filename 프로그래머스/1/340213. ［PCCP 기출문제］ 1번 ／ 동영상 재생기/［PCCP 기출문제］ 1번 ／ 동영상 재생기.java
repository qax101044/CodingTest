class Solution {
    
    // prev : 10초 전으로 이동. 단, 10초 미만인 경우 0분 0초로 이동
    // next : 10초 후로 이동, 남은 시간 10초 미만인 경우 마지막 위치(동영상의 길이)로 이동로 이동
    // 오프닝 건너뛰기 : op_start <= 현재 재생 위치 <= op_end인 경우 자동으로 오프닝 끝나는 위치로 이동
    // 즉, 명령 수행 결과가 오프닝 사이 구간이면 오프닝 끝나는 위치로 자동 이동되어야 함
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String[] video_len_arr = video_len.split("");
        int video_len_time = Integer.parseInt(video_len_arr[0]) * 600 + Integer.parseInt(video_len_arr[1]) * 60 + Integer.parseInt(video_len_arr[3]) * 10 + Integer.parseInt(video_len_arr[4]);
        
        String[] pos_arr = pos.split("");
        int pos_time = Integer.parseInt(pos_arr[0]) * 600 + Integer.parseInt(pos_arr[1]) * 60 + Integer.parseInt(pos_arr[3]) * 10 + Integer.parseInt(pos_arr[4]);
        
        String[] op_start_arr = op_start.split("");
        int op_start_time = Integer.parseInt(op_start_arr[0]) * 600 + Integer.parseInt(op_start_arr[1]) * 60 + Integer.parseInt(op_start_arr[3]) * 10 + Integer.parseInt(op_start_arr[4]);
        
        String[] op_end_arr = op_end.split("");
        int op_end_time = Integer.parseInt(op_end_arr[0]) * 600 + Integer.parseInt(op_end_arr[1]) * 60 + Integer.parseInt(op_end_arr[3]) * 10 + Integer.parseInt(op_end_arr[4]);
        
        for (int i=0; i < commands.length; i++) {
            
            // op_start <= pos <= op_end
            if (pos_time >= op_start_time && pos_time <= op_end_time) {
                pos_time = op_end_time;
            }
            
            // next 명령
            if (commands[i].equals("next")) {
                pos_time += 10;
            }
            
            // prev 명령
            else if (commands[i].equals("prev")) {
                pos_time -= 10;
            }
            
            // 남은 시간 10초 미만인 경우
            if (pos_time > video_len_time) {
                pos_time = video_len_time;
            }
            
            // pos가 시작 지점 이전일 경우
            if (pos_time < 0) {
                pos_time = 0;
            }
            
            // op_start <= pos <= op_end
            if (pos_time >= op_start_time && pos_time <= op_end_time) {
                pos_time = op_end_time;
            }
            
            
        }
        
        int[] ans = new int[4];
        ans[0] = pos_time / 600;
        pos_time = pos_time % 600;
        
        ans[1] = pos_time / 60;
        pos_time = pos_time % 60;
        
        ans[2] = pos_time / 10;
        pos_time = pos_time % 10;
        
        ans[3] = pos_time;
        
        String answer = Integer.toString(ans[0]) + Integer.toString(ans[1]) + ":" + Integer.toString(ans[2]) + Integer.toString(ans[3]);
        
        
        return answer;
    }
}