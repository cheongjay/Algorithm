import java.util.*;

class Solution {
    public int solution(int[][] dots) {
        
        // 점 2개 선택하는 경우의 수 4C2 / 2 = 3
        for(int i = 1; i <= 3; i++){
            int[][] first = {dots[0], dots[i]};
            int[][] second = new int[2][2];
            
            if(i == 1){
                second[0] = dots[2];
                second[1] = dots[3];               
            }
            else if(i == 2){
                second[0] = dots[1];
                second[1] = dots[3];
            }
            else{
                second[0] = dots[2];
                second[1] = dots[1];
            }
        
            
            // 평행이 되는 조건
            // 기울기가 같으면 평행
            double slope1 = calSlope(first[0], first[1]);
            double slope2 = calSlope(second[0], second[1]);
            
            if(Double.compare(slope1, slope2) == 0){
                return 1;
            }
            
              
        }
        
        return 0;
        
    }
    
    private double calSlope(int[] dot1, int[]dot2){
        return ((double)(dot1[1] - dot2[1])) / (dot1[0] - dot2[0]);
    }
    
}