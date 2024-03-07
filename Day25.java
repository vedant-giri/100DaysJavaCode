// Given a string S consisting of the characters 0, 1 and 2. Your task is to find the length of the smallest substring of string S that contains all the three characters 0, 1 and 2. If no such substring exists, then return -1.

class Solution {
    public int smallestSubstring(String S) {
        // Code here
        int[] count = new int[3];
        int min = Integer.MAX_VALUE;
        int left = 0;
        int unique = 0;
        for (int i = 0; i < S.length(); i++) {
            char currChar = S.charAt(i);
            if (count[currChar - '0'] == 0) {
                unique++;
            }
            count[currChar - '0']++;

            while (unique == 3) {
                min = Math.min(min, i - left + 1);
                char leftChar = S.charAt(left);
                count[leftChar - '0']--;
                if (count[leftChar - '0'] == 0) {
                    unique--;
                }

                left++;
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
};
