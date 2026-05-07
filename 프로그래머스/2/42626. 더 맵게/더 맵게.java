import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        // min heap으로 스코빌 지수를 저장하고
        // min 값이 k 이상이 될 때까지
            // 첫번째 값과 두 번째 값 꺼내서 새로운 음식 만들고 집어넣기
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a - b);
        for(int s : scoville){
            pq.offer(s);
        }
        
        int answer = 0;
        
        while(pq.peek() < K){
            int first = pq.poll();
            
            // 더이상 없으면 만들 수 없는 경우임
            if(pq.isEmpty())
               return -1;
               
            int second = pq.poll();
            pq.offer(first + second * 2);
            answer++;
        }
        
        return answer;
    }
}