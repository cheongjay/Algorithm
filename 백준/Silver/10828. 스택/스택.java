import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int N = Integer.parseInt(br.readLine());
	    Stack<String> stack = new Stack<>();
	    
	    for(int i = 0; i < N; i++){
	        String[] input = br.readLine().split(" ");
	        
	        switch(input[0]){
	            case "push":
	                stack.push(input[1]);
	                break;
                case "pop":
                    if(!stack.isEmpty()){
                        String p = stack.pop();
                        System.out.println(p); 
                    }
                    else{
                        System.out.println(-1);
                    }
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    if(stack.isEmpty()){
                        System.out.println(1);
                    }
                    else{
                        System.out.println(0);
                    }
                    break;
                default:
                    if(!stack.isEmpty()){
                        System.out.println(stack.peek());
                    }
                    else{
                        System.out.println(-1);
                    }
	        }
	    }
		
	}
}