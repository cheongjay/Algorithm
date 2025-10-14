import java.util.*;
class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        char pre = '\0';
        System.out.println(Character.isWhitespace(pre));
        for(int i=0; i<s.length(); i++){
            char letter = s.charAt(i);
            
            // 알파벳인지 체크
            if(Character.isLetter(letter)){   
                // 단어의 첫 문자면 대문자로 
                // i가 0이거나 앞에 char가 공백이거나              
                if(Character.isWhitespace(pre) || i == 0){
                    answer.append(Character.toUpperCase(letter));                       
                }
                // 아니면 전부 소문자로
                else{
                    answer.append(Character.toLowerCase(letter));
                }
            }
            // 숫자, 공백은 그대로
            else{
                answer.append(letter);
            }
            pre = letter;
        }
        return answer.toString();
    }
}