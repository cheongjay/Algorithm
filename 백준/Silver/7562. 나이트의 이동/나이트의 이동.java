import java.util.*;
import java.io.*;

class Main{
    static int[] dx = {-2, -1, 1, 2, 1, 2, -2, -1};
    static int[] dy = {-1, -2, 2, 1, -2, -1, 1, 2};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int tc = Integer.parseInt(br.readLine());
        Pair cur;
        Pair target;
        String[] input = new String[2];
        int[][] map;
        
        for(int i = 0; i < tc; i++){
            int l = Integer.parseInt(br.readLine());
            map = new int[l][l];
            
            input = br.readLine().split(" ");
            cur = new Pair(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
            
            input = br.readLine().split(" ");
            target = new Pair(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
            
            bfs(cur, target, map);
            
        }
    }
    
    public static void bfs(Pair cur, Pair target, int[][] map){           
        Queue<Pair> q = new LinkedList<>();
        
        q.offer(cur);
        boolean[][] v = new boolean[map.length][map.length];
        v[cur.x][cur.y] = true;
        
        while(!q.isEmpty()){
            cur = q.poll();
            
            for(int i = 0; i < 8; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                // 맵이 아니라면 패스
                if(nx < 0 || ny < 0 || nx >= map.length || ny >= map.length)
                    continue;
                    
                // 이미 방문했다면 패스
                if(v[nx][ny])
                    continue;
                
                // 갈 수 있다면 현재 위치에서 몇 번만에 방문했는지 추가
                v[nx][ny] = true;
                map[nx][ny] = map[cur.x][cur.y] + 1;
                q.offer(new Pair(nx, ny));
            }
        }
        
        System.out.println(map[target.x][target.y]);
        return;
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