// Given an integer n, return the first n elements of Recaman’s sequence.
// It is a function with domain and co-domain as whole numbers. It is recursively defined as below:
// Specifically, let a(n) denote the (n+1)th term. (0 being the 1st term).
// The rule says:
// a(0) = 0
// a(n) = a(n-1) - n, if a(n-1) - n > 0 and is not included in the sequence previously
//        =  a(n-1) + n otherwise.

class Solution {
    static ArrayList<Integer> recamanSequence(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> visited = new HashSet<>();

        int prev = 0;
        list.add(prev);
        visited.add(prev);

        for (int i = 1; i < n; i++) {
            int next = prev - i;
            if (next < 0 || visited.contains(next)) {
                next = prev + i;
            }
            list.add(next);
            visited.add(next);
            prev = next;
        }

        return list;
    }
}
