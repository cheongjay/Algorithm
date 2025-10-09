import java.util.*;

class Solution {
    
    List<List<Integer>> graph = new ArrayList<>();
    
    public int solution(int n, int[][] computers) {

        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i = 1; i <= n; i++){
            
            for(int j = 1; j <= n; j++){
                if(i == j){
                    continue;
                }
                if(computers[i-1][j-1] == 1){
                    graph.get(i).add(j);
                    
                }
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        
        q.offer(1);
        visited[1] = true;
        
        int count = 0; // 네트워크 개수
        int index = 1; // 몇 번째 노드부터 순회시작했는지 체크하는 용도
        boolean allVisited = true; // 모든 노드 방문했는지 체크하는 플래그
        
        while(true){
            while(!q.isEmpty()){
                int node = q.poll();

                List<Integer> neighbors = graph.get(node);

                for(int neighbor : neighbors){
                    if(!visited[neighbor]){
                        visited[neighbor] = true;
                        q.offer(neighbor);       
                    }
                }
            }
            
            // 네트워크 개수 증가
            count++;
            
            // 모든 노드 방문했는지 체크하는 로직
            for(int i = index; i <= n; i++){
                
                // 방문 안 한 노드가 있다면 새로운 네트워크를 발견한 것이므로 큐에 집어넣기
                if(!visited[i]){
                    q.offer(i);
                    visited[i] = true; // 방문 체크도 해주기
                    index = i + 1; // 모든 노드 방문 체크를 어디까지 했는지 표시해두는 index 업데이트
                    allVisited = false; // 모두 방문 여부 플래그 false로 전환
                    break;
                }
            }
            
            // 만약 위의 for문 통과했다면 == 모두 방문했다면 무한 반복문 종료
            if(allVisited){
                break;
            }
            
            // 아니라면 allVisited 다시 true로 만들고, 무한 반복문 재개 -> 새로운 네트워크 BFS로 순회
            allVisited = true;
        }
        
        
        for(boolean b:visited){
            System.out.print(b + " ");
        }
        
        return count;
    }
}