// Given a string s, remove all its adjacent duplicate characters recursively. 

// Note: For some test cases, the resultant string would be an empty string. In that case, the function should return the empty string only.

class Solution {
    public String rremove(String s) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            int j = i + 1;

            while (j < s.length() && s.charAt(j) == s.charAt(i)) {
                j++;
            }

            if (j - i > 1) {
                i = j;
            } else {

                result.append(s.charAt(i));
                i++;
            }
        }

        return result.length() == s.length() ? result.toString() : rremove(result.toString());
    }
}