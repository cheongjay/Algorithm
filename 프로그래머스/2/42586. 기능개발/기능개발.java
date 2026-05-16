import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        
        int deployedNum = 0; // 몇 번째까지 배포됐는지 체크하는 변수
        
        int cnt = 0;  // 배포 완료된 수
        int len = progresses.length;
        LinkedList<Work> q = new LinkedList<>();
        for(int i = 0; i < len ; i++){
            q.add(new Work(i, progresses[i], speeds[i]));
        }
             
        while(cnt < len){
            if(!q.isEmpty()){
                int end = 0;
                while(!q.isEmpty() && q.peek().progress >= 100){
                    q.poll();
                    cnt++;
                    end++;
                }
                if(end != 0)
                    answer.add(end);
            }
            if(q.isEmpty())
                continue;
            int idx = q.peek().num;
            for(int i = 0; i < q.size(); i++){
                q.get(i).addSpeed();
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}

class Work{
    int num = 0; // 작업 번호
    int progress = 0; // 진도율
    int speed = 0; // 스피드
    public Work(int num, int progress, int speed){
        this.num = num;
        this.progress = progress;
        this.speed = speed;
    }
    
    public void addSpeed(){
        if(this.progress >= 100){
            return;
        }
        this.progress += this.speed;
    }
}