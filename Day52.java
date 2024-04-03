// Given a BST with n (n>=2) nodes, find the kth common ancestor of nodes x and y in the given tree. Return -1 if kth ancestor does not exists.

// Nodes x and y will always be present in input BST, and x != y.

class Solution {

    public int kthCommonAncestor(Node root, int k, int x, int y) {
        ArrayList<Integer> arr = new ArrayList<>();
        Node t = root;
        int mn = Math.min(x, y);
        int mx = Math.max(x, y);

        while (t != null) {
            if (t.data < mn) {
                arr.add(t.data);
                t = t.right;
            } else if (t.data > mx) {
                arr.add(t.data);
                t = t.left;
            } else {
                arr.add(t.data);
                if (k > arr.size())
                    return -1;
                return arr.get(arr.size() - k);
            }
        }

        return -1;
    }
}
