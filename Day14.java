// Given an array Arr[] of N integers. Find the contiguous sub-array(containing at least one number) which has the maximum sum and return its sum.

class Solution {

    // arr: input array
    // n: size of array
    // Function to find the sum of contiguous subarray with maximum sum.
    long maxSubarraySum(int arr[], int n) {

        // Your code here

        long maxSum = 0;
        long currSum = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            currSum += arr[i];

            if (currSum > maxSum)
                maxSum = currSum;

            if (currSum < 0) {
                count++;
                currSum = 0;
            }

        }
        if (count == n) {
            Arrays.sort(arr);
            return arr[n - 1];
        }

        return maxSum;

    }

}
