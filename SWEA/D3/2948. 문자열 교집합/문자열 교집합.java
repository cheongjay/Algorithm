import java.util.*;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int cnt = 0;
            HashSet<String> hs = new HashSet<>();
            int sizeOfSet1 = sc.nextInt();
            int sizeOfSet2 = sc.nextInt();
            
            for(int i = 0; i < sizeOfSet1; i++){
            	hs.add(sc.next());    
            }
            
            for(int i = 0; i < sizeOfSet2; i++){
            	if(hs.contains(sc.next())){
                	cnt++;
                }
            }
            
            System.out.println("#" + test_case + " " + cnt);
		}
	}
}