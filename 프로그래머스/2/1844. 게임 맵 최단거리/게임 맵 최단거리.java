import java.util.*;

class Solution {
    int[][] d;
    int n;
    int m;
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        d = new int[n][m];

        bfs(new Pair(0,0), maps);
        
        if(d[n-1][m-1] == 0) {
            return -1;
        }
        
        return d[n-1][m-1];
    }
    
    void bfs(Pair p, int[][] maps) {
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        Queue<Pair> q = new LinkedList<>();
        boolean[][] v = new boolean[n][m];
        
        // 처음 위치 값 세팅
        v[0][0] = true;
        q.add(p);
        d[0][0] = 1;
        
        while(!q.isEmpty()){
            Pair c = q.poll();
            
            // 동서 방향으로 이동 시도
            for(int i = 0; i < 4; i++) {
                int nx = c.x + dx[i];
                int ny = c.y + dy[i];
                // 벗어난 길이면 패스
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                // 벽이거나 방문한 곳이면 패스
                if(maps[nx][ny] == 0 || v[nx][ny]) {
                    continue;
                }
                
                v[nx][ny] = true; // 방문 처리
                q.add(new Pair(nx, ny)); // 큐 삽입           
                d[nx][ny] = d[c.x][c.y] + 1; // 거리 기록
            }     
        }
    }
}

class Pair {
    int x;
    int y;
    
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}