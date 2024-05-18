class Solution {
    public int findPeakElement(List<Integer> a) {
        Collections.sort(a);
        return a.get(a.size() - 1);
    }
}