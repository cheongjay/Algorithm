import java.util.*;
import java.io.*;

public class Main
{
    static List<List<Integer>> graph = new ArrayList<>();
    static int n,m;

    public static void main(String[] args) throws IOException {
        // dx, dy를 같은 인덱스로 좌표에 더해주면 상, 하, 좌, 우로 이동하는 셈이다.
        int[] dx = {-1 , 1, 0, 0}; // 상, 하, 좌, 우
        int[] dy = {0, 0, -1, 1}; // 상, 하, 좌, 우

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 시작 위치에서부터 이동한 거리를 나타낼 배열
        int[][]dist = new int[n][m];

        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++){
            String[] oneLineInput = (br.readLine()).split("");

            List<Integer> oneLine = graph.get(i);
            for(int j = 0; j < m; j++){
                oneLine.add(Integer.parseInt(oneLineInput[j]));
                dist[i][j] = -1; // -1인 경우 방문하지 않았다고 취급 => visited 배열 따로 두지 않아도 됨
            }
        }

        Queue<Pair> q= new LinkedList<>();

        // 시작 위치 세팅
        q.offer(new Pair(0,0));
        dist[0][0] = 0;

        Pair p;
        
        // 초기 dist[][] 확인용 출력문
        // for(int i =0 ;i < n; i++){
        //     for(int j = 0; j < m; j++){
        //         System.out.print(dist[i][j]+ " ");
        //     }
        //     System.out.println();
        // }

        while(!q.isEmpty()){
            p = q.poll();

            for(int i = 0; i < 4; i++){
                int nX = p.getX() + dx[i];
                int nY = p.getY() + dy[i];
                
                // 미로 벗어난 경우 continue
                if(nX < 0 || nX >= n || nY < 0 || nY >= m){
                    // System.out.println("미로 벗어남");
                    continue;
                }

                // 길이 아니거나, 이미 방문한 경우 continue
                if(graph.get(nX).get(nY) == 0 || dist[nX][nY] != -1){
                    continue;
                }
                
                // 위의 경우 아니라면 큐에 넣어주고
                q.offer(new Pair(nX, nY));
                
                // 이전 좌표의 거리 + 1 로 거리 입력해주기 -> dist[][] 가 필요한 이유!
                dist[nX][nY] = dist[p.getX()][p.getY()] + 1;
            }
        }

        // 모든 길 방문 후 dist[][] 확인용 출력문
        // for(int i =0 ;i < n; i++){
        //     for(int j = 0; j < m; j++){
        //         System.out.print(dist[i][j]+ " ");
        //     }
        //     System.out.println();
        // }
        
        System.out.println(dist[n-1][m-1] + 1);
    }
}

class Pair{
    int x;
    int y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
}