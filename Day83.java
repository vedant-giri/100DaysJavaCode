
// Given a binary tree having n nodes, find the vertical sum of the nodes that are in the same vertical line. Return all sums through different vertical lines starting from the left-most vertical line to the right-most vertical line.

class Solution {
    public ArrayList<Integer> verticalSum(Node root) {
        // add your code here
        HashMap<Integer, Integer> hm = new HashMap<>();

        // BFS
        Queue<Item> q = new LinkedList<>();
        q.add(new Item(root, 0));

        while (!q.isEmpty()) {

            Item node = q.poll();
            Node u = node.u;
            int line = node.line;

            if (!hm.containsKey(line)) {
                hm.put(line, u.data);
            } else {
                hm.put(line, hm.get(line) + u.data);
            }

            if (u.left != null)
                q.add(new Item(u.left, line - 1));
            if (u.right != null)
                q.add(new Item(u.right, line + 1));

        }

        ArrayList<Integer> temp = new ArrayList<>(hm.keySet());
        Collections.sort(temp);

        ArrayList<Integer> ans = new ArrayList<>();

        for (int ele : temp) {
            ans.add(hm.get(ele));
        }

        return ans;
    }

    class Item {
        Node u;
        int line;

        Item(Node u, int line) {
            this.u = u;
            this.line = line;
        }
    }
}
