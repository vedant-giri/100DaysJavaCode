// Given a Binary Tree, find the vertical traversal of it starting from the leftmost level to the rightmost level.
// If there are multiple nodes passing through a vertical line, then they should be printed as they appear in level order traversal of the tree.

class Solution {
    static class Pair {
        Node node;
        int level;

        public Pair(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    // Function to find the vertical order traversal of Binary Tree.
    static ArrayList<Integer> verticalOrder(Node root) {
        // add your code here
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null)
            return list;

        Queue<Pair> q = new LinkedList<>();
        Map<Integer, ArrayList<Integer>> store = new HashMap<>();

        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair curr = q.remove();
            int level = curr.level;
            Node node = curr.node;

            if (!store.containsKey(level)) {
                store.put(level, new ArrayList<>());
            }
            store.get(level).add(node.data);

            if (node.left != null)
                q.add(new Pair(node.left, level - 1));
            if (node.right != null)
                q.add(new Pair(node.right, level + 1));
        }

        List<Integer> sortedLevels = new ArrayList<>(store.keySet());
        Collections.sort(sortedLevels);

        for (int level : sortedLevels) {
            list.addAll(store.get(level));
        }

        return list;

    }
}