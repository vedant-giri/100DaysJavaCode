// Given the root of a Binary Search Tree. The task is to find the minimum valued element in this given BST.



/*
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/
class Solution {
    // Function to find the minimum element in the given BST.
    int minValue(Node root) {
        // code here
        if(root==null) return 0;
        if(root.left==null) return root.data;
        return minValue(root.left);
        
    }
}
