
// Given an array Arr[] that contains N integers (may be positive, negative or zero). Find the product of the maximum product subarray.

class Solution {
    // Function to find maximum product subarray
    long maxProduct(int[] arr, int n) {
        // code here
        long left = 1;
        long right = 1;
        long max = Long.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (left == 0)
                left = 1;

            if (right == 0)
                right = 1;
            left = left * arr[i];
            right = right * arr[n - i - 1];

            max = Math.max(max, Math.max(right, left));

        }

        return max;
    }
}