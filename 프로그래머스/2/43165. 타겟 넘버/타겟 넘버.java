class Solution {
    
    static int count = 0;
    
    public int solution(int[] numbers, int target) {
        DFS(numbers, target, 0, 0);
        return count;
    }
    
    public void DFS(int[] num, int target, int sum, int idx){
        if(idx == num.length){
            if(sum == target){
                count++;
            }
            return;
        }
        DFS(num, target, sum + num[idx], idx + 1);
        DFS(num, target, sum - num[idx], idx + 1);
    }
 
}