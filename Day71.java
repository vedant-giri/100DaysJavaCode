// Rohan has a special love for the matrices especially for the first element of the matrix. Being good at Mathematics, he also loves to solve the different problem on the matrices. So one day he started to multiply the matrix with the original matrix.  The elements of the original matrix a are given by [a00=1 , a01=1, a10=1, a11=0].
// Given the power of the matrix, n calculate the an and return the a10 element mod 1000000007.

// User function Template for Java
class Solution {
    static int firstElement(int n) {
        // code here
        if (n == 1 || n == 2)
            return 1;
        if (n == 3)
            return 2;
        int a1 = 1, a2 = 2, a3 = 0;
        int i = 4;
        while (i <= n) {
            a3 = (a1 + a2) % 1000000007;
            a1 = a2;
            a2 = a3 % 1000000007;
            i++;
        }
        return a3 % (1000000007);

    }
}