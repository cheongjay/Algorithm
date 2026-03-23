import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        
        List<Integer> lst = new LinkedList<>();
        
        for(int i = 1; i <= n; i++){
            lst.add(i);
        }
        
        int idx = -1;
        System.out.print("<");
        for(int i = 0; i < n; i++){
            idx = move(idx, k, lst);
            lst.remove(idx);
            idx--;
            if(i != n - 1){
                System.out.print(", ");
            }
        }
        System.out.print(">");

    }
    
    public static int move(int idx, int step, List<Integer> lst){
        int next = (idx + step) % lst.size();
        System.out.print(lst.get(next));
        return next;
    }
}