import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while(!s.equals("1")){
            StringBuilder str = new StringBuilder();
            
            // 0 제거
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '0'){
                    answer[1]++;
                }
                else{
                    str.append(s.charAt(i));
                }
            }
            
            // x의 길이 c 구하기
            int c = str.length();
            
            // c 를 계속 2로 나눠서 2진수 만들기
            String after = Integer.toString(c, 2);
            s = after;
            answer[0]++;
        }
        return answer;
    }
}