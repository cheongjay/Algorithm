import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> participate = new HashMap<>();
        
        for(String p : participant){
            participate.put(p, participate.getOrDefault(p, 0) + 1);
        }
        for(String c : completion){
            participate.put(c, participate.get(c) - 1);    
        }
        
        for(String k : participate.keySet()){
            if(participate.get(k) != 0)
                return k;  
        }
        return "";
    }
}