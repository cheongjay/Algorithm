import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        
        PriorityQueue<Integer> max = new PriorityQueue<>((a,b) -> b-a);
        PriorityQueue<Integer> min = new PriorityQueue<>((a,b) -> a-b);
        
        for(String o : operations){
            String[] input = o.split(" ");
            
            // I면 q 에 add
            if(input[0].equals("I")){
                max.offer(Integer.parseInt(input[1]));
                min.offer(Integer.parseInt(input[1]));
            }
            
            // D
            if(input[0].equals("D"))
            {
                if(max.isEmpty() && min.isEmpty()){
                    continue;
                }
                   
                // -1 : 최솟값 삭제
                if(input[1].startsWith("-")){
                    int minV = min.poll();
                    max.remove(minV);
                    continue;
                }
                
                //  1 : 최댓값 삭제
                int maxV = max.poll();
                min.remove(maxV);
            }      
        }
        
        // 큐 비어있으면 [0,0] 리턴
        if(max.size() == 0 && min.size() == 0){
            return new int[] {0,0};
        }
        
        // 비어있지 않으면 [최댓값, 최솟값] 리턴
        int[] answer = {max.peek(), min.peek()};
        return answer;
    }
    
}