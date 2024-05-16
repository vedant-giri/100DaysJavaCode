// Given a tree with n nodes and edge connection between them . The tree is rooted at node 1. Your task is to remove minimum number of edges from the given tree such that the tree converts into disjoint union tree so that nodes of connected component left is divisible by 2. 

class Solution {
    private int dfs(List<List<Integer>> adj, int u, int prt, int[] ans) {
        int count = 0;
        for (int v : adj.get(u)) {
            if (v != prt) {
                int x = dfs(adj, v, u, ans);
                if (x % 2 == 0) {
                    ans[0]++;
                } else {
                    count += x;
                }
            }
        }
        return count + 1;
    }

    public int minimumEdgeRemove(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[1] - 1).add(edge[0] - 1);
            adj.get(edge[0] - 1).add(edge[1] - 1);
        }

        int[] ans = new int[1];
        dfs(adj, 0, -1, ans);
        return ans[0];
    }
}