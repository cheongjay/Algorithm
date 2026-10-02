class Solution {
    int max = 0;
    int[][] d;
    boolean[] v;
    public int solution(int k, int[][] dungeons) {
        d = dungeons;
        v = new boolean[dungeons.length];
        
        explore(k, 0);
        
        return max;
    }
    
    void explore(int k, int cnt) {
        max = Math.max(max, cnt);
        
        for(int i = 0; i < d.length; i++) {
            if(!v[i] && d[i][0] <= k) {
                v[i] = true;
                explore(k - d[i][1], cnt+1);
                v[i] = false;            
            }
        }
    }
}