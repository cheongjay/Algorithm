import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
        HashSet<String> set;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			String[] A = sc.next().split("");
            set = new HashSet<>();
            
            for(String a : A){      
                set.add(a);
            }
            
            if((!set.contains("W")  && set.contains("E")) || (!set.contains("E")  && set.contains("W"))){
                System.out.println("No");
                continue;
            }
            if((!set.contains("S")  && set.contains("N")) || (!set.contains("N")  && set.contains("S"))){
                System.out.println("No");
                continue;
            }
            else{
             	System.out.println("Yes");   
            }
		}
	}
}