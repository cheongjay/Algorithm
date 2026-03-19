import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        
        int result = a * b * c;
        
        int[] nums = new int[10]; // 0~9
        
        while(result > 0){
            int one = result % 10;
            nums[one]++;
            result /= 10;
        }
        
        for(int i = 0; i < nums.length; i++){
            System.out.println(nums[i]);
        }
    }
}