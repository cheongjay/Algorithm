import java.util.*;

class Solution {
    public String solution(int n) {
        String[] pattern = {"수", "박"};
        StringBuilder answer = new StringBuilder();
        
        for(int i = 0; i < n; i++){
            answer.append(pattern[i%2]);
        }
        
        return answer.toString();
    }
}