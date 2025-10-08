class Solution {
    
    static int count;
    public int solution(int[] numbers, int target) {
 
        DFS(numbers, 0, 0, target);
        
        return count;
    }
    
    public void DFS(int[] numbers, int p, int sum, int target){
        if(p == numbers.length){
            if(sum == target){
                count++;
            }
            return;
        }
        
        DFS(numbers, p + 1, sum + numbers[p], target);
        DFS(numbers, p + 1, sum - numbers[p], target);
    }
}