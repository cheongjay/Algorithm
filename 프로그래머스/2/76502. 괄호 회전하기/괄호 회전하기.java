import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        String[] str = s.split("");
        
        ArrayDeque<String> q = new ArrayDeque<>();
        
        for(String st : str) {
            q.add(st);
        }
            
        for(int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            
            for(String st: q) {
                sb.append(st);    
            }
            
            if(isCorrect(sb.toString())) {
                answer++;
            }
            
            q.add(q.poll());
        }
        return answer;
    }
       
    boolean isCorrect(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            // 여는 괄호 - 넣기
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            // 닫는 괄호 - 짝 확인
            else {
                if (stack.isEmpty()) {
                    return false;
                }

                char open = stack.pop();

                if (c == ')' && open != '(') {
                    return false;
                }

                if (c == ']' && open != '[') {
                    return false;
                }

                if (c == '}' && open != '{') {
                    return false;
                }
            }
        }

        // 모든 괄호가 짝을 찾아야 함
        return stack.isEmpty();
    }
}