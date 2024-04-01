// Given a binary tree with n nodes, find the number of pairs violating the BST property.
// BST has the following properties:-

// Every node is greater than its left child and less than its right child.
// Every node is greater than the maximum value of in its left subtree and less than the minimum value in its right subtree.
// The maximum in the left sub-tree must be less than the minimum in the right subtree.

/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/
class Solution {
    public long merge(int[] arr, int s, int mid, int e) {
        long[] temp = new long[e - s + 1];
        int i = s;
        int j = mid + 1;
        int k = 0;
        long inversion = 0;

        while (i <= mid && j <= e) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                inversion += (mid - i + 1);
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= e) {
            temp[k++] = arr[j++];
        }

        for (int l = s; l <= e; l++) {
            arr[l] = (int) temp[l - s];
        }

        return inversion;
    }

    public long mergeSort(int[] arr, int s, int e) {
        long inversion = 0;

        if (s < e) {
            int mid = s + (e - s) / 2;
            inversion += mergeSort(arr, s, mid);
            inversion += mergeSort(arr, mid + 1, e);
            inversion += merge(arr, s, mid, e);
        }

        return inversion;
    }

    public int numberOfInversions(int[] a, int n) {
        return (int) mergeSort(a, 0, n - 1);
    }

    public void inorder(Node root, ArrayList<Integer> nodes) {
        if (root == null)
            return;
        inorder(root.left, nodes);
        nodes.add(root.data);
        inorder(root.right, nodes);
    }

    /* You are required to complete below function */
    public int pairsViolatingBST(int n, Node root) {
        ArrayList<Integer> nodes = new ArrayList<>();
        inorder(root, nodes);
        return numberOfInversions(nodes.stream().mapToInt(i -> i).toArray(), n);
    }
}
