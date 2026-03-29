import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int k = Integer.parseInt(br.readLine());
	    Stack<Integer> s = new Stack<>();
	    
	    for(int i = 0; i < k; i++){
	        int input = Integer.parseInt(br.readLine());
	        
	        if(input == 0 && !s.isEmpty()){
	            s.pop();
	        }
	        else{
	            s.push(input);
	        }
	    }
	    int sum = 0;
	    while(!s.isEmpty()){
	        sum += s.pop();
	    }
	    
	    System.out.println(sum);
	}
}