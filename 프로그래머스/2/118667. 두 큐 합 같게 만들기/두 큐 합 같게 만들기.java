import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        ArrayDeque<Integer> q1 = new ArrayDeque<>();
        ArrayDeque<Integer> q2 = new ArrayDeque<>();
        
        long q1Sum = 0;
        long q2Sum = 0;
        
        for(int i : queue1) {
            q1Sum += i;
            q1.add(i);
        }
        
        for(int i : queue2) {
            q2Sum += i;
            q2.add(i);
        }
        
        int size = queue1.length;
        
        for(int i = 0; i < size * 3 - 1; i++) {
            if(q1Sum == q2Sum) {
                return answer;
            }
            
            if(q1Sum > q2Sum) {
                int peek = q1.poll();
                q2.add(peek);
                q1Sum -= peek;
                q2Sum += peek;
            }
            else {
                int peek = q2.poll();
                q1.add(peek);
                q2Sum -= peek;
                q1Sum += peek;
            }
            
            answer++;
        }
        
        return -1;
    }
}