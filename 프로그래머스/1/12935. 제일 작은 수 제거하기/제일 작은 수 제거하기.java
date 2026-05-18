import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        if(arr.length == 1)
            return new int[] {-1};
        int min = Integer.MAX_VALUE;
        for(int a : arr){
            if(min > a)
                min = a;
        }
        List<Integer> lst = Arrays.stream(arr).boxed().collect(Collectors.toList());
        lst.remove(lst.indexOf(min));
        
        return lst.stream().mapToInt(Integer::intValue).toArray();        
    }
}