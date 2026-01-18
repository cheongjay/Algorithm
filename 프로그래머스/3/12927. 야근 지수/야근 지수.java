import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        long sum = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < works.length; i++){
            pq.offer(works[i]);
            sum += works[i];
        }
        
        if(sum <= n){
            return 0;
        }
        
        while(n != 0){
            int m = pq.poll();
            pq.offer(m - 1);
            n--;
        }
        
        while(!pq.isEmpty()){
            int m = pq.poll();
            answer += m * m;
        }
        
        return answer;
    }
}