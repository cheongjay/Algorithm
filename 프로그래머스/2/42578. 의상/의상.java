import java.util.*;

class Solution {
    
    Map<String, Integer> map = new HashMap<>();
    int answer = 0;
    public int solution(String[][] clothes) {
        
        // N 종류 별 의상 조합
            // N개 중 i개를 고르고 i개 의상으로 경우의 수 구하기(headgear 3개, eyewear 2개 -> 3 * 2)
            // 1~N까지 위 계산해주고 값 합산한 것이 모든 조합
        for(String[] c : clothes){
            map.put(c[1], map.getOrDefault(c[1], 1) + 1);
        }
        
        int n = map.size();
        String[] types = map.keySet().toArray(new String[n]);
        boolean[] visited = new boolean[n];
        
//         for(int i = 1; i <= n; i++){
//             // i개 고르는 조합
//             comb(types, visited, 0, i);

//         }
        
        int s = 1;
        
        for(int m : map.values()){
            s *= m;
        }
        
        return s - 1;
        // return answer;
    }
    
    // 백 트랙킹 조합
    void comb(String[] arr, boolean[] visited, int start, int i){
        if(i == 0){
            count(arr, visited);
            return;
        }
        else{
            for(int j = start; j < arr.length; j++){
                visited[j] = true;
                comb(arr, visited, j + 1, i - 1);
                visited[j] = false;
            }
        }        
    }
    
    void count(String[] arr, boolean[] visited) {
        int s = 1;
        // true인 의상 경우의 수 구하기(곱의 법칙)
        for(int i = 0; i < arr.length; i++) {
            if(visited[i] == true){
                s *= map.get(arr[i]);
            }      
        }
        answer += s;
    }
    
}