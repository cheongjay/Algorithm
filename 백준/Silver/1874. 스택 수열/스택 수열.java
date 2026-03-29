import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int n = Integer.parseInt(br.readLine());
	    Stack<Integer> s = new Stack<>();
	    int input;
	    int start = 0;
	    StringBuilder sb = new StringBuilder();
	    
	    for(int i = 0; i < n; i++){
	        input = Integer.parseInt(br.readLine());
	        if(start < input){
    	        for(int j = start + 1; j <= input; j++){
    	            s.push(j);
    	            sb.append("+").append("\n");
    	        }
    	        
    	        start = input;
	        }
	        
	        else if(s.peek() != input){
	            System.out.println("NO");
	            return;
	        }
	        
	        s.pop();
	        sb.append("-").append("\n");
	    }
	    
	    System.out.println(sb.toString());
	   
	}
}