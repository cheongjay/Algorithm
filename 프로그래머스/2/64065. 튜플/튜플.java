import java.util.*;

class Solution {
    public int[] solution(String s) {
        List<Integer> answer = new LinkedList<>();
        s = s.substring(2, s.length() - 2);
        // { 와 } 는 regex로 사용되기 때문에 escape 문자 \ 필요
        // 첫 번째 \는 자바 문자열 컴파일용
        // 두 번째 \는 regex 엔진용
        String[] strs = s.split("\\},\\{");
        
        Arrays.sort(strs, (a, b) -> a.length() - b.length());
        
        for(String str : strs){
            // 람다식
            int[] elements = Arrays.stream(str.split(",")).mapToInt(o -> Integer.parseInt(o)).toArray(); // mapToInt(Integer::parseInt) 와 동일(메서드 참조)
            
            find(answer, elements);
        }
        return answer.stream().mapToInt(o -> (int)o).toArray();
    }
    
    // result에 포함 안 된 값 하나 찾기
    public void find(List<Integer> lst, int[] src){
        for(int s : src){
            if(!lst.contains(s)){
                lst.add(s);
                return;
            }
        }
    }
}