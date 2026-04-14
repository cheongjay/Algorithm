import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        List<String> answer = new LinkedList<>();
        
        Arrays.sort(files, (String f1, String f2) -> {          
            // 파싱하기
            String[] result1 = parsing(f1.toLowerCase());
            String[] result2 = parsing(f2.toLowerCase());
            
            int n1 = Integer.parseInt(result1[1]);
            int n2 = Integer.parseInt(result2[1]);
            
            // 정렬하기
            if(!(result1[0].compareTo(result2[0]) == 0)){
                return result1[0].compareTo(result2[0]);
            }
            else if(n1 != n2){
                return n1 - n2;
            }
            else{
                return 0;
            }   
        });
        return files;
    }
    
    public String[] parsing(String s) {
        
        StringBuilder head = new StringBuilder();
        StringBuilder number = new StringBuilder();

        int i = 0;
        // 1. HEAD 추출 (숫자가 나오기 전까지 전부)
        for (; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) break;
            head.append(c);
        }

        // 2. NUMBER 추출 (숫자이면서 최대 5글자까지)
        for (; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isDigit(c) || number.length() >= 5) break;
            number.append(c);
        }

        // TAIL은 정렬에 영향을 주지 않으므로 굳이 추출하지 않아도 됨
        return new String[]{head.toString().toLowerCase(), number.toString()};
    }
}