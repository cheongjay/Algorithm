import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> count = new HashMap<>();
        // 크기 별 개수 구하기
        // 크기 - key / 개수 - value
        for(int t : tangerine){
            int c = count.getOrDefault(t, 0);
            count.put(t, c + 1);
        }
        
        // value를 기준으로 오름차순 정렬
        List<Map.Entry<Integer, Integer>> countList = new LinkedList<>(count.entrySet());
        countList.sort(Map.Entry.comparingByValue());

        // 가장 개수가 많은 크기부터 고르기
        int sum = 0;
        for(int i = count.size()-1 ; i >= 0; i--){
            Map.Entry<Integer, Integer> pair = countList.get(i);
            
            sum += pair.getValue();
            answer++;
            // k 이상이면 중단
            if(sum >= k){ 
                break;
            }
        }
        return answer;
    }
}