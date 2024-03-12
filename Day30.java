// Given a root of a binary tree with n nodes, find its level order traversal.
// Level order traversal of a tree is breadth-first traversal for the tree.

//User function Template for Java

/*
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
class Solution {
    // Function to return the level order traversal of a tree.
    static ArrayList<Integer> levelOrder(Node root) {
        // Your code here
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node curr = queue.remove();
            if (curr.left != null)
                queue.add(curr.left);
            if (curr.right != null)
                queue.add(curr.right);
            list.add(curr.data);
        }
        return list;
    }

}
