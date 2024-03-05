// Given an array of integers and a number K. Find the count of distinct elements in every window of size K in the array.
// Your Task:
// Your task is to complete the function countDistinct() which takes the array A[], the size of the array(N) and the window size(K) as inputs and returns an array containing the count of distinct elements in every contiguous window of size K in the array A[].

class Solution {
    ArrayList<Integer> countDistinct(int A[], int n, int k) {
        // code here
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < k; i++) {

            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
            if (map.get(A[i]) == 1) {
                count++;
            }
        }
        list.add(count);

        for (int i = k; i < n; i++) {

            map.put(A[i - k], map.get(A[i - k]) - 1);
            if (map.get(A[i - k]) == 0)
                count--;
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);

            if (map.get(A[i]) == 1) {
                count++;
            }
            list.add(count);
        }
        return list;
    }
}
