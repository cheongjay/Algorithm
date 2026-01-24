import java.util.*;

class Solution {
    
    static boolean[] v;
    public int solution(int n, int[][] computers) {
        int count = 0;
        v = new boolean[n];
        // 그래프 만들기
        
        
        // 그래프 노드 for문 순회
        for(int i = 0; i < n; i++){
            // 방문 안 한 노드면 새로운 네트워크라는 의미
            // dfs 순회
            if(!v[i]){
                dfs(i, computers);
                count++;
            }
        }
    
        return count;
    }
    
    public void dfs(int s, int[][] computers){
        int[] neighbors = computers[s];
        int n = neighbors.length;
        
        for(int i = 0; i < n; i++){
            // 자기 자신이 아니고, 이웃이고, 방문 안 한 노드라면 들어가기
            if(i != n && neighbors[i] == 1 && !v[i]){
                v[i] = true;
                dfs(i, computers);
            }
        }
    }
}