// Implement pow(x, n) % M.
// In other words, for a given value of x, n, and M, find  (xn) % M.

class Solution {
    private long helper(long x, long n, long m) {
        if (n == 0) {
            return 1;
        }
        if (n % 2 == 0) {
            return (helper((x * x) % m, n / 2, m)) % m;
        } else {
            return (x * helper((x * x) % m, n / 2, m)) % m;
        }
    }

    public long PowMod(long x, long n, long m) {
        if (x == 0 || x == 1 || n == 1)
            return x % m;
        if (n == 0)
            return 1 % m;
        return helper(x, n, m) % m;
    }
}
