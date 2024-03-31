// Given the root of a binary search tree and a number n, find the greatest number in the binary search tree that is less than or equal to n. 

// User function Template for Java

/*class Node
{
    int key;
    Node left, right;

    Node(int x)
    {
        key = x;
        left = right = null;
    }

}*/
class Solution {
    public static int findMaxForN(Node root, int n) {
        // Base case: if the root is null, return -1
        if (root == null)
            return -1;

        // If the current node's value is greater than n,
        // explore the left subtree
        if (root.key > n)
            return findMaxForN(root.left, n);
        else {
            // If the current node's value is less than or equal to n,
            // it could potentially be the greatest value <= n.
            // So, we explore the right subtree to find a better candidate.
            int maxFound = findMaxForN(root.right, n);
            // If a better candidate is found in the right subtree, return it.
            // Otherwise, the current node is the greatest value <= n.
            if (maxFound != -1)
                return maxFound;
            else
                return root.key;
        }
    }
}
