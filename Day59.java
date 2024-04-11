// Given an integer number n, which is a decimal representation of Gray Code. Find the binary equivalent of the Gray Code & return the decimal representation of the binary equivalent.

class Solution {
    public static int grayToBinary(int n) {
        int binary = 0;
        for (; n != 0; n >>= 1) {
            binary ^= n;
        }
        return binary;
    }
}