import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        List<Integer> nums = new ArrayList<>();
        int[] answer = new int[n];
        
        // 번호 1~n까지 저장
        for(int i = 1; i <= n; i++){
            nums.add(i);
        }
        
        // 총 경우의 수
        long total = 1;
        for(int i = n; i > 1; i--){
            total *= i;
        }
        
        // k는 1-based, List는 0-based이므로 맞추기
            // 만약 12번째 숫자라면 2번째 그룹인데, 12 / 6 = 2 로 인덱스를 설정하면 3번째 그룹에 포함되므로.
            // -1 해줘서 경계에 있는 숫자가 그룹에 잘 포함되도록 수정.
        k--;
        
        // k번째 방법 인덱스
        int idx = 0;
        
        while(idx < n){
            // 요소 개수 = 자릿수 반영한 총 경우의 수 / 자릿수
                // 총 경우의 수 total은 4x3x2x1 -> 3x2x1 .. 이렇게 줄어듦.
            total = total / (n - idx); 

            // 이 때 요소 개수는 각 자리수별로 똑같으므로, 나눗셈과 나머지 연산으로 다음 숫자를 예측할 수 있음.
            // k / 요소 개수 = 몇 번째 숫자
                // e.g. 14 / 6 = 2 이면 1,2 까지는 6개씩 이미 소비한 상황이므로 다음 숫자 3.
                // 인덱스로 나타내므로 몫 그대로 사용하기
            answer[idx] = nums.remove((int)(k / total));    
            idx++;
            
            k %= total;
            
        }
        
        return answer;
    }
}