class Tree {
    ArrayList<Integer> noSibling(Node node) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        if (node == null)
            return list;

        helperSib(node, list);

        if (list.isEmpty())
            list.add(-1);
        Collections.sort(list);
        return list;

    }

    void helperSib(Node node, ArrayList<Integer> list) {
        if (node == null)
            return;

        if (node.left != null && node.right == null)
            list.add(node.left.data);
        else if (node.right != null && node.left == null)
            list.add(node.right.data);

        helperSib(node.left, list);
        helperSib(node.right, list);

    }
}
