// Given a Binary Tree of size N, You have to count leaves in it. For example, there are two leaves in following tree

/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
}*/

class Tree {
    int countLeaves(Node node) {
        // Your code
        int[] count = new int[1];
        totalCount(node, count);
        return count[0];
    }

    void totalCount(Node node, int[] count) {
        if (node == null)
            return;
        if (node.left == null && node.right == null) {
            count[0]++;
            return;
        }

        totalCount(node.left, count);
        totalCount(node.right, count);

    }
}
