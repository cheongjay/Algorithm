import java.util.*;
import java.io.*;

public class Main
{
    // 그래프
    static List<List<Integer>> graph = new ArrayList<>();
    
    // DFS, BFS 결과 담을 리스트
	static ArrayList<Integer> resultDFS = new ArrayList<>();
	static ArrayList<Integer> resultBFS= new ArrayList<>();
	
    // BFS에 쓸 큐
    static Queue<Integer> q = new LinkedList<>();
    
    static boolean[] visitedDFS;
    static boolean[] visitedBFS;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String[] nmv = br.readLine().split(" ");
		
		int n = Integer.parseInt(nmv[0]);
		int m = Integer.parseInt(nmv[1]);
		int v = Integer.parseInt(nmv[2]);
		
	    visitedDFS = new boolean[n + 1];
		visitedBFS = new boolean[n + 1];
        
	    for(int i = 0; i < n + 1; i++){
	        graph.add(new ArrayList<>());
	    }
        
	    int a,b;
	    
	    for(int i = 0; i < m; i++){
	        st = new StringTokenizer(br.readLine());
	        a = Integer.parseInt(st.nextToken());
	        b = Integer.parseInt(st.nextToken());
	        
	        graph.get(a).add(b);
	        graph.get(b).add(a); 
	    }
	    
        // 작은 번호부터 방문해야하므로 sort
	    for(int i = 1; i < n + 1; i++){
	        Collections.sort(graph.get(i));
	    }
	    
	    
        // BFS 시작 노드 초기 세팅
	    visitedBFS[v] = true;
	    q.offer(v);
	    resultBFS.add(v);
	    
        // BFS
	    while(!q.isEmpty()){
	        
	        int s = q.poll();
     
	        for(int neighbor : graph.get(s)){
	            if(!visitedBFS[neighbor]){
	                visitedBFS[neighbor] = true;
	                q.offer(neighbor);
	                resultBFS.add(neighbor);
	            }
	        }
	    }
	    
        // DFS 준비 + 메소드 호출
		resultDFS.add(v);
		DFS(v);
        
        for(int i : resultDFS){
            System.out.print(i + " ");
        }
        
        System.out.println();
        
        for(int i : resultBFS){
            System.out.print(i + " ");
        }

	}
	
	static private void DFS(int v){
	    
	    visitedDFS[v] = true;
	    
	    for(int neighbor : graph.get(v)){
	        if(!visitedDFS[neighbor]){
	            resultDFS.add(neighbor);
	            DFS(neighbor);
	        }
	    }  
	}
}