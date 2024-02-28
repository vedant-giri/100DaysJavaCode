// Given an array arr[] of N positive integers which can contain integers from 1 to P where elements can be repeated or can be absent from the array. Your task is to count the frequency of all numbers from 1 to N. Make in-place changes in arr[], such that arr[i] = frequency(i). Assume 1-based indexing.
// Note: The elements greater than N in the array can be ignored for counting and do modify the array in-place. 

class Solution {
    // Function to count the frequency of all elements from 1 to N in the array.
    public static void frequencyCount(int arr[], int N, int P) {
        // code here
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int i = 1; i < N + 1; i++) {
            if (map.containsKey(i)) {
                arr[i - 1] = map.get(i);
            } else {
                arr[i - 1] = 0;
            }
        }

    }
}
