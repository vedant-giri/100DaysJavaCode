// Given two arrays a and b both of size n. Given q queries in an arrray query each having a positive integer x denoting an index of the array a. For each query, your task is to find all the elements less than or equal to a[x] in the array b.


//User function Template for Java


class Solution
{
    public static int[] countElements(int a[], int b[], int n, int query[], int q)
    {
        int[] ans = new int[q];

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(b[i])) {
                map.put(b[i], map.get(b[i]) + 1);
            } else {
                map.put(b[i], 1);
            }
        }
        int total = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            total += entry.getValue();
            entry.setValue(total);
        }

        for (int i = 0; i < q; i++) {
            int searchNum = a[query[i]];
            SortedMap<Integer, Integer> integerIntegerSortedMap = map.headMap(searchNum + 1);
            Integer i1 = null;
            if(!integerIntegerSortedMap.isEmpty()) {
                i1 = integerIntegerSortedMap.lastKey();
            }
            if (Objects.nonNull(i1)) ans[i] = map.get(i1);
        }
        
        return ans;
        
    }
}
