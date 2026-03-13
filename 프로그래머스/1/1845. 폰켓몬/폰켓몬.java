import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int get = nums.length / 2; // 가질 수 있는 폰켓몬 수

        Map<Integer, Integer> map = new HashMap<>();
        
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        int cnt = 0;
        for(int m : map.keySet()){
            cnt++;
            answer++;
            if(cnt == get){
                return answer;
            }
        }
        
        return answer;
    }
}