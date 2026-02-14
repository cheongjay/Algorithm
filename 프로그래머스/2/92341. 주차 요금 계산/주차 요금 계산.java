import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        HashMap<Integer, int[]> map = new HashMap<>(); // 차 번호, [입차 시간, 출차 시간]
        Map<Integer, Integer> totalTime = new TreeMap<>(); // 누적 시간
        
        for(String record : records){
            String[] r = record.split(" ");
            int time = Integer.parseInt((r[0].split(":"))[0]);
            int minute = Integer.parseInt((r[0].split(":"))[1]);
            int total = time * 60 + minute;
            
            int car = Integer.parseInt(r[1]);
           
            if(r[2].equals("IN")){
                
                int[] inout = new int[2];
                inout[0] = total;
                
                map.put(car, inout);
            }
            else{
                map.get(car)[1] = total; // 출차 시간 입력
                
                // 이미 한 번 주차한 차라면 누적 합
                if(totalTime.containsKey(car)){
                    totalTime.put(car, totalTime.get(car) + total - map.get(car)[0]);
                }
                // 처음이라면 기록
                else{
                    totalTime.put(car, total - map.get(car)[0]);
                }
            }
        }
        
        
        for(Map.Entry<Integer, int[]> e : map.entrySet()){
            int in = e.getValue()[0];
            int out = e.getValue()[1];
            // 출차 기록 x
            if(out == 0){
                out = 23 * 60 + 59;
                if(totalTime.containsKey(e.getKey())){
                    totalTime.put(e.getKey(), totalTime.get(e.getKey()) + out - in);                
                }
                else{
                    totalTime.put(e.getKey(), out - in);                
                }
            }
        }
        int[] answer = new int[totalTime.size()];
        int idx = 0;
        for(Map.Entry<Integer, Integer> e : totalTime.entrySet()){
            
            int fee = fees[1];
            int totalMinute = e.getValue();
            
            totalMinute -= fees[0];
            
            while(totalMinute > 0){
                totalMinute -= fees[2];
                fee += fees[3];
            }
            
            answer[idx++] = fee;
        }
        
        return answer;
    }
}