import java.util.*;
class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
//         Integer[] aRef = new Integer[A.length];
//         Integer[] bRef = new Integer[B.length];
        
//         for(int i = 0; i< A.length; i++){
//             aRef[i] = A[i];
//             bRef[i] = B[i];
//         }
//         List<Integer> aList = Arrays.asList(aRef);
//         List<Integer> bList = Arrays.asList(bRef);
        
//         Collections.sort(aList);
//         Collections.sort(bList);
//         Collections.reverse(bList);
//         System.out.println(aList);
//         System.out.println(bList);
        
//         for(int i = 0; i < aList.size(); i++){
//             answer += aList.get(i) * bList.get(i);
//         }
        Arrays.sort(A);
        
        Arrays.sort(B);

        for(int i = 0; i < A.length; i++){
            answer += A[i] * + B[A.length -1 - i];
        }
        return answer;
    }
}