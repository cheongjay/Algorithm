import java.util.*;
class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0; // 꺼내려는 상자 포함 몇개?
        
        int line = 0;
        int rotate = 0;
        List<List<Integer>> boxes = new ArrayList<>();
        
        int where  = -1; // num이 몇 번째 세로 줄에 있는지 저장하는 용도
        
        for(int i = 0; i < w; i++){
            boxes.add(new ArrayList<>());
        }
        
        for(int i = 1; i <= n; i++){
            if(i == num){
                where = rotate;
            }
            boxes.get(rotate).add(i);
            if(line % 2 == 0){          
                rotate++;
                if(rotate == w){
                    rotate--;
                    line++;
                }
            }
            else if(line % 2 == 1){          
                rotate--;
                if(rotate == -1){
                    rotate++;
                    line++;
                }
            }
            
        }
        

        
        for(int i : boxes.get(where)){
            if(i >= num){
                answer++;
            }
        }
        return answer;
    }
}