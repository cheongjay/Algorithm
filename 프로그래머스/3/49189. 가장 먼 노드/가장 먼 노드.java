import java.util.*;

class Solution {
    int[] dis;

    public int solution(int n, int[][] edge) {
        int answer = 0;
        dis = new int[n+1]; // 2~n번까지 거리 저장할 배열
        dis[1] = 1;
        
        bfs(n, edge);
    
        // 가장 먼 노드 거리와 개수 구하기
        int max = 0;
        for(int i = 2; i <= n; i++){
            // 더 먼 노드 발견하면 갱신
            if(dis[i] > max){
                max = dis[i];
                answer = 1;
            }
            // 같으면 개수 더하기
            else if(dis[i] == max){
                answer++;
            }
        }
        return answer;
    }
    
    public void bfs(int n, int[][] edge){
        boolean[] v = new boolean[n+1];
        v[1] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        
        while(!q.isEmpty()){
            int cur = q.poll();
            List<Integer> neighbor = findNeighbor(cur, edge);
            
            for(int neigh : neighbor){  
                if(!v[neigh]){
                    dis[neigh] = dis[cur] + 1;
                    q.offer(neigh);
                    v[neigh] = true;
                }
            }
        }
    }
    
    public List<Integer> findNeighbor(int n, int[][] edge){
        List<Integer> neighbor = new ArrayList<>();
        for(int[] e : edge){
            if(e[0] == n){
                neighbor.add(e[1]);
            }
            else if(e[1] == n){
                neighbor.add(e[0]);
            }
        }
        
        return neighbor;
    }
}