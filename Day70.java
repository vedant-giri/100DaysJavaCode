// Given a 2D binary matrix(1-based indexed) a of dimensions nxm , determine the row that contains the minimum number of 1's.
// Note: The matrix contains only 1's and 0's. Also, if two or more rows contain the minimum number of 1's, the answer is the lowest of those indices.

// User function Template for Java

class Solution {
    int minRow(int n, int m, int a[][]) {
        // code here
        int count = 0;
        int t = a[0].length;
        int ans = 0;
        for (int i = 0; i < a.length; i++) {
            count = 0;
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == 1) {
                    count++;
                }
            }
            if (count < t) {
                t = count;
                ans = i;
            }
        }
        return ans + 1;
    }
};