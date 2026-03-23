import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 1; i <= n; i++){
            q.add(i);
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        
        while(q.size() > 1){
            for(int i = 0; i < k-1; i++){
                int val = q.poll();
                q.offer(val);
            }
            
            sb.append(q.poll()).append(", ");
        }
        
        // 마지막 원소
        sb.append(q.poll()).append(">");
        
        System.out.print(sb.toString());
    }
}