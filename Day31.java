// public Given a Binary Tree, find its Boundary Traversal. The traversal should be in the following order: 

// Left boundary nodes: defined as the path from the root to the left-most node ie- the leaf node you could reach when you always travel preferring the left subtree over the right subtree. 
// Leaf nodes: All the leaf nodes except for the ones that are part of left or right boundary.
// Reverse right boundary nodes: defined as the path from the right-most node to the root. The right-most node is the leaf node you could reach when you always travel preferring the right subtree over the left subtree. Exclude the root from this as it was already included in the traversal of left boundary nodes.
// Note: If the root doesn't have a left subtree or right subtree, then the root itself is the left or right boundary. 

//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 

//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

class Solution {
    ArrayList<Integer> boundary(Node node) {
        ArrayList<Integer> list = new ArrayList<>();
        if (node == null)
            return list;

        list.add(node.data);

        leftBoundary(node.left, list);

        leaves(node.left, list);
        leaves(node.right, list);

        rightBoundary(node.right, list);

        return list;
    }

    void leftBoundary(Node node, ArrayList<Integer> list) {
        if (node == null || (node.left == null && node.right == null))
            return;

        list.add(node.data);

        if (node.left == null) {
            leftBoundary(node.right, list);
        } else {
            leftBoundary(node.left, list);
        }
    }

    void leaves(Node node, ArrayList<Integer> list) {
        if (node == null)
            return;
        if (node.left == null && node.right == null)
            list.add(node.data);
        leaves(node.left, list);

        leaves(node.right, list);
    }

    void rightBoundary(Node node, ArrayList<Integer> list) {
        if (node == null || (node.left == null && node.right == null))
            return;

        if (node.right == null) {
            rightBoundary(node.left, list);
        } else {
            rightBoundary(node.right, list);
        }

        list.add(node.data);
    }
}