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
			// N초과가 되는 최소를 구하려면 x,y 중 작은 값에 x+y 값을 더해야 한다.
            int x =sc.nextInt();
            int y = sc.nextInt();
            int N = sc.nextInt();
            // 둘 중 하나가 N초과면 멈춰야 한다.
            // == 둘 다 N이하면 계속 실행한다.
            int cnt = 0;
            while(x <= N && y <= N){
             	if(x > y){
                    y += x;
                }
                else{
                	x += y;
                }
                cnt++;
            }
            System.out.println(cnt);
		}
	}
}