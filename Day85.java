// Given a binary tree of size n, find its reverse level order traversal. ie- the traversal must begin from the last level.

class Tree {
    public ArrayList<Integer> reverseLevelOrder(Node node) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        if (node == null)
            return list;
        Stack<Integer> stack = new Stack<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node curr = queue.remove();
            if (curr.right != null)
                queue.add(curr.right);
            if (curr.left != null)
                queue.add(curr.left);
            stack.push(curr.data);
        }

        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }

        return list;
    }
}