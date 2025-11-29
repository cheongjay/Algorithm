class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        // 약수 개수 구하기
        int[] n = new int[number];
        for(int i = 1; i <= number; i++){
            n[i-1] = countMeasure(i);
        }
        // 순회하면서 limit 넘는지 확인
        for(int i = 0; i < number; i++){
            // 넘지 않으면 그대로 더하기
            if(n[i] <= limit){
                answer += n[i];
            }
            // 넘으면 power 더하기
            else{
                answer+=power;
            }
        }
        return answer;
    }
    
    public int countMeasure(int n){
        int count = 0;
        
        for(int i = 1; i*i <= n; i++){
            if(n % i == 0){
                if(i*i == n){
                    count++;                
                }
                else{
                    count+=2;
                }
            }
        } 
        return count;
    }
}