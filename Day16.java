// Given an array arr[] of N non-negative integers representing the height of blocks. If width of each block is 1, compute how much water can be trapped between the blocks during the rainy season. 

class Solution {

    // arr: input array
    // n: size of array
    // Function to find the trapped water between the blocks.
    static long trappingWater(int arr[], int n) {
        // Your code here
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        int max1 = 0;
        int max2 = 0;

        long result = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > max1)
                max1 = arr[i];
            arr1[i] = max1;

        }
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] > max2)
                max2 = arr[i];
            arr2[i] = max2;
        }

        for (int i = 0; i < n; i++) {
            result += Math.min(arr1[i], arr2[i]) - arr[i];
        }

        return result;

    }
}
