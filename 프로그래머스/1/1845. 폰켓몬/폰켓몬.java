import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        // 종류 개수가 중요하므로, HashMap이나 HashSet 사용하기
        Set<Integer> s = new HashSet<>();
        
        // 종류 개수 > 가질 수 있는 폰켓몬 수
            // 폰켓몬 수 리턴
        // 종류 개수 <= 가질 수 있는 폰켓몬 수
            // 종류 수 리턴
        for(int n : nums){
            s.add(n);
        }
        
        if(s.size() > nums.length / 2){
            return nums.length / 2;
        }
        else{
            return s.size();
        }
    }
}