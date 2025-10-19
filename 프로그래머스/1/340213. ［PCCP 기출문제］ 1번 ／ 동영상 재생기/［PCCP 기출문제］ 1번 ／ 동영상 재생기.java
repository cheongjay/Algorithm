class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        // prev -10하되, 10미만이면 00:00
        // next +10하되, 만약 오프닝 구간이면 op_end이고, video_len 보다 크면 video_len이다.
        String time = pos;
        for(int i = 0 ; i < commands.length; i++){
            
            // 오프닝 구간인지 체크
            if(isOpening(time, op_start, op_end)){
                time = op_end;
            }
            
            if(commands[i].equals("next")){
                time = calTime(time, 10, video_len);
            }
            else{
                time = calTime(time, -10, video_len);               
            }
            
            // 오프닝 구간인지 체크
            if(isOpening(time, op_start, op_end)){
                time = op_end;
            }       
        }
        
        String[] result = time.split(":");
        
        // 자릿수 맞춰주기 4:17 -> 04:17
        if(result[0].length() == 1){
            result[0] = "0"+ result[0];
        }
        if(result[1].length() == 1){
            result[1] = "0"+ result[1];
        }
        
        return result[0] + ":" + result[1];
    }
    
    // 오프닝 구간인지 체크하는 메소드
    public boolean isOpening(String cur, String op_start, String op_end){
        String[] op_s = op_start.split(":");
        String[] op_e = op_end.split(":");
        String[] curTime = cur.split(":");

        if(Integer.valueOf(curTime[0])* 100 + Integer.valueOf(curTime[1]) >= Integer.valueOf(op_s[0])* 100 + Integer.valueOf(op_s[1]) &&
          Integer.valueOf(curTime[0])* 100 + Integer.valueOf(curTime[1]) <= Integer.valueOf(op_e[0])* 100 + Integer.valueOf(op_e[1])
          ){
            return true;
        }
        else{
            return false;
        }
    }
    
    // 시간 계산 메소드
    public String calTime(String t, int move, String video_len){
        
        int[] currentT = new int[2];
        int idx = 0;
        for(String s : t.split(":")){
            currentT[idx++] = Integer.valueOf(s);
        }
        
        currentT[1] += move;
        
        if(currentT[1] < 0){
            currentT[0]--;
            currentT[1] = 60 + currentT[1];
        }
        
        if(currentT[1] >= 60){
            currentT[0]++;
            currentT[1] = currentT[1] - 60;
            
        }
        String updated = "";
        
        if(currentT[0] < 0 || currentT[1] < 0){
            updated = "00:00";
        }
        else if(currentT[0]*100 + currentT[1] > Integer.valueOf(video_len.split(":")[0]) * 100 +  Integer.valueOf(video_len.split(":")[1])){
            updated = video_len; 
        }
        else{
            updated = currentT[0] + ":" + currentT[1];
        }
        
        return updated;
    }
}