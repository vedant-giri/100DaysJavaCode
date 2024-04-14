// You are given an array arr[] of size n. You need to do the following:

// You need to calculate the bitwise XOR of each element in the array with its corresponding index (indices start from 0).
// After step1, print the array.
// Now, set all the elements of arr[] to zero.
// Now, print arr[].

class Solution {
    public void printArr(int n, int arr[]) {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    public void setToZero(int n, int arr[]) {
        for (int i = 0; i < n; i++)
            arr[i] = 0;
    }

    public void xor1ToN(int n, int arr[]) {
        for (int i = 0; i < n; i++)
            arr[i] ^= i;
    }
}