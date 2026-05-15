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
			Stack<Character>s = new Stack<>();
            String str = sc.next();
            int mid = str.length() / 2;
			for(int i = 0; i < mid; i++){
             	char c = str.charAt(i);
                s.push(c);
            }
			boolean isPalin = true;
            // 짝수 4 - 0,1과 2,3 비교 mid
            // 홀수 5 - 0,1과 3,4 비교 mid + 1
            int startIdx = (str.length() % 2 == 1) ? mid + 1 : mid;
            for(int i = startIdx; i < str.length(); i++){
                char sd = s.pop();
                if(sd  != str.charAt(i)){
                    isPalin = false;
                    break;
                }
            }
            
            System.out.println("#" + test_case +" " + (isPalin? 1 : 0));         
		}
	}
}