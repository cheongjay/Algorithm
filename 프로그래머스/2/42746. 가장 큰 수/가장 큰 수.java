import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        Integer[] nums = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
        
        String[] strNums = new String[numbers.length];
        
        for(int i = 0; i < numbers.length; i++){
            strNums[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(strNums, (a,b) -> (b + a).compareTo(a + b));

        if(strNums[0].equals("0")){
            return "0";
        }
        for(String n : strNums){
            answer.append(n);
        }
        
        return answer.toString();
    }
}