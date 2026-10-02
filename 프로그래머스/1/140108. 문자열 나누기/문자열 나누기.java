class Solution {
    public int solution(String s) {
        int answer = 0;
        int xSame = 1;
        int xDiff = 0;
        char x = s.charAt(0);
        
        for(int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if(x != c) {
                xDiff++;
            }
            else{
                xSame++;                
            }
            
            if(xDiff == xSame) {
                answer++;
                
                // 문자열 끝인 경우 리턴
                if (i + 1 >= s.length()) {
                    return answer;
                }
                
                xDiff = 0;
                xSame = 1;
                x = s.charAt(i + 1);
                i += 1;
            }
        }
        
        // 빠져나왔다는 건, 남은 문자가 있었다는 뜻.
        answer++;

        return answer;
    }
}