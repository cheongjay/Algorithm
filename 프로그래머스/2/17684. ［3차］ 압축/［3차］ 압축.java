import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new LinkedList<>();
        List<String> dic = new LinkedList<>();
        
        // 길이 1인 모든 단어로 사전 초기화
        char c = 'A';
        
        for(int i = 0; i < 26; i++){
            dic.add(String.valueOf((char)(c + i)));
        }
        
        int maxLen = 1;
        int start = 0;
        int end = 1;
    
        String w = msg.substring(start, end);
        while(start < msg.length()){
            w = msg.substring(start, end);
            
            while(isContain(w, dic)){
                end++;
                if(end > msg.length())
                    break;
                maxLen++;
                w = msg.substring(start, end);
            }
            
            dic.add(w);
            end--;
            w = msg.substring(start, end);
            answer.add(dic.indexOf(w) + 1);
            
            // 갱신
            msg = msg.substring(end, msg.length());
            start = 0;
            end = start + 1;
            maxLen = 1;
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public boolean isContain(String target, List<String> dic){
        if(dic.contains(target)){
            return true;
        }else{
            return false;
        }
    }
}