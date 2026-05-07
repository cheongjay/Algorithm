import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<Work> pq = new PriorityQueue<>(new Comparator <Work>(){
            @Override
            public int compare(Work a, Work b){
                // 짧은 것 > 요청 시각 빠른 것 > 작업 번호 작은 것
                if(a.remain != b.remain){
                    return a.remain - b.remain;   
                }
                if(a.request != b.request){
                    return a.request - b.request;   
                }
                if(a.num != b.num){
                    return a.num - b.num;   
                }
                return -1;
            }
        });
        
        // [언제 들어오는지, 남은 시간]
        int num = 0; // 작업 번호
        
        int processed = 0;// 처리한 수
        
        // // 먼저 들어온 작업부터 처리할 수 있도록 
        Arrays.sort(jobs, new Comparator<int[]>(){
           @Override
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });
        
        int time = 0;
        
        int idx = 0;
        while(processed < jobs.length){
            for(int i = idx; i < jobs.length; i++){
                if(jobs[i][0] <= time){
                    pq.offer(new Work(num++, jobs[i][0], jobs[i][1]));
                    idx++;
                }
            }
            
            // 현재 작업 처리
            if(!pq.isEmpty()){
                Work next = pq.poll();
                time += next.remain;
                answer += time - next.request; // 현재 시간 - 요청 시간
                processed++;
            }else{
                time++;
            }
            
            for(int i = idx; i < jobs.length; i++){
                if(jobs[i][0] <= time){
                    pq.offer(new Work(num++, jobs[i][0], jobs[i][1]));
                    idx++;
                }
            }
        }
        return answer / jobs.length;
    }
}

class Work{
    public int num; // 작업 번호
    public int request; // 요청 시간
    public int remain; // 남은 시간
    
    public Work(int n, int req, int remain){
        this.num = n;
        this.request = req;
        this.remain = remain;
    }
}