import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        
        PriorityQueue<Integer> max = new PriorityQueue<>((a,b) -> b-a);
        PriorityQueue<Integer> min = new PriorityQueue<>((a,b) -> a-b);
        
        for(String oper : operations){
            String[] o = new String[1];
            boolean[] deleteMax = new boolean[1];
            deleteMax[0] = true;
            int[] num = new int[1];
            
            parsing(oper, o, deleteMax, num);
            
            if(o[0].equals("I")){
                max.offer(num[0]);
                min.offer(num[0]);
            }
            else if(o[0].equals("D") && !max.isEmpty()){
                if(deleteMax[0]){
                    // 최댓값 삭제
                    int m = max.poll();
                    min.remove(m);
                }
                else{
                    // 최솟값 삭제
                    int m = min.poll();
                    max.remove(m);
                }
            }
        }
        int[] answer = new int[2];
        if(!max.isEmpty() && !min.isEmpty()){
            answer[0] = max.peek();
            answer[1] = min.peek();
        }
        return answer;
    }
    
    public void parsing(String str, String[] o, boolean[] deleteMax, int[] num){
        
        String[] parts = str.split(" ");
        o[0] = parts[0];
        if(parts[1].startsWith("-")){
            deleteMax[0] = false;
        }
        num[0] = Integer.parseInt(parts[1]);
        
        return;
    }
}