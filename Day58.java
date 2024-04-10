// You are given an integer array arr[] of size n, representing n number of people in a party, each person is denoted by an integer. Couples are represented by the same number ie: two people have the same integer value, it means they are a couple. Find out the only single person in the party of couples.

// NOTE: It is guarantee that there exist only one single person in the party.

//User function Template for Java

class Solution {
    static int findSingle(int n, int arr[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i]) == true)
                map.put(arr[i], map.get(arr[i]) + 1);
            if (map.containsKey(arr[i]) == false)
                map.put(arr[i], 1);
            if (map.get(arr[i]) == 2)
                map.remove(arr[i]);
        }
        return map.keySet().stream().findFirst().get();
    }
}