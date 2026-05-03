import java.util.*;

class Solution {
    
    public long solution(int[] weights) {
        long answer = 0;

        HashMap<Integer, Long> map = new HashMap<>();
        Arrays.sort(weights);
        
        for(int w : weights){
            
            // 1:1 = 이전값들:w
            if(map.containsKey(w)){
                answer += map.get(w);
            }
            
            // 2:3 = 이전값들:w
            if(w * 2 % 3 == 0 && map.containsKey(w * 2 / 3)){
                answer += map.get(w * 2 / 3);
            }
            
            // 2:4 = 이전값들:w
            if(w % 2 == 0 && map.containsKey(w/2)){
                answer+= map.get(w/2);
            }
            
            // 3:4 = 이전값들:w
            if(w * 3 % 4 == 0 && map.containsKey(w * 3 / 4)){
                answer+=map.get(w*3/4);
            }
                
            map.put(w, map.getOrDefault(w, 0L) + 1);
        }
        return answer;
    }

}