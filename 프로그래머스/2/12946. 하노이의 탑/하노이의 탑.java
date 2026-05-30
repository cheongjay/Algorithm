import java.util.*;

class Solution {
    public int[][] solution(int n) {

        List<int[]> lst = new LinkedList<>();
        
        hanoi(n, 1, 2, 3, lst);
        int[][] answer = new int[lst.size()][2];

        for(int i = 0; i < lst.size(); i++){
            answer[i] = lst.get(i);
        }
        return answer;
    }

    public void hanoi(int n, int from, int mid, int to, List<int[]> lst){

        if(n == 1){
            lst.add(new int[]{from, to});
            return;
        }

        hanoi(n - 1, from, to, mid, lst);
        
        lst.add(new int[]{from, to});
        
        hanoi(n - 1, mid, from, to, lst);
    }
}