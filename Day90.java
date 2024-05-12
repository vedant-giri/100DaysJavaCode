// Given an infinite number line. You start at 0 and can go either to the left or to the right. The condition is that in the ith move, you must take i steps. Given a destination d, find the minimum number of steps required to reach that destination.

class Solution {
    static int solve(int d, int i, int j) {
        if (i >= d && (i - d) % 2 == 0)
            return j;

        j++;
        return solve(d, i + j, j);
    }

    static int minSteps(int d) {
        return solve(d, 0, 0);
    }
}
