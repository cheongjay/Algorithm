class Solution {
    public int solution(int n, int[] cores) {
        int answer = 0;
        long time = 0;
        
        long left = 0;
        long right = 250_000_000; // 최악의 경우 : 10000 작업 시간 코어 2개로 50000개 일 처리할 경우
        
        // 몇 초가 되어야 n 개 이상 처리할 수 있는지를 체크
            // t초일 때 처리된 작업 = 시그마 (t/cores[i])
        while(left <= right){
            long mid = (left + right) / 2;
            // 작업 시작 (0초) 시 모든 코어 처리 시작
            long work = cores.length;
            
            // 1초 ~ mid 초까지 처리한 양
            for(int core : cores){
                work += mid / core; 
            }
            
            // 만약 요구된 양보다 크거나 같으면 시간 기록하고 범위 좁히기
            // left ~   mid  ~ right
            // left ~ mid - 1
            if(work >= n){
                time = mid;    
                right = mid - 1;
            }
            // 요구된 양보다 작으면 그 시간부터 
            else{
                left = mid + 1;
            }
        }
        
        // 0초 시 작업
        long work = cores.length;
        
        // time은 n번째 작업이 시작하는 시간
        // 하지만 이 time에 여러 코어가 동시 작업할 수 있기 때문에
        // time - 1 시간까지 작업량 계산 후,
        for(int core : cores){
            work += (time - 1) / core;
        }
        
        // 남은 작업에서 어떤 코어가 n번째를 가져가는지 확인해야 함.
        for(int i = 0; i < cores.length; i++){
            if(time % cores[i] == 0){
                work++;
                if(work == n){
                    return i + 1;
                }
            }
        }
        return answer;
    }
}