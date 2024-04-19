// Given two arrays a of size n and b of size m, the task is to find numbers which are present in the first array, but not present in the second array.

//User function Template for Java

class Solution {
    ArrayList<Integer> findMissing(int a[], int b[], int n, int m) {
        ArrayList<Integer> ans = new ArrayList<>();
        Set<Integer> s = new HashSet<>();

        for (int el : b)
            s.add(el);

        for (int el : a) {
            if (!s.contains(el))
                ans.add(el);
        }
        return ans;
    }
}
