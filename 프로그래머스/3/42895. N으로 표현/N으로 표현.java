import java.util.*;
class Solution {
    public int solution(int N, int number) {
        // 같으면 바로 1 리턴
        if(N == number)
            return 1;
        
        // 2~8개 사이에서 number 만들 수 있는지 확인
            // 2개 NN, N(사칙연산)N
            // 3개 NNN, 2개(사칙연산)1개
            // 4개 NNNN, 3개(사칙연산)1개, 2개(사칙연산)2개
            // ...
            // N개 NNNN...N, i(사칙연산)j개 -> i+j = N이어야 함
        
        // List는 N을 index개를 가지고 연산했을 때 결과를 각각 저장하기 위함
        // Set은 중복 저장 피하기 위함.
        List<Set<Integer>> dp = new ArrayList<>();
        
        // Set 메모리 할당
        for(int i = 0; i <= 8; i++){
            dp.add(new HashSet<>());
        }
        
        // 1개짜리 세팅 : 2개 연산할 때 사용할 재료
        dp.get(1).add(N);
        
        // 2개부터 연산
        for(int i = 2; i <= 8; i++){      
            // N을 붙여서 숫자 만듦. NN, NNN, NNNN, ...
            StringBuilder sb = new StringBuilder();
            for(int j = 1; j <= i; j++){
                sb.append(N);
            }
            dp.get(i).add(Integer.parseInt(sb.toString()));
            
            // 사칙연산으로 숫자 만듦
                // i, j
                // 2, 1 1
                // 3, 1 2 / 2 1
                // 4, 1 3 / 2 2 / 3 1
                // 5, 1 4 / 2 3 / 4 1
                // 6, 1 5 / 2 4 / 3 3...
            // 즉 j가 1에서부터 i-1까지 갔을 때 모든 조합 생성 가능(숫자 같아도 순서 다를 수 있음)
            for(int j = 1; j < i ; j++){
                int k = i - j;
                // Set j와 Set k의 사칙연산 조합 모두 필요
                for(int num1 : dp.get(j)){
                    for(int num2 : dp.get(k)){
                        dp.get(i).add(num1 + num2);
                        dp.get(i).add(num1 - num2);
                        dp.get(i).add(num1 * num2);
                        if(num2 != 0)
                            dp.get(i).add(num1 / num2);          
                    }
                }
            }  
            
            // 모두 추가 후 해당 Set에 number이 있으면 i 리턴
            if(dp.get(i).contains(number))
                return i;
        }
        
        // 만약 9개 이상 사용했을 때는 만들 수 없으므로 -1 리턴
        return -1;
    }
}