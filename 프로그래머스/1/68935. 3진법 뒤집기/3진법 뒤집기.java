import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] numsBase3 = new int[17];
        
        // 10진법 -> 3진법
        for(int i = 16; i >= 0; i--){
            for(int j = 2; j >= 0 ; j--){
                int m = (int)(Math.pow(3,i))  * j;
                if(m <= n){
                    numsBase3[i] = j;
                    n -= m;
                    break;
                }
            }    
        }
        
        List<Integer> reversed = new ArrayList<>();
        
        int j =0;
        Boolean flag = true; // 필요없는 윗자리 0 제거용 플래그
        
        for(int i = 16; i >= 0; i--){
            if(numsBase3[i] == 0 && flag)
                continue;
            reversed.add(numsBase3[i]);
            flag = false;
        }

        int i = 0;
        for(int r : reversed){
            int add= (int)(Math.pow(3,i)) * r;
            i++;
            answer += add;
        }

        return answer;
    }
}