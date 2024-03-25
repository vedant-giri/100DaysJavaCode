// Given a positive integer n. Your task is to generate a string list of all n-bit binary numbers where, for any prefix of the number, there are more or an equal number of 1's than 0's. The numbers should be sorted in decreasing order of magnitude.

class Solution {
    private static ArrayList<String> ans;

    ArrayList<String> NBitBinary(int N) {
        // code here
        char[] arr = new char[N];
        ans = new ArrayList<>();
        solve(arr, 0, 0);
        return ans;
    }

    private static void solve(char[] arr, int ptr, int oneCt) {
        if (ptr == arr.length) {
            ans.add(new String(arr));
            return;
        }
        // put '1'
        arr[ptr] = '1';
        solve(arr, ptr + 1, oneCt + 1);

        // put '0'
        int noOfZeros = ptr - oneCt;
        if (noOfZeros + 1 <= oneCt) {
            arr[ptr] = '0';
            solve(arr, ptr + 1, oneCt);
        }
    }
}
