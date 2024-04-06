// Given two arrays a and b of positive integers of size n and m where n >= m, the task is to maximize the dot product by inserting zeros in the second array but you cannot disturb the order of elements.

// Dot product of array a and b of size n is a[0]*b[0] + a[1]*b[1] + ... + a[n-1]*b[n-1].

//User function Template for Java

class Solution {
    public int maxDotProduct(int n, int m, int A[], int B[]) {
        // Your code goes here
        int dp[][] = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (j == 0) {
                    dp[i][j] = 0;
                } else if (i == 0) {
                    dp[i][j] = Integer.MIN_VALUE;
                } else {
                    dp[i][j] = Math.max(A[i - 1] * B[j - 1] + dp[i - 1][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[n][m];
    }
}
