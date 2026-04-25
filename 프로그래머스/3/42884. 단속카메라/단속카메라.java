import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        // 나간 시점이 큰 순서대로 정렬
        Arrays.sort(routes, (r1, r2) -> r1[1] - r2[1]);
        
        int start = routes[0][0];
        int end = routes[0][1];
        answer++;
        // 항상 끝(end)에 카메라를 설치하되, 어느 차량까지 찍을 수 있는지 체크
        for(int i = 1; i < routes.length; i++){
            if(routes[i][0] <= end && end <= routes[i][1]){
                continue;
            }
            else{
                start = routes[i][0];
                end = routes[i][1];
                answer++;
            }
        }
        return answer;
    }
}