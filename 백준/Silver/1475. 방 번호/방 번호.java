import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int roomN = Integer.parseInt(br.readLine());
        // 6, 9는 같은 것으로 취급 2개까지 가능
        // 그 외 숫자는 1개까지 가능
        // roomN 숫자 중에서 MAX를 찾고 만약 6,9 면 / 2 리턴, 아니면 그냥 리턴
        
        int[] neededN = new int[9]; // 9는 6에 저장
        while(roomN > 0){
            int first = roomN % 10;
            if(first == 9){
                neededN[6]++;
            }
            else{
                neededN[first]++;
            }
            roomN /= 10;
        }
        
        neededN[6] = (neededN[6] + 1 ) / 2;
        int max = -1;
        int numMax = 0;
        for(int i = 0; i < neededN.length; i++){
            if(max < neededN[i]){
                max = neededN[i];
                numMax = i;                
            }
        }
        
        System.out.println(max);
    }
}