import java.util.*;

class Solution {
    static char [] vowels = {'A', 'E', 'O','I','U', 'a', 'e', 'o', 'i', 'u'};
    String reverseVowels(String s) {
        StringBuilder str = new StringBuilder(s);
        
        // 인덱스와 값을 각각 따로 저장 - 어차피 개수 같으므로 굳이 HashMap 써서 묶을 필요 없음!!
        List<Integer> vowelsIndices = new ArrayList<>();
        List<Character> vowelsContained = new ArrayList<>();

        // 모음인지 체크하고 맞으면 각 리스트에 인덱스와 문자 값을 저장해둠.
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(isVowel(ch)){
                vowelsIndices.add(i);
                vowelsContained.add(ch);
            }
        }

        // 인덱스 리스트 리버스
        Collections.reverse(vowelsIndices);
        
        // StringBuilder의 setCharAt를 통해서 뒤집힌 순서대로 문자 세팅함
        for(int i = 0; i < vowelsIndices.size(); i++){
            str.setCharAt(vowelsIndices.get(i),vowelsContained.get(i) );
        }

        // 리턴할 때는 StringBuilder -> String 타입에 맞춰서 반환
        return str.toString();
    }

    // 모음인지 체크하는 메소드
    private boolean isVowel(char ch){
        for(int i =0; i<vowels.length; i++){
            if(vowels[i] == ch){
                return true;
            }
        }
        return false;
    }
};