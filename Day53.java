// Given an array nums of n positive integers. Find the minimum number of operations required to modify the array such that array elements are in strictly increasing order (nums[i] < nums[i+1]).
// Changing a number to greater or lesser than original number is counted as one operation.

// Note: Array elements can become negative after applying operation.

class Solution {
    public int min_operations(int[] nums) {
        int n = nums.length, maxi = 1;
        int dp[] = new int[n];

        for (int i = 0; i < n; i++)
            dp[i] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && (nums[i] - nums[j] >= (i - j))) {
                    dp[i] = Math.max(1 + dp[j], dp[i]);
                    maxi = Math.max(maxi, dp[i]);
                }
            }
        }

        return n - maxi;
    }
}