import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        int idx = 0;
        
        for(int i = 0; i < commands.length; i++){
            List<Integer> slice = new ArrayList<>();
            
            for(int j = commands[i][0]; j <= commands[i][1]; j++){
                slice.add(array[j-1]);
            }
            int k = commands[i][2];
            
            Object[] sliceArray = slice.toArray();
            Arrays.sort(sliceArray);
            
            answer[idx++] = (int)sliceArray[k-1];
        }
        
        return answer;
    }
}