class Solution {
    public int solution(String s) {
        int answer = s.length();
        // i는 단위
        StringBuilder pressed = new StringBuilder(); // 압축된 단어

        for(int i = 1; i <= s.length(); i++){
            pressed = new StringBuilder();
            int curCnt = 1; // 누적 카운트
            String pre = new String();
            
            // 단위 별로 단어 추리기
            for(int j = 0; j < s.length(); j += i){
                String cur = new String();
                
                if(j+i >= s.length())
                    cur = s.substring(j, s.length());
                else
                    cur = s.substring(j, j+i);
                
                // 만약 그 단어가 이전 단어랑 동일하면 누적 카운트 ++
                if(pre.equals(cur))
                    curCnt++;
                // 아니라면 이전 단어 갱신, 압축된 단어에 추가   
                else{             
                    if(curCnt == 1)
                        pressed.append(pre);
                    else
                        pressed.append(pre+Integer.toString(curCnt));
                    pre = cur;
                    curCnt = 1;
                }
            }
            if(curCnt == 1)
                pressed.append(pre);
            else
                pressed.append(pre).append(curCnt);
            
            // 압축된 단어가 가장 짧은 압축 단어 길이보다 짧으면 갱신
            if(pressed.length() < answer){
                answer = pressed.length();
            }
            
        }
        
        return answer;
    }
}