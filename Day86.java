// Given a Binary Tree of nodes, you need to find all the possible paths from the root node to all the leaf nodes of the binary tree.

class Solution {

    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        // code here,
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> sublist = new ArrayList<Integer>();
        traverse(root, sublist, list);
        return list;
    }

    public static void traverse(Node node, ArrayList<Integer> sublist, ArrayList<ArrayList<Integer>> list) {
        if (node == null)
            return;
        sublist.add(node.data);
        if (node.left == null && node.right == null) {
            list.add(new ArrayList<>(sublist));
            sublist.remove(sublist.size() - 1);
            return;
        }
        traverse(node.left, new ArrayList<>(sublist), list);
        traverse(node.right, new ArrayList<>(sublist), list);

    }
}