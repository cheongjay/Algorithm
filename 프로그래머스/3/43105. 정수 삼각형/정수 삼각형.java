import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int len = triangle.length;
        int[][] m = new int[len][len];
        
        // 초기 값 세팅
        m[0][0] = triangle[0][0];
        
        for(int i = 1; i < len; i++){
            for(int j = 0; j <= i; j++){
                // 첫 번째면 선택지가 없으므로 바로 계산
                if(j == 0){
                    m[i][j] = triangle[i][j] + m[i-1][j];
                }
                // 끝이어도 선택지가 없으므로 바로 계산
                else if(j == len - 1){
                    m[i][j] = triangle[i][j] + m[i-1][j-1];
                }
                // 그 외 가운데 있는 값들은 왼쪽 or 오른쪽 중 max 선택해서 계산
                else{
                    m[i][j] = Math.max(m[i-1][j], m[i-1][j-1]) + triangle[i][j];
                }
            }
        }
        
        // 마지막 라인 max 찾기
        for(int n : m[len-1]){
            if(answer < n)
                answer = n;
        }
        return answer;
    }
}