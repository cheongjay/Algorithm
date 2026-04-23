import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (s1, s2) ->{
                return s1 - s2;            
        });
        
        for(int s : scoville){
            pq.add(s);
        }
        
        while(pq.peek() < K){
            
            if(pq.size() < 2){
                return -1;
            }
            
            int lowest = pq.poll();
            int lowest2nd = pq.poll();
            pq.add(lowest + lowest2nd * 2);
            answer++;
        }
        
        return answer;
    }
}