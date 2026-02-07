import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(storey != 0){
            // 현재 값에서 0으로 이동하는 방법 2가지
            // 1. 현재 값보다 작지만, 가장 큰 10^c 만큼 반대 방향으로 이동
            if(storey < 0){
                storey = -storey;
            }
            int a = (int)Math.log10(storey);
            int nextA = storey - (int) Math.pow(10, a);
         
            // 2. 현재 값보다 크지만, 가장 작은 10^c 만큼 반대 방향으로 이동. 1에 10 곱한 값
            int b = (int)Math.log10(storey) + 1;
            int nextB = storey - (int)Math.pow(10, b);
        
            // 1과 2 중에서 0에 가까운 경우를 선택하여 실행 후 answer++
            if(Math.abs(nextB) < Math.abs(nextA)){
                storey = nextB;
            }
            else{
                storey = nextA;
            }

            answer++;
            // 위 과정을 0이 될 때까지 반복
        }
        return answer;
    }
}