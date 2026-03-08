import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        int[] server = new int[24];
        int cur = 0;
        
        for(int i = 0; i < 24; i++){
            if(i >= k){
                cur -= server[i - k];
            }
            
            int n = players[i] / m;
            
            if(n > cur){
                server[i] = n - cur;
                answer += n - cur;
                cur = n;
            }
        }
        return answer;
    }
}