import java.util.*;

class Solution {
    public int solution(int n) {
        
        StringBuilder a = new StringBuilder();
        while(n!=0){
            a.append(n%3);
            n = n/3;
        }
        
        String base3 = a.reverse().toString();
        
        int answer = 0;
        for(int i = 0 ; i < base3.length(); i++){            
            answer += Math.pow(3,i) * (base3.charAt(i)-'0');
        }
        
        return answer;
    }
}