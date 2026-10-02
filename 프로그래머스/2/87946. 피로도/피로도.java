class Solution {
    int max = 0;
    int[][] d;
    boolean[] v;
    public int solution(int k, int[][] dungeons) {
        d = dungeons;
        v = new boolean[dungeons.length];
        
        explore(0, k, 0);
        
        return max;
    }
    
    void explore(int depth, int k, int cnt) {
        if(depth == d.length) {
            if(cnt > max) {
                max = cnt;
            }
            return;
        }
        
        for(int i = 0; i < d.length; i++) {
            if(!v[i]) {
                v[i] = true;

                if(d[i][0] <= k) {
                    explore(depth + 1, k - d[i][1], cnt+1);
                }
                else {
                    explore(depth + 1, k, cnt);
                }
                v[i] = false;            
            }
        }
    }
}