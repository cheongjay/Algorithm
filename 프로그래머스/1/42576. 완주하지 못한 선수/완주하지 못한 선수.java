import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map <String, Integer> map = new HashMap<>();
        
        for(String p : participant){
            int i = map.getOrDefault(p, 0);
            map.put(p, i + 1);
        }
        
        for(String c : completion){
            map.put(c, map.get(c) - 1);
        }
        
        for(String k : map.keySet()){
            if(map.get(k) != 0)
                return k;
        }
        return answer;
    }
}