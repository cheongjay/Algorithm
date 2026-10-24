class Solution {
    public int solution(int[][] triangle) {
        int h = triangle.length;
        int[][] dp = new int[h][h];

        dp[0][0] = triangle[0][0];

        // dp[i][j] 까지의 누적합 중 큰 값만 저장
        for (int i = 1; i < h; i++) {
            for (int j = 0; j <= i; j++) {

                // 맨 왼쪽
                if (j == 0) {
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                }
                // 맨 오른쪽
                else if (j == i) {
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                }
                // 가운데는 누적합 중 큰 수 저장
                else {
                    dp[i][j] = Math.max(
                        dp[i-1][j-1],
                        dp[i-1][j]
                    ) + triangle[i][j];
                }
            }
        }

        int answer = 0;

        for (int i = 0; i < h; i++) {
            answer = Math.max(answer, dp[h-1][i]);
        }

        return answer;
    }
}