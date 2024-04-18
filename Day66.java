// You are given an integer n and an integer array arr of size n+2. All elements of the array are in the range from 1 to n. Also, all elements occur once except two numbers which occur twice. Find the two repeating numbers.
// Note: Return the numbers in their order of appearing twice. So, if X and Y are the repeating numbers, and X's second appearance comes before second appearance of Y, then the order should be (X, Y).

class Solution {
    // Function to find two repeated elements.
    public int[] twoRepeated(int arr[], int n) {
        int[] res = new int[2];
        int[] freq = new int[n + 1];
        for (int a : arr) {
            freq[a]++;
            if (freq[a] == 2) {
                if (res[0] == 0)
                    res[0] = a;
                else
                    res[1] = a;
            }
        }
        return res;
    }

}