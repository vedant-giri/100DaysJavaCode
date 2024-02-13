// Given an array a of size N which contains elements from 0 to N-1, you need to find all the elements occurring more than once in the given array. Return the answer in ascending order. If no such element is found, return list containing [-1]. 

// Note: The extra space is only for the array to be returned. Try and perform all operations within the provided array. 

class Solution {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        ArrayList<Integer> duplicates = new ArrayList<>();
        for (Integer key : map.keySet()) {
            int frequency = map.get(key);
            if (frequency > 1) {
                duplicates.add(key);
            }
        }

        Collections.sort(duplicates);

        return duplicates.isEmpty() ? new ArrayList<>(Arrays.asList(-1)) : duplicates;

    }
}
