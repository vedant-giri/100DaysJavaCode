// Given two binary trees with head reference as T and S having at most N nodes. The task is to check if S is present as subtree in T.
// A subtree of a tree T1 is a tree T2 consisting of a node in T1 and all of its descendants in T1.

//User function Template for Java

/*complete the given function*/

/* class Node{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=null;
        right=null;
    }
}*/

class Solution {
    public static boolean isSubtree(Node T, Node S) {
        // add code here.
        boolean subtree = false;

        if (T != null && S != null && T.data == S.data) {
            subtree = equal(T, S);
        }

        if (!subtree && T != null) {
            return (isSubtree(T.left, S) || isSubtree(T.right, S));
        }

        return subtree;

    }

    public static boolean equal(Node n1, Node n2) {
        if (n1 == null && n2 == null)
            return true;
        if (n1 != null && n2 != null && n1.data == n2.data && equal(n1.left, n2.left) && equal(n1.right, n2.right))
            return true;

        return false;
    }
}
