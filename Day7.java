// Given an array nums[] of size n, construct a Product Array P (of same size n) such that P[i] is equal to the product of all the elements of nums except nums[i].

class Solution {
    public static long[] productExceptSelf(int nums[], int n) {
        // code here
        long[] result = new long[n];

        for (int i = 0; i < n; i++) {
            long prd = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    prd *= nums[j];
                }
            }
            result[i] = prd;
        }

        return result;
    }
}
