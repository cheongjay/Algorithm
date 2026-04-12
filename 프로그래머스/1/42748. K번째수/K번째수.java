import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int times = commands.length;
        int[] answer = new int[times];
        
        for(int t = 0; t < times; t++){
            int i = commands[t][0];
            int j = commands[t][1];
            int k = commands[t][2];
            // 자르기
            Integer[] slice = Arrays.stream(Arrays.copyOfRange(array, i-1, j))
                                .boxed()
                                .toArray(Integer[]::new);
            
            // 정렬
            Arrays.sort(slice, (a, b) -> a - b);
            
            // k번째 숫자
            answer[t] = slice[k-1];
        }
        return answer;
    }
}