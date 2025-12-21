import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        List<Integer> lostList = new ArrayList<>();
        for(int l : lost){
            lostList.add(l);
        }
        List<Integer> reserveList = new LinkedList<>();
        for(int r : reserve){
            reserveList.add(r);
        }
        int answer = 0;
        
        // 그리디 - 각 단계별 최선의 선택/최적의 해를 바로 구하기
        // 각 단계 - 도난당한 학생이 있을 경우
        for(int i = 1; i <= n; i++){
            // 만약 lostList에 포함된 숫자라면
            if(lostList.contains(i)){
                int idx = -1;
             // 만약 도난 + 여벌이면 내 거를 입기
                if(reserveList.contains(i)){
                    idx = reserveList.indexOf(i);
                    answer++;
                    reserveList.remove(idx);
                    continue;
                }
                
             // reserve에서 -1 +1 사이 있는지 체크 후 있다면 빌려주기. +1
                int add = i+1;
                int sub = i-1;
            // 도난당한 학생이라면 빌려주면 안 됨.
                if(reserveList.contains(sub)){
                    idx = reserveList.indexOf(sub);
                    answer++;
                    reserveList.remove(idx);
                }
                else if(reserveList.contains(add) && !lostList.contains(add)){
                    idx = reserveList.indexOf(add);
                    answer++;
                    reserveList.remove(idx);
                }
             // 없으면 패스.
            }    
            // 아니라면 answer++;
            else{
                answer++;
            }
        }
        return answer;
    }
}