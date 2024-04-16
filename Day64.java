// You are given an array arr of size n. You have to remove a subarray of size k , such that the difference between the maximum and minimum values of the remaining array is minimized.
// Find the minimum value obtained after performing the operation of the removal of the subarray and return it.

class Solution {
    public static int minimizeDifference(int n, int k, int[] arr) {
        int[] maxSuff = new int[n + 1];
        int[] minSuff = new int[n + 1];
        maxSuff[n] = Integer.MIN_VALUE;
        minSuff[n] = Integer.MAX_VALUE;
        maxSuff[n - 1] = arr[n - 1];
        minSuff[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxSuff[i] = Math.max(maxSuff[i + 1], arr[i]);
            minSuff[i] = Math.min(minSuff[i + 1], arr[i]);
        }
        int mindiff = maxSuff[k] - minSuff[k];
        int minPre = arr[0];
        int maxPre = arr[0];
        for (int i = 1; i < n; i++) {
            if (i + k <= n) {
                int maxi = Math.max(maxSuff[i + k], maxPre);
                int mini = Math.min(minSuff[i + k], minPre);
                mindiff = Math.min(mindiff, maxi - mini);
            }
            minPre = Math.min(minPre, arr[i]);
            maxPre = Math.max(maxPre, arr[i]);
        }
        return mindiff;
    }
}
