class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {-1, -1};
        int start = 0;
        int end = 0;
        int sum = 0;
        
        while(end < sequence.length){
    
            // k보다 작다면 end더해주기
            if(sum < k){
                sum += sequence[end++];
            }
            
            // k보다 크고 start가 end보다 작을 때
            while(sum > k){
                sum -= sequence[start++];
            }
            
            if(sum == k){
                if(answer[0] == -1){
                    answer[0] = start;
                    answer[1] = end;
                }
                // 길이 더 작으면 갱신. 같을 때는 어차피 index 더 작은 수열이 answer이므로 x
                if(answer[1] - answer[0] > end - start){
                    answer[0] = start;
                    answer[1] = end;
                }
                
                sum -= sequence[start++];
            }
        }
        answer[1]--;
        return answer;
    }
}