
// Given a matrix of size n x m with 0’s and 1’s, you enter the matrix at cell (0,0) in left to right direction. Whenever you encounter a 0 you retain it in the same direction, else if you encounter a 1 you have to change the direction to the right of the current direction and change that 1 value to 0, you have to find out from which index you will leave the matrix at the end.

class Solution {
    public int[] FindExitPoint(int n, int m, int[][] matrix) {
        int dir = 1;
        int i = 0, j = 0;
        int[] ans = new int[2];
        while (i >= 0 && i < n && j >= 0 && j < m) {
            if (matrix[i][j] == 1) {
                matrix[i][j] = 0;
                dir = (dir % 4) + 1;
            }
            if (dir == 1) {
                j++;
            } else if (dir == 2) {
                i++;
            } else if (dir == 3) {
                j--;
            } else {
                i--;
            }
        }
        // fixing the final answer
        if (dir == 1) {
            j--;
        } else if (dir == 2) {
            i--;
        } else if (dir == 3) {
            j++;
        } else {
            i++;
        }

        ans[0] = i;
        ans[1] = j;
        return ans;
    }
}
