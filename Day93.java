
//User function Template for Java

class Solution {
    static class DisjointSet {
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        public DisjointSet(int n) {
            for (int i = 0; i < n; i++) {
                parent.add(i);
                size.add(1);
            }
        }

        public int findUP(int node) {
            if (node == parent.get(node))
                return node;

            int uP = findUP(parent.get(node));
            parent.set(node, uP);
            return parent.get(node);
        }

        public void unionBySize(int u, int v) {
            int uPu = findUP(u);
            int uPv = findUP(v);
            if (uPu == uPv)
                return;
            if (size.get(uPu) > size.get(uPv)) {
                parent.set(uPv, uPu);
                size.set(uPu, size.get(uPu) + size.get(uPv));
            } else {
                parent.set(uPu, uPv);
                size.set(uPv, size.get(uPv) + size.get(uPu));
            }
        }

    }

    static List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        HashMap<String, Integer> mapMailNode = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                if (mapMailNode.containsKey(mail)) {
                    ds.unionBySize(i, mapMailNode.get(mail));
                } else {
                    mapMailNode.put(mail, i);
                }
            }
        }

        ArrayList<String>[] mergedMail = new ArrayList[n];
        for (int i = 0; i < n; i++)
            mergedMail[i] = new ArrayList<>();
        for (Map.Entry<String, Integer> it : mapMailNode.entrySet()) {
            String mail = it.getKey();
            int node = ds.findUP(it.getValue());
            mergedMail[node].add(mail);
        }

        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (mergedMail[i].size() == 0)
                continue;
            Collections.sort(mergedMail[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            temp.addAll(mergedMail[i]);
            ans.add(temp);
        }
        return ans;
    }

}
