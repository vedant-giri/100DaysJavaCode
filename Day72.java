// You are standing on a point (x, y) and you want to go to origin (0, 0) by taking steps either left or up i.e. from each point you are allowed to move either in (x-1, y) or (x, y-1). Find the number of paths from point to origin.

class Solution {
    public static int ways(int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000007;
            }
        }
        return dp[n][m];
    }
}
