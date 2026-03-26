import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int N = Integer.parseInt(br.readLine());
	    Stack<Integer> s = new Stack<>();
	    
	    s.push(1);
	    int num = 1; // 1~N까지 오름차순 삽입할 숫자
	    int next = Integer.parseInt(br.readLine());
	    StringBuilder sb = new StringBuilder();
	    sb.append("+");
	    int processed = 0; // 처리한 숫자 카운트
	    
	    while(!s.isEmpty() || num < N){
	        // 1~N까지 다 삽입했는데, peek가 다음 수열 숫자랑 다르면 못 만들기 때문에, No 출력하고 break
	        if(num > N){                         
	            if(s.peek() != next){
	                System.out.println("NO");
	                return;
	            }
	        }
	        // 동일하지 않으면 계속 삽입
	        if(s.isEmpty() || s.peek() != next){
	            s.push(++num);
	            sb.append("+");
	        } 
	        // 만약 뽑는 숫자가 수열 숫자랑 동일하면 팝
	        else{
	            s.pop();
	            sb.append("-");
	            processed++;
	            if(processed < N)
    	            next = Integer.parseInt(br.readLine());
	        }
	    }
	    
	    String[] print = sb.toString().split("");
	    for(String p : print){
	        System.out.println(p);
	    }
	}
}