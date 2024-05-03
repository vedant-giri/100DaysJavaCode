// Given a binary tree having n nodes and an integer k. Print all nodes that are at distance k from the root (root is considered at distance 0 from itself). Nodes should be printed from left to right.

/*
class Node
{
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */

class Tree {
    // Recursive function to print right view of a binary tree.
    ArrayList<Integer> Kdistance(Node root, int k) {
        // Your code here
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        if (k == 0) {
            list.add(root.data);
            return list;
        }
        helper(root.left, list, k);
        helper(root.right, list, k);
        return list;

    }

    void helper(Node root, ArrayList<Integer> list, int k) {
        if (root == null)
            return;

        k--;
        if (k == 0) {
            list.add(root.data);
            return;
        }

        helper(root.left, list, k);
        helper(root.right, list, k);
    }
}
