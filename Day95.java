class Solution {
    public int findPair(int n, int x, int[] arr) {
        // code here
        Set<Integer> c = new HashSet<>();
        for (int i : arr) {
            if (c.contains(i + x) || c.contains(i - x)) {
                return 1;
            }
            c.add(i);
        }
        return -1;
    }
}