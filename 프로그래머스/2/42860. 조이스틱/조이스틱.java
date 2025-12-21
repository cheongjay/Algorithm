import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        int pre = 'A' - 'A';
        for(int i = 0; i < len; i++){
            char now = name.charAt(i);
            int nowNum = now - 'A';
            int min = Math.min(nowNum, pre);
            int max = Math.max(nowNum, pre);
            if(now == 'A'){
            // +1 커서 이동
                answer++;
            }
            else{
                answer += Math.min(max - min, min + 26 - max);
            }
            
            pre = nowNum;   
        }
        return answer;
    }
}