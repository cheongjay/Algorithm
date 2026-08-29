class Solution {

    int[][] board;
    int[][] prefixSum;
    int N, M;
    
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        N = board.length;
        M = board[0].length;
        
        this.board = board;
        prefixSum = new int[board.length + 1][board[0].length + 1];
        
        for(int[] s : skill) {
            int type = s[0];
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];
            int degree;
            
            if(isAttacking(type)) {
                degree = -s[5];
            } else {
                degree = s[5];
            }
            
            prefixSum[r1][c1] += degree;
            prefixSum[r1][c2+1] -= degree;
            prefixSum[r2+1][c1] -= degree;
            prefixSum[r2+1][c2+1] += degree;
        }
        
        operate();
        
        answer = countUnDestroyedBuildings(this.board);
        return answer;
    }
    
    private void operate() {
        // 상하
        for (int c = 1; c < N; c++) {
            for (int r = 0; r < M; r++) {
                prefixSum[c][r] += prefixSum[c - 1][r];
            }
        }
        // 좌우
        for (int r = 1; r < M; r++) {
            for (int c = 0; c < N; c++) {
                prefixSum[c][r] += prefixSum[c][r - 1];
            }
        }
    }
    
    
    private boolean isAttacking(int type) {
                
        // type
            // 1 == 공격
            // 2 == 방어
        if(type == 1) {
            return true;
        }        
        return false;
    }
    
    private int countUnDestroyedBuildings(int[][] board) {
        int r = board.length;
        int c = board[0].length;
        int count = 0;
        
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(board[i][j] + prefixSum[i][j] > 0) {
                    count++;
                }
            }
        }
        
        return count;
    }
}