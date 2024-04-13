// Given a number x, reverse its binary form and return the answer in decimal.

// User function Template for Java

class Solution {
    static Long reversedBits(Long x) {
        String bin = Long.toBinaryString(x);
        String other = "";
        int n = bin.length() - 1;
        for (int i = 0; i < 32; i++) {
            if (n >= 0) {
                other += bin.charAt(n);
                n--;
            } else {
                other += '0';
            }
        }
        Long ans = Long.parseLong(other, 2);
        return ans;
    }
};