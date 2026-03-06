import java.util.*;
class Solution {
    // 중복 제거를 위해 set 사용
    HashSet<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        
        boolean[] visited = new boolean[numbers.length()];
        
        dfs("", numbers, visited);
        for(int n : set){
            if(isPrime(n)){
                answer++;
            }
        }
        return answer;
    }
    
    // dfs로 모든 숫자 방문
    public void dfs(String cur, String numbers, boolean[] visited){
        // 비어있지 않다면 숫자 추가
        if(!cur.equals(""))
            set.add(Integer.parseInt(cur));
        
        for(int i = 0; i < numbers.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(cur+numbers.charAt(i), numbers, visited);
                // 백 트랙킹해주기
                    // 1 -> 2 (true에서 false로 백트랙킹해줘야,) -> 3
                    // 1 -> 3 -> 2 (여기서 다시 선택할 수 있음.)
                visited[i] = false;
            }
        }
    }

    public boolean isPrime(int n){
        if(n < 2)
            return false;
        
        for(int i = 2; i < n; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}