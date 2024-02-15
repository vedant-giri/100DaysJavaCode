// Given an array of size N-1 such that it only contains distinct integers in the range of 1 to N. Find the missing element.

class Solution {
    int missingNumber(int array[], int n) {
        // Your Code Here
        int totalSum = (n * (n + 1)) / 2;
        int arraySum = 0;
        for (int num : array) {
            arraySum += num;
        }

        return totalSum - arraySum;
    }
}
