import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        List<Integer> server = new ArrayList<>();
        int cur = 0;
        // 1시간마다 체크
        for(int i = 0; i < 24; i++){
            
            // 1시간 지날 때마다 증설 서버 배열의 모든 값 -1
            if(!server.isEmpty()){
                server.replaceAll(s -> s-1);
            }
            
            // 반납해야 하는 서버 있는지 체크
            if(!server.isEmpty()){
                while(server.indexOf(0) != -1){
                    int idx = server.indexOf(0);
                    server.remove(idx);
                    cur--;
                }
            }
            
            // 필요한 서버 개수를 구한다. n = 현재 게임 이용자 수 /  m
            int n = players[i] / m;
            
            // 현재 서버 개수가 n보다 작으면 그 차이만큼 증설한다. answer += 차이
            if(cur < n){
                int add = n - cur;
                cur = n;
                answer += add;
                // 증설 시 증설된 서버 배열에 k 만큼 추가
                while(add-- > 0){
                    server.add(k);
                }
            }                     
        }
        return answer;
    }
}