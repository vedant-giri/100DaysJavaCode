// Given two sorted arrays of size n and m respectively, find their union. The Union of two arrays can be defined as the common and distinct elements in the two arrays. 

//User function Template for Java

//arr1,arr2 : the arrays
// n, m: size of arrays
class Solution {
    // Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m) {
        // add your code here

        Set<Integer> set = new HashSet<>();
        int found = 1;
        for (int i = 0; i < n; i++) {
            set.add(arr1[i]);

        }
        for (int j = 0; j < m; j++) {
            set.add(arr2[j]);

        }

        // Convert set to ArrayList (to maintain order )
        ArrayList<Integer> al = new ArrayList<>(set);
        Collections.sort(al);

        return al;
    }
}
