import java.util.*;

class Solution {
    static Queue<Pair> q = new LinkedList<>();
    
    public int solution(int[][] maps) {
        int row = maps.length;
        int col = maps[0].length;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        int[][] dist = new int[row][col];
        
        boolean[][] visited = new boolean[row][col];
        
        q.offer(new Pair(0,0));
        visited[0][0] = true;
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            
            for(int i = 0; i < 4; i++){
                int nX = p.x + dx[i];
                int nY = p.y + dy[i];
                
                // 진영을 벗어났는가 체크
                if(nX < 0 || nX >= row || nY < 0 || nY >= col){
                    continue;
                }
                
                // 갈 수 없는 길이거나 이미 방문한 길인지 체크
                if(maps[nX][nY] == 0 || visited[nX][nY]){
                    continue;
                }
                
                q.offer(new Pair(nX, nY));
                dist[nX][nY] = dist[p.x][p.y] + 1;
                visited[nX][nY] = true;
            }
            
        }
        
        // 방문했다면 도달 가능하므로 +1 한 값 리턴
        if(visited[row-1][col-1]){
            return dist[row-1][col-1] + 1;
        }
        // 방문 못했다면 도달 못했으므로 -1 리턴
        else{
            return -1;
        }
    }
}

class Pair{
    int x;
    int y;
    
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}