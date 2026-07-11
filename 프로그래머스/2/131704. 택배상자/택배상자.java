import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        Stack<Integer> s = new Stack<>();
        
        int num = 1; // 상자 번호
        
        s.push(num);
        
        int i = 0; // order index
        
        while(!s.isEmpty()){
            if(s.peek() != order[i]){
                if(s.peek() > order[i]){
                    break;
                }
                s.push(++num);
            } else{
                s.pop();
                i++;
                answer++;
                if(s.isEmpty() && num != order.length){
                    s.push(++num);
                }
            }
        }
        return answer;
    }
}