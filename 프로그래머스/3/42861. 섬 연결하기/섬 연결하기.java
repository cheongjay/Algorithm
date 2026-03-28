import java.util.*;

class Solution {
    
    int answer = 0;
    
    public int solution(int n, int[][] costs) {

        // 거리 짧은 순으로 오름차순
        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));
        int[] parent = new int [n];
        
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        
        for(int i = 0; i < costs.length; i++){
            if(findParent(parent, costs[i][0]) != findParent(parent, costs[i][1])){
                answer += costs[i][2];
                union(parent, costs[i][0], costs[i][1]);
            }
        }
        
        return answer;
    }
    
    public int findParent(int[] parent, int node){
        if(parent[node] == node){
            return node;
        }
        return findParent(parent, parent[node]);
    }
    
    public void union(int[] parent, int node1, int node2){
        int p1 = findParent(parent, node1);
        int p2 = findParent(parent, node2);
        
        if(p1 < p2)
            parent[p2] = p1;
        else
            parent[p1] = p2;
    }
}