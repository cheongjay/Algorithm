import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int len = info.length;
        int[][] dp = new int[len + 1][m];

        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        dp[0][0] = 0;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < m; j++) {

                if (dp[i][j] == Integer.MAX_VALUE) {
                    continue;
                }

                // A가 훔치는 경우
                int nextA = dp[i][j] + info[i][0];

                if (nextA < n) {
                    dp[i + 1][j] = Math.min(
                        dp[i + 1][j], nextA
                    );
                }

                // B가 훔치는 경우
                int nextB = j + info[i][1];

                if (nextB < m) {
                    dp[i + 1][nextB] = Math.min(
                        dp[i + 1][nextB], dp[i][j]
                    );
                }
            }
        }

        int answer = Integer.MAX_VALUE;

        for (int j = 0; j < m; j++) {
            answer = Math.min(answer, dp[len][j]);
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}