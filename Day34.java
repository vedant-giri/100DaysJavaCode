// Given a binary tree, print the bottom view from left to right.
// A node is included in bottom view if it can be seen when we look at the tree from bottom.

//                       20
//                     /    \
//                   8       22
//                 /   \        \
//               5      3       25
//                     /   \      
//                   10    14

// For the above tree, the bottom view is 5 10 3 14 25.
// If there are multiple bottom-most nodes for a horizontal distance from root, then print the later one in level traversal. For example, in the below diagram, 3 and 4 are both the bottommost nodes at horizontal distance 0, we need to print 4.

//                       20
//                     /    \
//                   8       22
//                 /   \     /   \
//               5      3 4     25
//                      /    \      
//                  10       14

// For the above tree the output should be 5 10 4 14 25.

// Note: The Input/Output format and Example given are used for the system's internal purpose, and should be used by a user for Expected Output only. As it is a function problem, hence a user should not read any input from the stdin/console. The task is to complete the function specified, and not to write the full code.

class Solution {
    // Function to return a list containing the bottom view of the given tree.
    static class Pair {
        Node node;
        int level;

        public Pair(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public ArrayList<Integer> bottomView(Node root) {
        // Code here
        ArrayList<Integer> list = new ArrayList<>();

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair p = q.remove();
            Node node = p.node;
            int level = p.level;
            map.put(level, node.data);
            if (node.left != null)
                q.add(new Pair(node.left, level - 1));
            if (node.right != null)
                q.add(new Pair(node.right, level + 1));

        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(entry.getValue());
        }

        return list;
    }
}