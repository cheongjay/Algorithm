class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int today = (startday-1) % 7; // 0~6
        
        boolean[] prize = new boolean[schedules.length];
        
        for(int i = 0 ; i<schedules.length; i++){
            prize[i] = true;
        }
        
        // 토 5, 일 6일 때는 상관 x
        for(int i = 0; i < 7; i++ ){
            if(today == 6 || today == 5){          
                today = (today+1) % 7;
                continue;
            }
            
            for(int j = 0; j < schedules.length; j++){
                int t = calTime(schedules[j]);
                if(t < timelogs[j][i]){
                    prize[j] = false;
                }
            }
                
            today = (today+1) % 7;
        }
        
        for(boolean b : prize){
            if(b == true){
                answer++;
            }
        }
        return answer;
    }
    
    public int calTime(int t){
        int si = t / 100;
        int bun = t % 100;
        bun += 10;
        if(bun >= 60){
            si++;
            bun -= 60;
        }
        
        return si * 100 + bun;
    }
}