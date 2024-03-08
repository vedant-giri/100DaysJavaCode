// Given a string S. The task is to print all unique permutations of the given string that may contain dulplicates in lexicographically sorted order. 

class Solution {
    public List<String> find_permutation(String S) {
        // Code here
        Set<String> ans = new HashSet<>();
        helper(ans, "", S);

        List<String> result = new ArrayList<>();

        for (String str : ans) {
            result.add(str);
        }
        Collections.sort(result);

        return result;
    }

    public void helper(Set<String> ans, String p, String up) {
        if (up.isEmpty()) {
            ans.add(p);
            return;
        }

        char ch = up.charAt(0);

        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            helper(ans, f + ch + s, up.substring(1));
        }
    }
}