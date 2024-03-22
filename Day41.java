// Given a binary tree having n nodes. Check whether all of its nodes have the value equal to the sum of their child nodes. Return 1 if all the nodes in the tree satisfy the given properties, else it return 0.

// For every node, data value must be equal to the sum of data values in left and right children. Consider data value as 0 for NULL child.  Also, leaves are considered to follow the property.

//User function Template for Java

/*Complete the function below
Node is as follows:
class Node{
	int data;
	Node left,right;
	
	Node(int key)
	{
	    data = key;
	    left = right = null;
	}
}

*/
class Solution {
    // Function to check whether all nodes of a tree have the value
    // equal to the sum of their child nodes.
    public static int isSumProperty(Node root) {
        // add your code here
        if (root == null)
            return 1;
        if (helper(root))
            return 1;

        return 0;

    }

    public static boolean helper(Node root) {
        if (root == null)
            return true;

        if (root.left == null && root.right == null)
            return true;

        int left = root.left != null ? root.left.data : 0;
        int right = root.right != null ? root.right.data : 0;

        if (root.data == left + right && helper(root.left) && helper(root.right))
            return true;

        return false;
    }
}