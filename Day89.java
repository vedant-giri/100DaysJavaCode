// Juggler Sequence is a series of integers in which the first term starts with a positive integer number a and the remaining terms are generated from the immediate previous term using the below recurrence relation:

//User function Template for Java

class Solution {
    static List<Integer> jugglerSequence(int N) {
        // code here
        List<Integer> ans = new ArrayList<>();
        ans.add(N);
        ans.addAll(sequence(N));

        return ans;

    }

    static List<Integer> sequence(int N) {
        if (N == 1) {
            List<Integer> ans = new ArrayList<>();

            return ans;

        }
        List<Integer> ans = new ArrayList<>();

        if (N % 2 == 0) {
            N = (int) Math.sqrt(N);
            ans.add(N);
        } else {
            N = (int) Math.pow(N, 1.5);
            ans.add(N);
        }

        ans.addAll(sequence(N));

        return ans;
    }
}
