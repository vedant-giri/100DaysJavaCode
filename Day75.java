
// Given Pointer/Reference to the head of a doubly linked list of n nodes, the task is to Sort the given doubly linked list using Merge Sort in both non-decreasing and non-increasing order.

class Solution {
    // Function to sort the given doubly linked list using Merge Sort.
    static Node sortDoubly(Node head) {
        // add your code here
        Node curr = head;
        List<Integer> list = new ArrayList<>();
        while (curr != null) {
            list.add(curr.data);
            curr = curr.next;
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        mergeSort(arr, 0, arr.length);

        Node node = new Node(arr[0]);
        Node current = node;
        for (int i = 1; i < arr.length; i++) {
            current.next = new Node(arr[i]);
            current.next.prev = current;
            current = current.next;
        }
        return node;
    }

    static void mergeSort(int[] arr, int s, int e) {
        if (e - s == 1)
            return;

        int m = s + (e - s) / 2;

        mergeSort(arr, s, m);
        mergeSort(arr, m, e);

        merge(arr, s, m, e);
    }

    static void merge(int[] arr, int s, int m, int e) {
        int[] mix = new int[e - s];

        int i = s;
        int j = m;
        int k = 0;

        while (i < m && j < e) {
            if (arr[i] < arr[j]) {
                mix[k] = arr[i];
                i++;
            } else {
                mix[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i < m) {
            mix[k] = arr[i];
            i++;
            k++;
        }
        while (j < e) {
            mix[k] = arr[j];
            j++;
            k++;
        }

        for (int l = 0; l < mix.length; l++) {
            arr[s + l] = mix[l];
        }

    }
}