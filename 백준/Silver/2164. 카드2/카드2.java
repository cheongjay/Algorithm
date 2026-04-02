import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException{
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
	    Queue<Integer> q = new LinkedList<>();
	    
	    for(int i = 1; i <= n; i++){
	        q.offer(i);
	    }
	    
	    while(q.size() > 1){
	        // 버리기
	        q.poll();
	        // 사이즈 체크
	        if(q.size() == 1){
	            break;
	        }
	        // 맨 밑에 넣기
	        int first = q.poll();
	        q.offer(first);
	    }
	    
	    System.out.println(q.peek());
	}
}