import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < cnt; i++){
            String input = br.readLine();
            System.out.println(encry(input));
        }
    }
    
    public static String encry(String cipher){
            List<Character> lst = new LinkedList<>();
            
            int pointer = 0;
            
            for(int i = 0; i < cipher.length(); i++){
                char c = cipher.charAt(i);
                
                if(c == '<'){
                    if(pointer > 0)
                        pointer--;
                }
                else if(c == '>'){
                    if(pointer < lst.size())
                        pointer++;
                }
                else if(c == '-'){
                    if(pointer > 0){
                        lst.remove(pointer - 1);
                        pointer--;
                    }
                }
                else{
                    lst.add(pointer, c);
                    pointer++;
                }
            }
            StringBuilder sb = new StringBuilder();
            for(char c : lst){
                sb.append(c);
            }
        return sb.toString();
    }
}