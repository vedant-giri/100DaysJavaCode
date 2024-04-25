// Given two integers n, m and a 2D matrix mat of dimensions nxm, the task is to find the maximum sum of an hourglass.
// An hourglass is defined as a part of the matrix with the following form:

class Solution {
    int findMaxSum(int n, int m, int mat[][]) {
        // code here
        int maxSum = -1;
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                int sum = mat[i][j] + mat[i - 1][j] + mat[i + 1][j] +
                        mat[i - 1][j - 1] + mat[i - 1][j + 1] + mat[i + 1][j - 1] +
                        mat[i + 1][j + 1];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
};
