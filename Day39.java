// Given an array of integers and a sum B, find all unique combinations in the array where the sum is equal to B. The same number may be chosen from the array any number of times to make B.

// Note:
//         1. All numbers will be positive integers.
//         2. Elements in a combination (a1, a2, …, ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
//         3. The combinations themselves must be sorted in ascending order.

//User function template for JAVA

class Solution {

    static void sums(ArrayList<Integer> arr, int sum, int given, ArrayList<Integer> g,
            ArrayList<ArrayList<Integer>> res) {

        if (given == sum) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < g.size(); i++) {
                temp.add(g.get(i));
            }
            res.add(temp);
            return;
        }
        if (given + arr.get(0) > sum) {
            return;
        }
        int j = 0;
        if (g.size() > 0) {
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i) == g.get(g.size() - 1)) {
                    j = i;
                    break;
                }
            }
        }
        for (int i = j; i < arr.size(); i++) {
            if (sum - given < arr.get(i)) {
                break;
            } else {
                g.add(arr.get(i));
                sums(arr, sum, given + arr.get(i), g, res);
                g.remove(Integer.valueOf(arr.get(i)));
            }
        }
    }

    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {

        Collections.sort(A);
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(A.get(0));

        for (int i = 1; i < A.size(); i++) {
            if (A.get(i) == A.get(i - 1)) {
                continue;
            } else {
                arr.add(A.get(i));
            }
        }

        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> a = new ArrayList<Integer>();
        sums(arr, B, 0, a, res);

        return res;

    }
}