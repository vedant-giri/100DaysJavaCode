// Given an array arr of n integers, count all pairs (arr[i], arr[j]) in it such that i*arr[i] > j*arr[j] and 0 ≤ i < j < n.

// Note: 0-based Indexing is followed.

class Solution {
    int merge(int arr[], int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int count = 0;
        int i = low, j = mid + 1;
        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                temp.add(arr[i]);
                i++;
            } else {
                temp.add(arr[j]);
                j++;
                count += mid - i + 1;
            }
        }

        while (i <= mid)
            temp.add(arr[i++]);
        while (j <= high)
            temp.add(arr[j++]);

        for (int k = low; k <= high; k++) {
            arr[k] = temp.get(k - low);
        }

        return count;
    }

    int mergeSort(int arr[], int low, int high) {
        if (low < high) {
            int count = 0;
            int mid = (low + high) / 2;
            count += mergeSort(arr, low, mid);
            count += mergeSort(arr, mid + 1, high);
            count += merge(arr, low, mid, high);
            return count;
        }
        return 0;
    }

    public int countPairs(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] * i;
        }
        int count = mergeSort(arr, 0, n - 1);
        return count;
    }
}
