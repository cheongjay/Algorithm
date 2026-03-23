import java.util.*;

class Solution {
    
    public int solution(String str1, String str2) {
        
        List<String> lst1 = new ArrayList<>();
        List<String> lst2 = new ArrayList<>();
        
        splitStr(str1, lst1);
        splitStr(str2, lst2);

        int intersaction = NumOfIntersaction(lst1, lst2);
        int union = lst1.size() + lst2.size() - intersaction;
        
        if(intersaction == 0 && union == 0)
            return 65536;
        else
            return intersaction * 65536 / union;
    }
    
    // 교집합 개수
    public int NumOfIntersaction(List<String> lst1, List<String> lst2){
        int cnt = 0;
        List<String> temp = new ArrayList<>(lst1);
        
        for(String s : lst2){
            if(temp.contains(s)){
                cnt++;
                temp.remove(s);
            }
        }     
        return cnt;
    }
    
    
    public void splitStr(String str, List<String> lst){
        int len  = str.length();
        for(int i = 0; i < len - 1; i++){
            char ch1 = str.charAt(i);
            char ch2 = str.charAt(i+1);
            // 모두 알파벳인 경우만 저장
            if(Character.isLetter(ch1) && Character.isLetter(ch2)){
                // 소문자로 만들기
                String element = str.substring(i, i+2).toLowerCase();
                lst.add(element);
            }
        }
        
    }
}